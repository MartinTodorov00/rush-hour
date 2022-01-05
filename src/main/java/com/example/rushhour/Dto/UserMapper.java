package com.example.rushhour.Dto;

import com.example.rushhour.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
//
//    @Mappings({
//            @Mapping(target="firstName", source="userRequestDto.firstName"),
//            @Mapping(target="lastName", source="userRequestDto.lastName"),
//            @Mapping(target="email", source="userRequestDto.email"),
//            @Mapping(target="password", source="userRequestDto.password"),
//    })
    @Mappings({})
    User mapUserDtoToUser(UserRequestDto userRequestDto);

//    @Mappings({
//            @Mapping(target = "id", source = "id"),
//            @Mapping(target = "firstName", source = "firstName"),
//            @Mapping(target = "lastName", source = "lastName"),
//            @Mapping(target = "email", source = "email"),
//    })
    @Mappings({})
    UserResponseDto mapUserToUserDto(User user);

    List<UserResponseDto> mapUserListToUserResponseDtoList(List<User> users);
}
