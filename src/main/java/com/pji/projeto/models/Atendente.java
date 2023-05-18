package com.pji.projeto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atendente")
@Getter
@Setter
public class Atendente extends Pessoa{
    
}
