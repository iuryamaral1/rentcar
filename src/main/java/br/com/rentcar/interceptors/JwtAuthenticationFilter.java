package br.com.rentcar.interceptors;

import br.com.rentcar.config.JwtTokenProvider;
import br.com.rentcar.dto.InputUserCredentialsDto;
import br.com.rentcar.errors.ErrorResponse;
import br.com.rentcar.model.User;
import br.com.rentcar.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
                                   UserService userService) {
        setAuthenticationFailureHandler(new JwtAuthenticationFailureFilter());
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            InputUserCredentialsDto credentialsDto = new ObjectMapper().readValue(request.getInputStream(), InputUserCredentialsDto.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(credentialsDto.getUsername(), credentialsDto.getPwd(), new ArrayList<>());

            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((User) authResult.getPrincipal()).getUsername();
        String token = jwtTokenProvider.generateToken(username);
        User userByLogin = this.userService.findByLogin(username);
        userByLogin.setLastLogin(new Date());
        this.userService.update(userByLogin);
        response.addHeader("Authorization", "Bearer " + token);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    private class JwtAuthenticationFailureFilter implements AuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED);
            errorResponse.setErrorMessageList(Collections.singletonList("Invalid login or password"));
            response.setStatus(401);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().append(new ObjectMapper().writeValueAsString(errorResponse));
        }
    }
}
