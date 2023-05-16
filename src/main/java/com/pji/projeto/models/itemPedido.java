package com.pji.projeto.models;

import com.pji.projeto.models.EmbbedKeys.ItemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class ItemPedido {
    
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
}
