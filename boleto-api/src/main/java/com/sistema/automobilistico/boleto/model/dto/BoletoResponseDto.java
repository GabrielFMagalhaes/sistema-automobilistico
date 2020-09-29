package com.sistema.automobilistico.boleto.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sistema.automobilistico.boleto.model.Boleto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoletoResponseDto {
	@NotNull
	private Long codigoBoleto;

	@NotNull
	private double valor;

	@NotNull
	private Date dataVencimento;
	
	public BoletoResponseDto transformaParaDto(Boleto boleto) {
		return BoletoResponseDto.builder()
				.codigoBoleto(boleto.getCodigoBoleto())
				.valor(boleto.getValor())
				.dataVencimento(boleto.getDataVencimento())
				.build();
	}
}
