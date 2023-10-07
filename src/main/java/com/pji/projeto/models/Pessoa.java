package com.pji.projeto.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "funcao", length = 60, nullable = false)
    @Enumerated(EnumType.STRING)
    private FuncaoENUM funcao;

    @Column(name = "usuario", length = 100, nullable = false, unique = true)
    private String usuario;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 60, nullable = false)
    private String senha;

    public Pessoa(String nome, int idade, FuncaoENUM funcao, String usuario, String email, String senha){
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.funcao == FuncaoENUM.ADMIN) return List.of(new SimpleGrantedAuthority("FUNCAO_ADMIN"), new SimpleGrantedAuthority("FUNCAO_ATENDENTE"), new SimpleGrantedAuthority("FUNCAO_GARCOM"));
        else if(this.funcao == FuncaoENUM.ATENDENTE) return List.of(new SimpleGrantedAuthority("FUNCAO_ADMIN"), new SimpleGrantedAuthority("FUNCAO_GARCOM"));
        else return List.of(new SimpleGrantedAuthority("FUNCAO_GARCOM"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
