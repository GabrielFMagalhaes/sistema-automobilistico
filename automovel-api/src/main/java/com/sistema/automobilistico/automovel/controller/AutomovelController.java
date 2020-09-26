package com.sistema.automobilistico.automovel.controller;

import java.util.List;

import javax.validation.Valid;

import com.sistema.automobilistico.automovel.model.Automovel;
import com.sistema.automobilistico.automovel.model.dto.AutomovelRequestDto;
import com.sistema.automobilistico.automovel.service.AutomovelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AutomovelController {

	@Autowired
	private AutomovelService automovelService;

	@GetMapping("/automoveis")
	public ResponseEntity<List<Automovel>> getAllAutomoveis() {
		return new ResponseEntity<>(automovelService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/cadastroAutomoveis")
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrarAutomovel(@Valid @RequestBody AutomovelRequestDto automovelRequestDto) {
		automovelService.save(automovelRequestDto.transformaParaObjeto(automovelRequestDto));
	}
}
