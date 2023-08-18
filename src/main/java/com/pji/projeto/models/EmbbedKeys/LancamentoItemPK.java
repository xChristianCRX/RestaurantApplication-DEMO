package com.pji.projeto.models.EmbbedKeys;

import com.pji.projeto.models.Acrescimo;
import com.pji.projeto.models.Menu;
import com.pji.projeto.models.Pedido;
import com.pji.projeto.models.Pessoa;

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
    private Pessoa garcom;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
}
