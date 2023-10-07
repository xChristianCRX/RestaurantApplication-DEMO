package com.pji.projeto.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LancamentoItem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LancamentoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "itensLancamento",
            joinColumns = @JoinColumn(name = "id_lancamento"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
    )
    private List<ItemPedido> itemPedido;

    @ManyToOne
    @JoinColumn(name = "id_garcom")
    private Pessoa garcom;

    @Column(name = "hora")
    private String hora;

    @ManyToOne
    @JoinColumn(name = "numero_mesa")
    private Mesa mesa;

}
