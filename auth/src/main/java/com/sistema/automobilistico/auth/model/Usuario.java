package com.sistema.automobilistico.auth.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {
	private int id;
	private String username;
	private String senha;
}
