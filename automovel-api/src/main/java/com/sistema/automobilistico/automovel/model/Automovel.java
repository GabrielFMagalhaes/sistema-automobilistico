package com.sistema.automobilistico.automovel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "automovel")
@Data
@NoArgsConstructor
@Builder
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	public Long id;

	@NotNull
	public String marca;

	@NotNull
	public String modelo;

	@NotNull
	public double valor;

	@Column(name = "data_criado")
	@NotNull
	public Date dataCriado;

	public Automovel(Long id, String marca, String modelo, double valor, Date dataCriado) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.dataCriado = dataCriado;
	}

	public Automovel(String marca, String modelo, double valor, Date dataCriado) {
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.dataCriado = dataCriado;
	}

}
