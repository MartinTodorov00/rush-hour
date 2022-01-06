package com.example.rushhour.repositories;

import com.example.rushhour.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

    @Query("select r from Role r join r.users u where u.email = :email")
    Set<Role> findRoleByUserEmail(@Param("email")String email);
}
