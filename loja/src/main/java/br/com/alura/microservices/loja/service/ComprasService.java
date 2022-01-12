package br.com.alura.microservices.loja.service;

import br.com.alura.microservices.loja.config.FornecedorFeignClient;
import br.com.alura.microservices.loja.controller.dto.CompraDto;
import br.com.alura.microservices.loja.controller.dto.InfoResponseFornecedorDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComprasService {

    private RestTemplate restTemplate;
    private FornecedorFeignClient fornecedorClient;

    public ComprasService(RestTemplate restTemplate, FornecedorFeignClient fornecedorClient) {
        this.restTemplate = restTemplate;
        this.fornecedorClient = fornecedorClient;
    }

    public void criarCompraRestTemplate(CompraDto compra) {

        ResponseEntity<InfoResponseFornecedorDto> response = restTemplate
                .exchange("http://localhost:8081/info/" + compra.getEndereco().getEstado(),
                        HttpMethod.GET, null, InfoResponseFornecedorDto.class);

        System.out.println(response.getBody().getEndereco());
    }

    public void criarCompraFeignClient(CompraDto compra) {
        InfoResponseFornecedorDto response = fornecedorClient.getInfo(compra.getEndereco().getEstado());
        System.out.println(response.getEndereco());
    }
}
