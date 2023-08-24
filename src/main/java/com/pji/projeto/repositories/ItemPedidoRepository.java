package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Acrescimo;
import com.pji.projeto.models.ItemPedido;
import com.pji.projeto.models.Menu;
import com.pji.projeto.models.EmbbedKeys.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{
    
    @Query("SELECT * FROM item_pedido where id_acrescimo = :acrescimo and id_menu = :item")
    ItemPedido findByAcrescimoAndItem(Menu item, Acrescimo acrescimo);
}
