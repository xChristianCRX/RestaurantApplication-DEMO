package com.pji.projeto.models;

public enum FuncaoENUM {
    ADMIN("admin"),
    ATENDENTE("atendente"),
    GARCOM("garcom");

    private String funcao;

    FuncaoENUM(String funcao){
        this.funcao = funcao;
    }

    public String getFuncao(){
        return funcao;
    }
}


