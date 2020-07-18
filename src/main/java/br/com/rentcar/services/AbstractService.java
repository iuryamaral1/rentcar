package br.com.rentcar.services;

import br.com.rentcar.exceptions.LoginAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<E, ER extends JpaRepository<E, Long>> {

    @Autowired
    protected ER repository;

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public E create(E e) throws Exception {
        try {
            return repository.save(e);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public E update(E e) {
        return repository.save(e);
    }

    public void delete(E e) {
        repository.delete(e);
    }
}
