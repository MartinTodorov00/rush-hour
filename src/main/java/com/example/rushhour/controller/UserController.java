package com.example.rushhour.controller;

import com.example.rushhour.Dto.UserRequestDto;
import com.example.rushhour.Dto.UserResponseDto;
import com.example.rushhour.entities.User;
import com.example.rushhour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public UserResponseDto create(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.create(userRequestDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(int page, int size) {
        return ResponseEntity.ok(userService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@Valid @PathVariable("id") Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.update(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
