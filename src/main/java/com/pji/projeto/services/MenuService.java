package com.pji.projeto.services;

import java.util.Optional;

import com.pji.projeto.models.Bebida;
import com.pji.projeto.models.Lanche;
import com.pji.projeto.models.Menu;
import com.pji.projeto.models.Porcao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.repositories.MenuRepository;

import jakarta.transaction.Transactional;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    public Lanche findLanche(Long id){
    Optional<Lanche> lanche = this.menuRepository.selectByIdLanche(id);
    return lanche.orElseThrow(() -> new RuntimeException(
            "Item do menu não cadastrado! Id: " + id + ", Tipo: " + Lanche.class.getName()));
    }

    public Bebida findBebida(Long id){
        Optional<Bebida> bebida = this.menuRepository.selectByIdBebida(id);
        return bebida.orElseThrow(() -> new RuntimeException(
                "Item do menu não cadastrado! Id: " + id + ", Tipo: " + Bebida.class.getName()));
    }

    public Porcao findPorcao(Long id){
        Optional<Porcao> porcao = this.menuRepository.selectByIdPorcao(id);
        return porcao.orElseThrow(() -> new RuntimeException(
                "Item do menu não cadastrado! Id: " + id + ", Tipo: " + Porcao.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Lanche createLanche(Lanche lanche){
        lanche.setId(null);
        lanche = this.menuRepository.save(lanche);
        return lanche;
    }

    @Transactional //Envio de dados para o BDD
    public Bebida createBebida(Bebida bebida){
        bebida.setId(null);
        bebida = this.menuRepository.save(bebida);
        return bebida;
    }

    @Transactional //Envio de dados para o BDD
    public Porcao createPorcao(Porcao porcao){
        porcao.setId(null);
        porcao = this.menuRepository.save(porcao);
        return porcao;
    }

    @Transactional
    public Lanche updateLanche(Lanche lanche){
        Lanche newMenu = findLanche(lanche.getId());
        newMenu.setPreco(lanche.getPreco());
        newMenu.setNome(lanche.getNome());
        newMenu.setIngredientes(lanche.getIngredientes());
        return this.menuRepository.save(newMenu);
    }

    @Transactional
    public Bebida updateBebida(Bebida bebida){
        Bebida newMenu = findBebida(bebida.getId());
        newMenu.setPreco(bebida.getPreco());
        newMenu.setNome(bebida.getNome());
        newMenu.setLitragem(bebida.getLitragem());
        return this.menuRepository.save(newMenu);
    }

    @Transactional
    public Porcao updatePorcao(Porcao porcao){
        Porcao newMenu = findPorcao(porcao.getId());
        newMenu.setTipo(porcao.getTipo());
        newMenu.setPreco(porcao.getPreco());
        newMenu.setTamanho(porcao.getTamanho());
        return this.menuRepository.save(newMenu);
    }

    public void deleteLanche(Long id){
        findLanche(id);
        try {
            this.menuRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

    public void deleteBebida(Long id){
        findBebida(id);
        try {
            this.menuRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

    public void deletePorcao(Long id){
        findPorcao(id);
        try {
            this.menuRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
