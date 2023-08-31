package com.pji.projeto.models;

import java.io.Serializable;

import com.pji.projeto.models.EmbbedKeys.ItemPedidoPK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ItemPedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(ItemPedidoPK.class)
public class ItemPedido implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Menu item;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_acrescimo", referencedColumnName = "id")
    private Acrescimo acrescimo;

    //@EmbeddedId
    //private ItemPedidoPK id = new ItemPedidoPK();
}
