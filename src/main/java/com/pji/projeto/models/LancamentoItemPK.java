package com.pji.projeto.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LancamentoItemPK {
    
    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name="acrescimo_id")
    private Acrescimo acrescimo;

    @ManyToOne
    @JoinColumn(name="garcom_id")
    private Garcom garcom;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
}
