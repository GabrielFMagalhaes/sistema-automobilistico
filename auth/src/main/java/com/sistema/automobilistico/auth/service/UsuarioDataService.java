package com.sistema.automobilistico.auth.service;


import java.util.Arrays;

import com.sistema.automobilistico.auth.model.Role;
import com.sistema.automobilistico.auth.model.Usuario;
import com.sistema.automobilistico.auth.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service 
public class UsuarioDataService implements UserDetailsService {
  
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return new UsuarioData(usuario);
    }

    @Bean
	public CommandLineRunner setupDefaultUser() {
		return args -> {
			usuarioRepository.save(new Usuario(1L, "user", // username
                    passwordEncoder.encode("user"), // password
					Arrays.asList(new Role(1L, "USER"), new Role(2L, "ACTUATOR")), // roles
					true// Active
			));
		};
	}
}