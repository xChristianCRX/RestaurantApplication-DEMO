package com.pji.projeto.dtos;

import jakarta.validation.constraints.NotBlank;

public class PorcaoDto extends MenuDto{

    @NotBlank
    private String tamanho;

    @NotBlank
    private String tipo;


    public PorcaoDto(String tamanho, String tipo) {
        this.tamanho = tamanho;
        this.tipo = tipo;
    }


    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
