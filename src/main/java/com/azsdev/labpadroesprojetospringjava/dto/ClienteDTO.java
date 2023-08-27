package com.azsdev.labpadroesprojetospringjava.dto;

import com.azsdev.labpadroesprojetospringjava.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String nome;
    private Endereco endereco;
}
