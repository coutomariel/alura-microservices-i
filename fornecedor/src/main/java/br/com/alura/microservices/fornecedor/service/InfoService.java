package br.com.alura.microservices.fornecedor.service;

import br.com.alura.microservices.fornecedor.model.InfoModel;
import br.com.alura.microservices.fornecedor.repository.InfoRepository;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public InfoModel getInfo(String estado) throws Exception {
        return infoRepository.findByEstado(estado).orElseThrow(()-> new RuntimeException("Resource not found"));

    }
}
