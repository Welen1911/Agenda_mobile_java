package com.example.ola_mundo;

public class Contato {
    private int id;
    private String nome;
    private String fone;

    public Contato(int aId, String anome, String afone) {
        this.id = aId;
        this.nome = anome;
        this.fone = afone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.nome + " - " + this.fone;
    }

}
