package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LancamentoItem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LancamentoItem {
    
    @EmbeddedId
    private LancamentoItemPK id = new LancamentoItemPK();

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "observacoes", length = 255, nullable = false)
    private String observacoes;
}
