package com.pji.projeto.models;

import java.io.Serializable;

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
public class LancamentoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    //Item escolhido e seus acréscimos
    @OneToOne(cascade = CascadeType.ALL)
    private ItemPedido itemPedido;

    //Nº do pedido e o garçom responsável
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lancamento")
    private Lancamento lancamento;

}
