package com.pji.projeto.models;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Lancamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lancamento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_garcom")
    private Pessoa garcom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
