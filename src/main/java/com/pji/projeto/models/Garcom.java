package com.pji.projeto.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "garcom")
@DiscriminatorValue("GARCOM")
@Getter
@Setter
public class Garcom extends Pessoa{


}
