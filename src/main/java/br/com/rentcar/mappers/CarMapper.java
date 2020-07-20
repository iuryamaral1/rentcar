package br.com.rentcar.mappers;

import br.com.rentcar.dto.InputCarDto;
import br.com.rentcar.dto.OutputCarDto;
import br.com.rentcar.model.Car;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CarMapper extends br.com.rentcar.mappers.Mapper<Car, InputCarDto, OutputCarDto>{

    @Override
    @Mappings({
            @Mapping(target = "idCar",           source = "entity.id"),
            @Mapping(target = "userCar",         source = "entity.user"),
            @Mapping(target = "yearCar",         source = "entity.year"),
            @Mapping(target = "modelCar",        source = "entity.model"),
            @Mapping(target = "colorCar",        source = "entity.color"),
            @Mapping(target = "licensePlateCar", source = "entity.licensePlate"),
    } )
    OutputCarDto entityToOutputDto(Car entity);

    @Override
    @Mappings( {
            @Mapping(target = "year",            source = "dto.yearCar"),
            @Mapping(target = "user",            source = "dto.userCar"),
            @Mapping(target = "model",           source = "dto.modelCar"),
            @Mapping(target = "color",           source = "dto.colorCar"),
            @Mapping(target = "licensePlate",    source = "dto.licensePlateCar")
    } )
    Car inputDtoToEntity(InputCarDto dto);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings( {
            @Mapping(target = "year",            source = "dto.yearCar"),
            @Mapping(target = "user",            source = "dto.userCar"),
            @Mapping(target = "model",           source = "dto.modelCar"),
            @Mapping(target = "color",           source = "dto.colorCar"),
            @Mapping(target = "licensePlate",    source = "dto.licensePlateCar")
    } )
    void updateEntityFromDto(InputCarDto dto, @MappingTarget Car car);

}
