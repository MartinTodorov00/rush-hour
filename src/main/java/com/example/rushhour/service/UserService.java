package com.example.rushhour.service;

import com.example.rushhour.Dto.UserRequestDto;
import com.example.rushhour.Dto.UserResponseDto;
import com.example.rushhour.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponseDto create(UserRequestDto userRequestDto);

    List<UserResponseDto> getAll(int page, int size);

    User getById(Long id);

    UserResponseDto update(Long userId, UserRequestDto userRequestDto);

    boolean deleteUserById(Long id);
}
