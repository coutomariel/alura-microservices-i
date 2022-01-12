package br.com.alura.microservices.loja.controller;

import br.com.alura.microservices.loja.controller.dto.CompraDto;
import br.com.alura.microservices.loja.service.ComprasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private ComprasService comprasService;

    public CompraController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CompraDto compra){
        comprasService.criarCompraFeignClient(compra);
    }
}
