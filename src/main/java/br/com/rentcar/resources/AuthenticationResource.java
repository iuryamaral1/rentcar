package br.com.rentcar.resources;

import br.com.rentcar.config.JwtTokenProvider;
import br.com.rentcar.dto.InputUserCredentialsDto;
import br.com.rentcar.model.User;
import br.com.rentcar.payload.JwtAuthenticationResponse;
import br.com.rentcar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AuthenticationResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticate(@RequestBody InputUserCredentialsDto loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPwd()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(((User) authentication.getPrincipal()).getUsername());

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);

            User user = null;

            if (jwtAuthenticationResponse.getAccessToken() != null && !jwtAuthenticationResponse.getAccessToken().isEmpty()) {
                User userFound = this.userService.findByLogin(loginRequest.getUsername());
                if (!Objects.isNull(userFound)) {
                    userFound.setToken(jwtAuthenticationResponse.getAccessToken());
                    userFound.setLastLogin(new Date());
                    user = this.userService.update(user);
                }
            }

            return ResponseEntity.ok(user);
        } catch (BadCredentialsException error) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
