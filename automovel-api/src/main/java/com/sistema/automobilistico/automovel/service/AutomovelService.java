package com.sistema.automobilistico.automovel.service;


import org.springframework.stereotype.Service;

import java.util.List;

import com.sistema.automobilistico.automovel.model.Automovel;
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

    public Automovel save (Automovel automovel) {
        return automovelRepository.save(automovel);
    }
    
    
    
}
