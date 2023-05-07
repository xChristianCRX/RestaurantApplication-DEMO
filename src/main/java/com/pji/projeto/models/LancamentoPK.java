package com.pji.projeto.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LancamentoPK {

    @ManyToOne
    @JoinColumn(name="garcom_id")
    private Garcom garcom;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
}
