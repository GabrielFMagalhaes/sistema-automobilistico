package com.sistema.automobilistico.auth.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.sistema.automobilistico.auth.model.Usuario;

@Service
public class UsuarioService {

	private List<Usuario> usuarios = new ArrayList<>();

	@PostConstruct
	public void init() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setUsername("admin");
		usuario.setSenha("admin");

		usuarios.add(usuario);
	}

	public Usuario findUsuarioByUsername(String username) {
		return usuarios.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}

}
