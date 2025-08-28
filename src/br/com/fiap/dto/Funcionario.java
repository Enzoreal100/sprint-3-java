package br.com.fiap.dto;

public class Funcionario {
    private String id;
    private String nome;
    private String cargo;
    private String laboratorio;

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
    public String getLaboratorio() {
        return  laboratorio;
    }
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;

    }
    public Funcionario() {
    }
}

