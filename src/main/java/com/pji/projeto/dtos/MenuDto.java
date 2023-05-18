package com.pji.projeto.dtos;

import jakarta.validation.constraints.NotBlank;

public class MenuDto {

    @NotBlank
    private double preco;

    public double getPreco() {
        return this.preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
