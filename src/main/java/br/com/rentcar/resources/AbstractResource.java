package br.com.rentcar.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class AbstractResource<T> {

    @GetMapping(produces = { APPLICATION_JSON_VALUE })
    public List<T> findAll() {
        return Collections.emptyList();
    }

    @PostMapping(consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response create() {
        return Response.ok().build();
    }

    @PutMapping(consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response update() {
        return Response.ok().build();
    }

    @DeleteMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response delete() {
        return Response.ok().build();
    }
}
