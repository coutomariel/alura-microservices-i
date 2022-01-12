package br.com.alura.microservices.loja.controller;

import br.com.alura.microservices.loja.controller.dto.CompraDto;
import br.com.alura.microservices.loja.controller.dto.EnderecoDto;
import br.com.alura.microservices.loja.controller.dto.ItemCompraDto;
import br.com.alura.microservices.loja.service.ComprasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompraController.class)
public class CompraControllerTest extends TestCase {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComprasService comprasService;

    @InjectMocks
    private CompraController compraController;

    @Test
    public void DeveCriarCompra() throws Exception {

        CompraDto compra = new CompraDto();
        compra.setEndereco(new EnderecoDto("Rua das Bromelias", 1818, "MG"));

        ItemCompraDto item1 = new ItemCompraDto(1L,15);
        ItemCompraDto item2 = new ItemCompraDto(2L,7);
        compra.setItems(Arrays.asList(item1, item2));

        doNothing().when(comprasService).criarCompraRestTemplate(compra);

        mockMvc.perform(post("/compras")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(compra)))
                .andExpect(status().isCreated());

        verify(comprasService, times(1)).criarCompraRestTemplate(any());


    }
}