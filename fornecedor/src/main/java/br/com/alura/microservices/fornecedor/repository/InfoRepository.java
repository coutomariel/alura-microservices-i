package br.com.alura.microservices.fornecedor.repository;

import br.com.alura.microservices.fornecedor.model.InfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfoRepository extends JpaRepository<InfoModel, Long> {
    Optional<InfoModel> findByEstado(String estado);
}
