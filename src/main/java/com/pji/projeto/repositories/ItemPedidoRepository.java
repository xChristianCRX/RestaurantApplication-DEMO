package com.pji.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
    
    //@Query(value = " SELECT from ItemPedido where id_acrescimo = :idAcrescimo and id_menu = :idMenu")
    //List<ItemPedido> findByAcrescimoAndItem(Long idMenu, Long idAcrescimo);

    //@Query(value = "DELETE FROM ItemPedido where id_acrescimo = :idAcrescimo and id_menu = :idMenu")
    //ItemPedido deleteByAcrescimoAndItem(Long idMenu, Long idAcrescimo);
}
