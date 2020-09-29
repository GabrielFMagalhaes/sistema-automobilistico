package com.sistema.automobilistico.auth.repository;

import java.util.Optional;

import com.sistema.automobilistico.auth.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository for CRUD operations.
 */
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username);
}
