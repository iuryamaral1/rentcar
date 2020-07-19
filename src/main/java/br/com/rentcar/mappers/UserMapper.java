package br.com.rentcar.mappers;

import br.com.rentcar.dto.InputUserDto;
import br.com.rentcar.dto.OutputUserDto;
import br.com.rentcar.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends br.com.rentcar.mappers.Mapper<User, InputUserDto, OutputUserDto, UserMapper> {

    @Override
    @Mappings( {
            @Mapping(target = "userId",        source = "entity.id"),
            @Mapping(target = "userFirstName", source = "entity.firstName"),
            @Mapping(target = "userLastName",  source = "entity.lastName"),
            @Mapping(target = "userEmail",     source = "entity.email"),
            @Mapping(target = "userBirthDate", source = "entity.birthDay"),
            @Mapping(target = "userLogin",     source = "entity.login"),
            @Mapping(target = "userPhone",     source = "entity.phone")
    } )
    OutputUserDto entityToOutputDto(User entity);

    @Override
    @Mappings( {
            @Mapping(target = "firstName",        source = "inputDto.firstNameUser"),
            @Mapping(target = "lastName",         source = "inputDto.lastNameUser") ,
            @Mapping(target = "email"   ,         source = "inputDto.usermail")     ,
            @Mapping(target = "birthDay",         source = "inputDto.birthDateUser"),
            @Mapping(target = "login"   ,         source = "inputDto.loginUser")    ,
            @Mapping(target = "password",         source = "inputDto.passUser")     ,
            @Mapping(target = "phone"   ,         source = "inputDto.phoneContactUser")
    } )
    User inputDtoToEntity(InputUserDto inputDto);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings( {
            @Mapping(target = "firstName",        source = "dto.firstNameUser"),
            @Mapping(target = "lastName",         source = "dto.lastNameUser") ,
            @Mapping(target = "email"   ,         source = "dto.usermail")     ,
            @Mapping(target = "birthDay",         source = "dto.birthDateUser"),
            @Mapping(target = "login"   ,         source = "dto.loginUser")    ,
            @Mapping(target = "password",         source = "dto.passUser")     ,
            @Mapping(target = "phone",            source = "dto.phoneContactUser")
    } )
    void updateEntityFromDto(InputUserDto dto, @MappingTarget User user);

    @Override
    default Class<UserMapper> getMapperClass() { return UserMapper.class; }
}
