package com.sistema.automobilistico.automovel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistema.automobilistico.automovel.model.Automovel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutomovelRequestDto {

	@NotNull
	private String marca;

	@NotNull
	private String modelo;

	@NotNull
	private double valor;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataCriado;

	public Automovel transformaParaObjeto(AutomovelRequestDto automovelRequestDto) {
		return Automovel.builder()
				.marca(automovelRequestDto.getMarca())
				.modelo(automovelRequestDto.getModelo())
				.valor(automovelRequestDto.getValor())
				.dataCriado(automovelRequestDto.getDataCriado())
				.build();
	}
}
