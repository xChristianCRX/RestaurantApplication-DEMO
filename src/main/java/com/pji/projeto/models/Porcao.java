package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "porcoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Porcao extends Menu {
    
    @Column(name = "tamanho", length = 60, nullable = false)
    private String tamanho;

    @Column(name = "tipo", length = 60, nullable = false)
    private String tipo;
}
