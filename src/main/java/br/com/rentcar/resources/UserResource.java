package br.com.rentcar.resources;

import br.com.rentcar.dto.InputUserDto;
import br.com.rentcar.dto.OutputUserDto;
import br.com.rentcar.mappers.UserMapper;
import br.com.rentcar.model.User;
import br.com.rentcar.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource extends AbstractResource<User, InputUserDto, OutputUserDto, UserMapper, UserService> {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
