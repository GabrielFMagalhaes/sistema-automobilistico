package com.sistema.automobilistico.boleto.service;

import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.repository.BoletoRepository;

import org.springframework.stereotype.Service;

@Service
public class BoletoService {

	private BoletoRepository boletoRepository;

	public BoletoService(BoletoRepository boletoRepository) {
		this.boletoRepository = boletoRepository;
	}

	public Boleto save(Boleto automovel) {
		return boletoRepository.save(automovel);
	}

}
