package com.azsdev.labpadroesprojetospringjava.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String uf;
    public String ibge;
    public String gia;
    public String ddd;
    public String siafi;
}