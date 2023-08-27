package com.azsdev.labpadroesprojetospringjava.mapper.impl;

import com.azsdev.labpadroesprojetospringjava.dto.EnderecoDTO;
import com.azsdev.labpadroesprojetospringjava.entities.Endereco;
import com.azsdev.labpadroesprojetospringjava.mapper.AbstractMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class EnderecoMapper implements AbstractMapper<Endereco, EnderecoDTO> {
    @Override
    public EnderecoDTO entidadeParaDTO(Endereco entidade) {
        return Objects.isNull(entidade) ? null : EnderecoDTO.builder()
                .cep(entidade.getCep())
                .logradouro(entidade.getLogradouro())
                .bairro(entidade.getBairro())
                .localidade(entidade.getLocalidade())
                .uf(entidade.getUf())
                .ibge(entidade.getIbge())
                .gia(entidade.getGia())
                .ddd(entidade.getDdd())
                .siafi(entidade.getSiafi())
                .build();
    }

    @Override
    public Endereco dtoParaEntidade(EnderecoDTO enderecoDTO) {
        return Objects.isNull(enderecoDTO) ? null : Endereco.builder()
                .cep(enderecoDTO.getCep())
                .logradouro(enderecoDTO.getLogradouro())
                .bairro(enderecoDTO.getBairro())
                .localidade(enderecoDTO.getLocalidade())
                .uf(enderecoDTO.getUf())
                .ibge(enderecoDTO.getIbge())
                .gia(enderecoDTO.getGia())
                .ddd(enderecoDTO.getDdd())
                .siafi(enderecoDTO.getSiafi())
                .build();
    }
}
