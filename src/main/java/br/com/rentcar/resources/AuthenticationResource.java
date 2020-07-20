package br.com.rentcar.resources;

import br.com.rentcar.dto.OutputUserDto;
import br.com.rentcar.mappers.UserMapper;
import br.com.rentcar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class AuthenticationResource {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/me", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Response me() {
        User loggedIinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OutputUserDto outputUserDto = userMapper.entityToOutputDto(loggedIinUser);
        return Response.ok().entity(outputUserDto).build();
    }
}
