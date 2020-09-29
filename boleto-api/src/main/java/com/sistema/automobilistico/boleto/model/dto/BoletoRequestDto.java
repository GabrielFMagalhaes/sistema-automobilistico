package com.sistema.automobilistico.boleto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistema.automobilistico.boleto.model.Boleto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoRequestDto {

	@NotNull
	private String marca;

	@NotNull
	private String modelo;

	@NotNull
	private double valor;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataVencimento;

	public Boleto transformaParaObjeto(BoletoRequestDto boletoRequestDto) {
		return Boleto.builder().marca(boletoRequestDto.getMarca()).modelo(boletoRequestDto.getModelo())
				.valor(boletoRequestDto.getValor()).dataVencimento(boletoRequestDto.getDataVencimento()).build();
	}

}
