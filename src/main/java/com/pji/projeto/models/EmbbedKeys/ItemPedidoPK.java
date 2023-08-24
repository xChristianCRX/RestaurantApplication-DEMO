package com.pji.projeto.models.EmbbedKeys;

import com.pji.projeto.models.Acrescimo;
import com.pji.projeto.models.Menu;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class ItemPedidoPK {

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu item;

    @ManyToOne
    @JoinColumn(name="acrescimo_id")
    private Acrescimo acrescimo;
}
