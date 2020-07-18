package br.com.rentcar.mappers;

import br.com.rentcar.dto.InputDto;
import br.com.rentcar.dto.OutputDto;
import org.mapstruct.factory.Mappers;

public interface Mapper<E, IDto extends InputDto, ODto extends OutputDto, M extends Mapper> {

    ODto entityToOutputDto(E entity);
    E inputDtoToEntity(IDto inputDto);
    Class<M> getMapperClass();

    default Mapper getMapper() {
        return Mappers.getMapper(getMapperClass());
    }

}
