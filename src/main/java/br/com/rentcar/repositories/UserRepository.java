package br.com.rentcar.repositories;

import br.com.rentcar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByLogin(String login);

    public User findByEmail(String email);
}
