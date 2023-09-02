package com.pji.projeto.models;

import java.io.Serializable;

import com.pji.projeto.models.EmbbedKeys.LancamentoItemPK;

import jakarta.persistence.*;
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
public class LancamentoItem implements Serializable{

    //Item escolhido e seus acréscimos
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_item_pedido")
    private ItemPedido itemPedido;

    //Nº do pedido e o garçom responsável
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lancamento")
    private Lancamento lancamento;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "observacoes", length = 255, nullable = false)
    private String observacoes;
}
