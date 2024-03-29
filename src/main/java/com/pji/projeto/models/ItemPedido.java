package com.pji.projeto.models;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    private Menu item;

    @ManyToMany
    @JoinTable(
            name = "acrescimos_item",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_acrescimo")
    )
    private List<Acrescimo> acrescimos;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "observacoes", length = 255, nullable = false)
    private String observacoes;
}
