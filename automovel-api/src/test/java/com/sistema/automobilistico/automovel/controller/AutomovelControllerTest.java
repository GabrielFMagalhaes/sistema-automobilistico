package com.sistema.automobilistico.automovel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.automobilistico.automovel.model.Automovel;
import com.sistema.automobilistico.automovel.service.AutomovelService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AutomovelControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private AutomovelService automovelService;

	@Test
	void getAllAutomoveis() throws Exception {
		List<Automovel> automovelList = new ArrayList<Automovel>();
		automovelList.add(new Automovel(1L, "Volkswagen", "Golf", 50000.00, new Date()));
		automovelList.add(new Automovel(2L, "Fiat", "Uno", 50000.00, new Date()));
		when(automovelService.findAll()).thenReturn(automovelList);

		mockMvc.perform(MockMvcRequestBuilders.get("/automoveis").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}

	@Test
    void cadastrarNovoAutomovelSucesso() throws Exception {
        Date currentDate = new Date();
        Automovel automovel = new Automovel(3L, "Chevrolet", "Camaro", 90000.00, currentDate);
        Mockito.doReturn(automovel).when(automovelService).save(Mockito.any(Automovel.class));

        ObjectMapper objectMapper = new ObjectMapper();

        String automovelJSON = objectMapper.writeValueAsString(automovel);

        ResultActions result = mockMvc.perform(post("/cadastroAutomoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(automovelJSON)
        );

        result.andExpect(status().isCreated());
    }
}
