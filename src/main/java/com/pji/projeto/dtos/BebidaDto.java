package com.pji.projeto.dtos;

import jakarta.validation.constraints.NotBlank;

public class BebidaDto extends MenuDto{

    @NotBlank
    private String nome;

    @NotBlank
    private String litragem;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLitragem() {
        return this.litragem;
    }

    public void setLitragem(String litragem) {
        this.litragem = litragem;
    }

}
