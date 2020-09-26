package com.sistema.automobilistico.boleto.service;

import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.repository.BoletoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoService {

    private BoletoRepository boletoRepository;

    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public List<Boleto> findAll() {
        return boletoRepository.findAll();
    }

    public Boleto save (Boleto automovel) {
        return boletoRepository.save(automovel);
    }
    
    
    
}
