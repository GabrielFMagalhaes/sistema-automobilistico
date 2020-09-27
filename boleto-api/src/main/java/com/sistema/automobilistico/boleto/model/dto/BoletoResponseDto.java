package com.sistema.automobilistico.boleto.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sistema.automobilistico.boleto.model.Boleto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoResponseDto {
	@NotNull
	private Long codigoBoleto;

	@NotNull
	private double valor;

	@NotNull
	private Date dataVencimento;

	public static BoletoResponseDto transformaEmDto(Boleto boleto) {
		return new BoletoResponseDto(boleto.getCodigoBoleto(), boleto.getValor(), boleto.getDataVencimento());
	}
}
