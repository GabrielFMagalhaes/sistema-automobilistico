package com.sistema.automobilistico.auth.repository;

import com.sistema.automobilistico.auth.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}