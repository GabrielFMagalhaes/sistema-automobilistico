package com.sistema.automobilistico.boleto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.repository.BoletoRepository;

@SpringBootTest
public class BoletoServiceTest {

	@Autowired
	private BoletoRepository boletoRepository;

	@Test
	void saveAutomovel() {
		BoletoService boletoService = new BoletoService(boletoRepository);
		Boleto boleto = new Boleto("Volkswagen", "Golf", 50000.00, new Date());

		boletoService.save(boleto);

		assertEquals(1.0, boletoRepository.count());
	}
}
