package br.com.alura.microservices.loja.config;

import br.com.alura.microservices.loja.controller.dto.InfoResponseFornecedorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("http://fornecedor")
public interface FornecedorFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/info/{estado}", consumes = "application/json")
    InfoResponseFornecedorDto getInfo(@PathVariable("") String estado);
}
