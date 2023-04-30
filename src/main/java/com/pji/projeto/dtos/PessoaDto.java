package com.pji.projeto.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    
    @NotBlank
    private String nome;
    @NotBlank
    private int idade;
    @NotBlank
    private String funcao;
    @NotBlank
    private String usuario;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;


}
