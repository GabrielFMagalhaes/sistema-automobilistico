package com.sistema.automobilistico.automovel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.automobilistico.automovel.model.Automovel;
import com.sistema.automobilistico.automovel.repository.AutomovelRepository;

@SpringBootTest
public class AutomovelServiceTest {

	@Autowired
	private AutomovelRepository automovelRepository;

	@Test
	void getAllToDos() {
		Automovel automovel = new Automovel("Chevrolet", "Camaro", 90000.00, new Date());
		automovelRepository.save(automovel);
		AutomovelService toDoService = new AutomovelService(automovelRepository);

		List<Automovel> automovelList = toDoService.findAll();
		Automovel lastAutomovel = automovelList.get(automovelList.size() - 1);

		assertEquals(automovel.getMarca(), lastAutomovel.getMarca());
		assertEquals(automovel.getModelo(), lastAutomovel.getModelo());
		assertEquals(automovel.getValor(), lastAutomovel.getValor());
		assertEquals(automovel.getDataCriado(), lastAutomovel.getDataCriado());
		assertEquals(automovel.getId(), lastAutomovel.getId());
	}

	@Test
	void saveAutomovel() {
		AutomovelService automovelService = new AutomovelService(automovelRepository);
		Automovel automovel = new Automovel("Volkswagen", "Golf", 50000.00, new Date());

		automovelService.save(automovel);

		assertEquals(2.0, automovelRepository.count());
	}
}
