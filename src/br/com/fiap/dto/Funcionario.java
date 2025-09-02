package br.com.fiap.dto;

public class Funcionario {
    private String id;
    private String nome;
    private String cargo;
    private int laboratorio;

    public String  getId() {
        return id;
    }
    public void setId(String id ) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;

    }
    public int getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;

    }
    public Funcionario() {
    }
}

