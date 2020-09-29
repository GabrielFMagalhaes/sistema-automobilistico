package com.sistema.automobilistico.automovel.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.automobilistico.automovel.model.Automovel;
import com.sistema.automobilistico.automovel.model.dto.AutomovelResponseDto;
import com.sistema.automobilistico.automovel.repository.AutomovelRepository;

@Service
public class AutomovelService {

	private AutomovelRepository automovelRepository;

	public AutomovelService(AutomovelRepository automovelRepository) {
		this.automovelRepository = automovelRepository;
	}

	public List<Automovel> findAll() {
		return automovelRepository.findAll();
	}

	public Automovel save(Automovel automovel) {
		return automovelRepository.save(automovel);
	}

	public List<AutomovelResponseDto> obterAutomoveis() {
		List<Automovel> automovelList = automovelRepository.findAll();
		List<AutomovelResponseDto> automovelResponseDtoList = automovelList.stream()
				.map(automovel -> new AutomovelResponseDto().transformaParaDto(automovel)).collect(Collectors.toList());
		
		return automovelResponseDtoList;
	}

}
