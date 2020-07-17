package br.com.rentcar.services;

import br.com.rentcar.model.User;
import br.com.rentcar.repositories.UserRepository;

public class UserService extends AbstractService<User, UserRepository> {

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }
}
