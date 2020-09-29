package com.sistema.automobilistico.automovel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.automobilistico.automovel.model.dto.AutomovelRequestDto;
import com.sistema.automobilistico.automovel.model.dto.AutomovelResponseDto;
import com.sistema.automobilistico.automovel.service.AutomovelService;


@RestController
public class AutomovelController {

	@Autowired
	private AutomovelService automovelService;

	@GetMapping("/automoveis")
	public List<AutomovelResponseDto> getAllAutomoveis() {
		List<AutomovelResponseDto> automovelResponseDtoList = automovelService.obterAutomoveis();
		return automovelResponseDtoList;
	}

	@PostMapping("/cadastroAutomoveis")
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarAutomovel(@RequestBody AutomovelRequestDto automovelRequestDto) {
		automovelService.save(automovelRequestDto.transformaParaObjeto(automovelRequestDto));
	}
}
