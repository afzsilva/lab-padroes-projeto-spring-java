package com.azsdev.labpadroesprojetospringjava.repository;

import com.azsdev.labpadroesprojetospringjava.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
