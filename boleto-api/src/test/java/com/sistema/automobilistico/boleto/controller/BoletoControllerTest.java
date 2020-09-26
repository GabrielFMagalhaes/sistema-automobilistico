package com.sistema.automobilistico.boleto.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.service.BoletoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class BoletoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BoletoService boletoService;


    @Test
    void gerarBoletoSucesso() throws Exception {
        Date currentDate = new Date();
        Boleto boleto = new Boleto(2L, "Chevrolet", "Camaro", 90000.00, currentDate);
        when(boletoService.save(any(Boleto.class))).thenReturn(boleto);

        ObjectMapper objectMapper = new ObjectMapper();

        String boletoJSON = objectMapper.writeValueAsString(boleto);

        ResultActions result = mockMvc.perform(post("/boleto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(boletoJSON)
        );

        result.andExpect(status().isCreated());
    }
}
