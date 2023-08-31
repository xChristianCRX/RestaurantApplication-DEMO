package com.pji.projeto.models.EmbbedKeys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoPK implements Serializable{

    private int item;
    private int acrescimo;
    
}
