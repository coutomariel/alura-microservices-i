package br.com.alura.microservices.fornecedor.controller;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(InfoController.class)
public class InfoControllerTest extends TestCase {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void DeveObterInfoPeloEstado() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8081/info/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}