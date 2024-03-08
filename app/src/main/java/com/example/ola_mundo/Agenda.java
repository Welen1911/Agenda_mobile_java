package com.example.ola_mundo;

import java.util.ArrayList;

public class Agenda extends ArrayList<Contato> {
    public void inserir(int id, String nome, String fone) {
        this.add(new Contato(id, nome, fone));
    }

    public void atualizar(int id, String nome, String fone) {
        this.get(id).setNome(nome);
        this.get(id).setFone(fone);
    }

    public void excluir(int id) {
        Contato contato = this.get(id);
        this.remove(contato);
    }
}
