package br.com.fiap.dto;

public class Estoque {
    private String id;
    private String nome;
    private int quantidade;
    private int valorMinimo;
    private String idLaboratorio;

    public String getIdLaboratorio() { return idLaboratorio; }

    public void setIdLaboratorio(String idLaboratorio) {this.idLaboratorio = idLaboratorio;}

    public String getId() {
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
    public int getQuantidade() {
        return  quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getValorMinimo() {
        return  valorMinimo;
    }
    public void setValorMinimo(int valorminimo) {
        this.valorMinimo = valorminimo;
    }
    public Estoque() {
    }
}

