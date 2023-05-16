package com.pji.projeto.models.EmbbedKeys;

import com.pji.projeto.models.Garcom;
import com.pji.projeto.models.Pedido;

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
