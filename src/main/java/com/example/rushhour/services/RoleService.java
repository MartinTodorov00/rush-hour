package com.example.rushhour.services;

import com.example.rushhour.entities.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getRoleByUserEmail(String email);

    Role getRoleByName(String name);
}
