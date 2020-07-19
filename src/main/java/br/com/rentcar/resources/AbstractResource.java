package br.com.rentcar.resources;

import br.com.rentcar.dto.InputDto;
import br.com.rentcar.dto.OutputDto;
import br.com.rentcar.errors.ErrorResponse;
import br.com.rentcar.mappers.Mapper;
import br.com.rentcar.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class AbstractResource<T, IDto extends InputDto, ODto extends OutputDto, M extends Mapper, S extends AbstractService> {

    @Autowired
    protected M mapper;

    @Autowired
    protected S service;

    @GetMapping(produces = { APPLICATION_JSON_VALUE })
    public Response findAll() {
        List<T> allObjects = service.findAll();
        List<OutputDto> objOutputDtoList = allObjects.stream().map(obj -> mapper.getMapper().entityToOutputDto(obj))
                .collect(Collectors.toList());
        return Response.ok().entity(objOutputDtoList).build();
    }

    @GetMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE })
    public Response findById(@PathVariable("id") Long id) {
        Object objectFound = service.findOne(id);

        if (Objects.isNull(objectFound)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        OutputDto objectOutputDto = mapper.entityToOutputDto(objectFound);
        return Response.ok().entity(objectOutputDto).build();
    }

    @PostMapping(consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response create(@RequestBody IDto iDto) throws Exception {
        try {
            Object object = service.create(mapper.getMapper().inputDtoToEntity(iDto));
            OutputDto outputObject = mapper.entityToOutputDto(object);
            return Response.status(Response.Status.CREATED).entity(outputObject).build();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    @PutMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response update(@RequestBody IDto idto, @PathVariable("id") Long id) {
        Object objectFound = service.findOne(id);
        mapper.updateEntityFromDto(idto, objectFound);
        Object updatedObject = service.update(objectFound);
        OutputDto outputDto = mapper.entityToOutputDto(updatedObject);
        return Response.ok().entity(outputDto).build();
    }

    @DeleteMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
    public Response delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return Response.ok().build();
    }

    protected abstract Class<T> getEntityClass();
}
