package br.com.rentcar.mappers;

import br.com.rentcar.dto.InputDto;
import br.com.rentcar.dto.OutputDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

public interface Mapper<E, IDto extends InputDto, ODto extends OutputDto, M extends Mapper> {

    ODto entityToOutputDto(E entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E inputDtoToEntity(IDto inputDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(IDto inputDto, @MappingTarget E e);

    Class<M> getMapperClass();

    default Mapper getMapper() {
        return Mappers.getMapper(getMapperClass());
    }

}
