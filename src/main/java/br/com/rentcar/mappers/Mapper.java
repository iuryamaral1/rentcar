package br.com.rentcar.mappers;

public interface Mapper<E, IDto, ODto> {

    ODto entityToOutputDto(E entity);
    E inputDtoToEntity(IDto inputDto);
}
