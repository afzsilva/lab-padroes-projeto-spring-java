package com.azsdev.labpadroesprojetospringjava.service;

import com.azsdev.labpadroesprojetospringjava.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacer", url = "https://viacep.com.br/ws")
public interface EnderecoService {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    EnderecoDTO consultarCep(@PathVariable("cep") String cep);
}
