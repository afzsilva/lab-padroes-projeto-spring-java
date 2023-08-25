package com.azsdev.labpadroesprojetospringjava.service.impl;

import com.azsdev.labpadroesprojetospringjava.dto.ClienteDTO;
import com.azsdev.labpadroesprojetospringjava.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Override
    public List<ClienteDTO> buscarTodos() {
        return null;
    }

    @Override
    public ClienteDTO BuscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(ClienteDTO dto) {

    }

    @Override
    public void atualisar(Long id, ClienteDTO dto) {

    }

    @Override
    public void deletar(Long id) {

    }
}
