package com.azsdev.labpadroesprojetospringjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nome;
}
