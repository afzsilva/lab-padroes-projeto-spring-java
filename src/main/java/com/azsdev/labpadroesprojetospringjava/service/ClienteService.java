package com.azsdev.labpadroesprojetospringjava.service;

import com.azsdev.labpadroesprojetospringjava.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> buscarTodos();
    ClienteDTO buscarPorId(Long id);
    void inserir(ClienteDTO dto);
    void atualizar(Long id,ClienteDTO dto);
    void deletar(Long id);

}
