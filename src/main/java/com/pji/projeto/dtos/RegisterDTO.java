package com.pji.projeto.dtos;

import com.pji.projeto.models.FuncaoENUM;

public record RegisterDTO(String nome, int idade, String email, String usuario, String senha, FuncaoENUM funcao) {

}
