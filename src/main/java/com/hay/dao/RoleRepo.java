package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

}
