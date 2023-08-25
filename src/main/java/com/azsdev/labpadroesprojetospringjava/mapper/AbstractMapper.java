package com.azsdev.labpadroesprojetospringjava.mapper;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface AbstractMapper <CLASSE, DTO>{

    // Receive List<>
    default List<DTO> entidadesParaDTOs(Collection<CLASSE> entidades) {
        return entidades == null ? Collections.emptyList() :
                entidades.stream()
                        .filter(Objects::nonNull)
                        .map(this::entidadeParaDTO)
                        .collect(Collectors.toList());
    }

    // Receive List<>
    default List<CLASSE> DTOsParaEntidades(Collection<DTO> dtos) {
        return dtos == null ? Collections.emptyList() :
                dtos.stream()
                        .filter(Objects::nonNull)
                        .map(this::dtoParaEntidade)
                        .collect(Collectors.toList());
    }

    DTO entidadeParaDTO(CLASSE entidade);

    CLASSE dtoParaEntidade(DTO dto);

    default Page<DTO> pageEntidadeParaPageDTO(Page<CLASSE> entidade) {
        return entidade == null ? null : entidade.map(this::entidadeParaDTO);
    }
}