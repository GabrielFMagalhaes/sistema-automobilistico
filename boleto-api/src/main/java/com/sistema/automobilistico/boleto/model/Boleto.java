package com.sistema.automobilistico.boleto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "boleto")
@Data
@NoArgsConstructor
public class Boleto {

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

	@Column(name = "data_vencimento")
	@NotNull
	public Date dataVencimento;

	public Boleto(Long id, String marca, String modelo, double valor, Date dataVencimento) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

	public Boleto(String marca, String modelo, double valor, Date dataVencimento) {
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

}
