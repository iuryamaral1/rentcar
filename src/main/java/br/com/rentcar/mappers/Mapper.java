package br.com.rentcar.mappers;

import br.com.rentcar.dto.InputDto;
import br.com.rentcar.dto.OutputDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface Mapper<E, IDto extends InputDto, ODto extends OutputDto> {

    ODto entityToOutputDto(E entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E inputDtoToEntity(IDto inputDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(IDto inputDto, @MappingTarget E e);
}
