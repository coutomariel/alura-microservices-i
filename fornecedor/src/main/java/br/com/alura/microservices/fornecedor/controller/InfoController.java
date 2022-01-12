package br.com.alura.microservices.fornecedor.controller;

import br.com.alura.microservices.fornecedor.model.InfoModel;
import br.com.alura.microservices.fornecedor.repository.InfoRepository;
import br.com.alura.microservices.fornecedor.service.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    private InfoService infoService;
    private InfoRepository infoRepository;

    public InfoController(InfoService infoService, InfoRepository infoRepository) {
        this.infoService = infoService;
        this.infoRepository = infoRepository;
    }

    @GetMapping("/{estado}")
    public InfoModel getInfo(@PathVariable String estado) throws Exception {
        return infoService.getInfo(estado);
    }

    @GetMapping
    public List<InfoModel> getAll() {
        return infoRepository.findAll();
    }

}
