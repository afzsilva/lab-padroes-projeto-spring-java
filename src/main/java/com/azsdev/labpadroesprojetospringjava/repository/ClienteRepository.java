package com.azsdev.labpadroesprojetospringjava.repository;

import com.azsdev.labpadroesprojetospringjava.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
