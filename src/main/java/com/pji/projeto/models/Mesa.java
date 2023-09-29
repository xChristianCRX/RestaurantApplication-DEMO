package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mesas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
    
    @Id
    @Column(name = "numeroMesa", unique = true)
    private int numeroMesa;
}
