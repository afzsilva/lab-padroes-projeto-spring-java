package com.azsdev.labpadroesprojetospringjava.service.impl;

import com.azsdev.labpadroesprojetospringjava.dto.ClienteDTO;
import com.azsdev.labpadroesprojetospringjava.dto.EnderecoDTO;
import com.azsdev.labpadroesprojetospringjava.entities.Cliente;
import com.azsdev.labpadroesprojetospringjava.entities.Endereco;
import com.azsdev.labpadroesprojetospringjava.mapper.impl.ClienteMapper;
import com.azsdev.labpadroesprojetospringjava.mapper.impl.EnderecoMapper;
import com.azsdev.labpadroesprojetospringjava.repository.ClienteRepository;
import com.azsdev.labpadroesprojetospringjava.repository.EnderecoRepository;
import com.azsdev.labpadroesprojetospringjava.service.ClienteService;
import com.azsdev.labpadroesprojetospringjava.service.EnderecoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final EnderecoMapper enderecoMapper;
    private final EnderecoRepository enderecoRepository;
    private final EnderecoService enderecoService;

    @Override
    public List<ClienteDTO> buscarTodos() {
        return clienteMapper.entidadesParaDTOs(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        return clienteMapper.entidadeParaDTO(clienteRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Cliente Não encontrado")));
    }

    @Override
    public void inserir(ClienteDTO clienteDto) {
        salvarClienteComCep2(clienteDto);
    }//inserir


    @Override
    public void atualizar(Long id, ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            salvarClienteComCep2(clienteDTO);
        }

    }

    @Override
    public void deletar(Long id) {
        if(!Objects.isNull(buscarPorId(id).getId())){
            clienteRepository.deleteById(id);
        }
    }

    //private methods
    private void salvarClienteComCep2(ClienteDTO clienteDto) {

        String cep = clienteDto.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
            EnderecoDTO enderecoDTO = enderecoService.consultarCep(cep);
            enderecoRepository.saveAndFlush(enderecoMapper.dtoParaEntidade(enderecoDTO));
            return enderecoMapper.dtoParaEntidade(enderecoDTO);
        });

        clienteDto.setEndereco(endereco);
        clienteRepository.save(clienteMapper.dtoParaEntidade(clienteDto));
    }
}
