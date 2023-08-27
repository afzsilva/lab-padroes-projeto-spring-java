package com.azsdev.labpadroesprojetospringjava.controller;

import com.azsdev.labpadroesprojetospringjava.dto.ClienteDTO;
import com.azsdev.labpadroesprojetospringjava.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody ClienteDTO clienteDTO){
        clienteService.inserir(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(clienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO){
        clienteService.atualizar(id,clienteDTO);
        return ResponseEntity.noContent().build();
    }


}
