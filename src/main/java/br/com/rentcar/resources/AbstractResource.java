package br.com.rentcar.resources;

import br.com.rentcar.dto.InputDto;
import br.com.rentcar.dto.OutputDto;
import br.com.rentcar.mappers.Mapper;
import br.com.rentcar.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class AbstractResource<T, IDto extends InputDto, ODto extends OutputDto, M extends Mapper, S extends AbstractService> {

    @Autowired
    protected M mapper;

    @Autowired
    protected S service;

    @GetMapping(produces = { APPLICATION_JSON_VALUE })
    public List<T> findAll() {
        return Collections.emptyList();
    }

    @PostMapping(consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response create(@RequestBody IDto iDto) {
        Object object = service.create(mapper.getMapper().inputDtoToEntity(iDto));
        Object outputObject = mapper.entityToOutputDto(object);
        return Response.ok(outputObject).build();
    }

    @PutMapping(consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response update() {
        return Response.ok().build();
    }

    @DeleteMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response delete() {
        return Response.ok().build();
    }

    protected T createEntity() {
        try {
            return getEntityClass().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Class<T> getEntityClass();
}
