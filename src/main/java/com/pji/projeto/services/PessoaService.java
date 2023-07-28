package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Pessoa;
import com.pji.projeto.repositories.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findById(Long id){
        Optional<Pessoa> pessoa = this.pessoaRepository.findById(id);
        return pessoa.orElseThrow(() -> new RuntimeException(
                "Pessoa não cadastrada! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Pessoa create(Pessoa pessoa){
        pessoa.setId(null);
        pessoa = this.pessoaRepository.save(pessoa);
        return pessoa;
    }

    @Transactional //Envio de dados para o BDD
    public Pessoa update(Pessoa pessoa){
        Pessoa newPessoa = findById(pessoa.getId());
        newPessoa.setNome(pessoa.getNome());
        newPessoa.setIdade(pessoa.getIdade());
        newPessoa.setFuncao(pessoa.getFuncao());
        newPessoa.setEmail(pessoa.getEmail());
        newPessoa.setSenha(pessoa.getSenha());
        return this.pessoaRepository.save(newPessoa);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.pessoaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
    
}
