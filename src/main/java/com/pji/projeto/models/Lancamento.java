package com.pji.projeto.models;

import java.io.Serializable;

import com.pji.projeto.models.EmbbedKeys.LancamentoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    
    @EmbeddedId
    private LancamentoPK id = new LancamentoPK();
}
