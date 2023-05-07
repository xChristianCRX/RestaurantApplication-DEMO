package com.pji.projeto.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class ItemPedidoPK {

    @ManyToOne
    @JoinColumn(name="item_id")
    private Menu item;

    @ManyToOne
    @JoinColumn(name="acrescimo_id")
    private Acrescimo acrescimo;
}
