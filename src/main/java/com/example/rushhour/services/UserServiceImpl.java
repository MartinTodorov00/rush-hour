package com.example.rushhour.services;

import com.example.rushhour.Dto.UserMapper;
import com.example.rushhour.Dto.UserRequestDto;
import com.example.rushhour.Dto.UserResponseDto;
import com.example.rushhour.Exception.EmailAlreadyExistsException;
import com.example.rushhour.Exception.UserNotFoundByIdException;
import com.example.rushhour.entities.User;
import com.example.rushhour.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        User user = userMapper.mapUserDtoToUser(userRequestDto);
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public List<UserResponseDto> getAll(int page, int pageSize) {
        List<UserResponseDto> userDtos = userMapper.mapUserListToUserResponseDtoList(userRepository.findAll());
        return new ArrayList<>(userDtos);
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundByIdException(id));
        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public UserResponseDto update(Long userId, UserRequestDto userDto) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundByIdException(userId);
        }
        user = Optional.ofNullable(userMapper.mapUserDtoToUser(userDto));
        return userMapper.mapUserToUserDto(userRepository.save(user.get()));
    }

    @Override
    public boolean deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        throw new UserNotFoundByIdException(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
