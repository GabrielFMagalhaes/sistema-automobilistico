package com.sistema.automobilistico.boleto.service;

import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.model.dto.BoletoRequestDto;
import com.sistema.automobilistico.boleto.model.dto.BoletoResponseDto;
import com.sistema.automobilistico.boleto.repository.BoletoRepository;

import org.springframework.stereotype.Service;

@Service
public class BoletoService {

	private BoletoRepository boletoRepository;

	public BoletoService(BoletoRepository boletoRepository) {
		this.boletoRepository = boletoRepository;
	}

	public BoletoResponseDto gerarBoleto(BoletoRequestDto boletoRequestDto) {
		Boleto boleto	 = boletoRequestDto.transformaParaObjeto(boletoRequestDto);
		Boleto novoBoleto = boletoRepository.save(boleto);
		
		return new BoletoResponseDto().transformaParaDto(novoBoleto);
	}
}
