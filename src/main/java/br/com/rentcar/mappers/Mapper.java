package br.com.rentcar.mappers;

import org.mapstruct.factory.Mappers;

import java.util.function.Function;

public interface Mapper<E, IDto, ODto, M extends Mapper> {

    ODto entityToOutputDto(E entity);
    E inputDtoToEntity(IDto inputDto);
    Class<M> getMapperClass();

    default Mapper getMapper() {
        return Mappers.getMapper(getMapperClass());
    }

}
