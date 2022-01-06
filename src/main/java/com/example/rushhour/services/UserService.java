package com.example.rushhour.services;

import com.example.rushhour.Dto.UserRequestDto;
import com.example.rushhour.Dto.UserResponseDto;
import com.example.rushhour.entities.User;

import java.util.List;

public interface UserService {

    UserResponseDto create(UserRequestDto userRequestDto);

    List<UserResponseDto> getAll(int page, int size);

    UserResponseDto getById(Long id);

    UserResponseDto update(Long userId, UserRequestDto userRequestDto);

    boolean deleteUserById(Long id);

    User getUserByEmail(String email);
}
