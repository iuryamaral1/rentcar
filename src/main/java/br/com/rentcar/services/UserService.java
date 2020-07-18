package br.com.rentcar.services;

import br.com.rentcar.model.User;
import br.com.rentcar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User create(User user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return super.create(user);
    }
}
