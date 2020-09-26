package com.sistema.automobilistico.automovel.repository;

import com.sistema.automobilistico.automovel.model.Automovel;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
