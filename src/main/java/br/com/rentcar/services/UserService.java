package br.com.rentcar.services;

import br.com.rentcar.exceptions.EmailAlreadyExistException;
import br.com.rentcar.exceptions.LoginAlreadyExistException;
import br.com.rentcar.model.Profile;
import br.com.rentcar.model.User;
import br.com.rentcar.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserService extends AbstractService<User, UserRepository> implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public boolean loginAlreadyExists(String login) {
        User userByLogin = repository.findByLogin(login);
        return userByLogin != null && userByLogin.getId() != null;
    }

    public boolean emailAlreadyExists(String email) {
        User userByEmail = repository.findByEmail(email);
        return userByEmail != null && userByEmail.getId() != null;
    }

    @Override
    public User create(User user) throws Exception {

        if (loginAlreadyExists(user.getLogin())) {
            throw new LoginAlreadyExistException();
        }

        if (emailAlreadyExists(user.getEmail())) {
            throw new EmailAlreadyExistException();
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            throw new Exception("A senha é obrigatória");
        }

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        user.addProfile(Profile.USER);
        return super.create(user);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User userByLogin = repository.findByLogin(login);
        if (userByLogin == null) {
            throw new UsernameNotFoundException("Usuário com login " + login + " não foi encontrado");
        }
        return userByLogin;
    }
}
