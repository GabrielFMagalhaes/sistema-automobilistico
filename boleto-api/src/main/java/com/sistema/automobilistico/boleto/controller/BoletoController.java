package com.sistema.automobilistico.boleto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.model.dto.BoletoRequestDto;
import com.sistema.automobilistico.boleto.model.dto.BoletoResponseDto;
import com.sistema.automobilistico.boleto.service.BoletoService;

@RestController
public class BoletoController {

	@Autowired
	private BoletoService boletoService;


	@PostMapping("/boleto")
	public ResponseEntity<BoletoResponseDto> gerarBoleto(@Valid @RequestBody BoletoRequestDto boletoRequestDto) {
		Boleto boleto = boletoService.save(boletoRequestDto.transformaParaObjeto(boletoRequestDto));

		return new ResponseEntity<>(BoletoResponseDto.transformaEmDto(boleto), HttpStatus.CREATED);
	}
}
