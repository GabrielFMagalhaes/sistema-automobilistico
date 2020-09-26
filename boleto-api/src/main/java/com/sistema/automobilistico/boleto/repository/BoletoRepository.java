package com.sistema.automobilistico.boleto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.automobilistico.boleto.model.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Long> {

}
