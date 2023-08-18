package com.pji.projeto.models.EmbbedKeys;

import com.pji.projeto.models.Pedido;
import com.pji.projeto.models.Pessoa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LancamentoPK {

    @ManyToOne
    @JoinColumn(name="garcom_id")
    private Pessoa garcom;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
}
