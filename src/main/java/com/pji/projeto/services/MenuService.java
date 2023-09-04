package com.pji.projeto.services;

import java.util.Optional;

import com.pji.projeto.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.repositories.MenuRepository;

import jakarta.transaction.Transactional;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    public Menu findById(Long id){
    Optional<Menu> menu = this.menuRepository.findById(id);
    return menu.orElseThrow(() -> new RuntimeException(
            "Item do menu não cadastrado! Id: " + id + ", Tipo: " + Menu.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Menu create(Menu menu){
        menu.setId(null);
        menu = this.menuRepository.save(menu);
        return menu;
    }

    @Transactional
    public Menu update(Menu menu){
        Menu newMenu = findById(menu.getId());
        newMenu.setPreco(menu.getPreco());
        return this.menuRepository.save(newMenu);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.menuRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
