package com.azsdev.labpadroesprojetospringjava.mapper.impl;

import com.azsdev.labpadroesprojetospringjava.dto.ClienteDTO;
import com.azsdev.labpadroesprojetospringjava.entities.Cliente;
import com.azsdev.labpadroesprojetospringjava.entities.Endereco;
import com.azsdev.labpadroesprojetospringjava.mapper.AbstractMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class ClienteMapper implements AbstractMapper<Cliente, ClienteDTO> {
    @Override
    public ClienteDTO entidadeParaDTO(Cliente entidade) {
        return Objects.isNull(entidade) ? null : ClienteDTO.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .endereco(Endereco.builder()
                        .cep(entidade.getEndereco().getCep())
                        .logradouro(entidade.getEndereco().getLogradouro())
                        .bairro(entidade.getEndereco().getBairro())
                        .localidade(entidade.getEndereco().getLocalidade())
                        .uf(entidade.getEndereco().getUf())
                        .ibge(entidade.getEndereco().getIbge())
                        .gia(entidade.getEndereco().getGia())
                        .ddd(entidade.getEndereco().getDdd())
                        .siafi(entidade.getEndereco().getSiafi())
                        .build())
                .build();
    }

    @Override
    public Cliente dtoParaEntidade(ClienteDTO dto) {
        return Objects.isNull(dto) ? null : Cliente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .endereco(Endereco.builder()
                        .cep(dto.getEndereco().getCep())
                        .logradouro(dto.getEndereco().getLogradouro())
                        .bairro(dto.getEndereco().getBairro())
                        .localidade(dto.getEndereco().getLocalidade())
                        .uf(dto.getEndereco().getUf())
                        .ibge(dto.getEndereco().getIbge())
                        .gia(dto.getEndereco().getGia())
                        .ddd(dto.getEndereco().getDdd())
                        .siafi(dto.getEndereco().getSiafi())
                        .build())
                .build();
    }
}
