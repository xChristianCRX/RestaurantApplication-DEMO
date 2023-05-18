package com.pji.projeto.dtos;

import jakarta.validation.constraints.NotBlank;

public class LancheDto extends MenuDto{

    @NotBlank
    private String nome;

    @NotBlank
    private String ingredientes;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

}
