package am.itspace.restexample.mapper;

import am.itspace.restexample.dto.CreateUserDto;
import am.itspace.restexample.dto.UserDto;
import am.itspace.restexample.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(CreateUserDto createUserDto);
    UserDto map(User user);


}
