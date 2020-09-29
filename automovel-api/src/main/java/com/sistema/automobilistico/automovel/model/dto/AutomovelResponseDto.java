package com.sistema.automobilistico.automovel.model.dto;

import java.util.Date;

import com.sistema.automobilistico.automovel.model.Automovel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutomovelResponseDto {
	
	public Long id;
	public String marca;
	public String modelo;
	public double valor;
	public Date dataCriado;
	
	public AutomovelResponseDto transformaParaDto(Automovel automovel) {
		return AutomovelResponseDto.builder()
				.id(automovel.getId())
				.marca(automovel.getMarca())
				.modelo(automovel.getModelo())
				.valor(automovel.getValor())
				.dataCriado(automovel.getDataCriado())
				.build();
	}
}
