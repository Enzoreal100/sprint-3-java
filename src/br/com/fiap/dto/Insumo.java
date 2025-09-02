package br.com.fiap.dto;

public class Insumo {
    private int id;
    private String nome;
    private int quantidade;
    private int valorMinimo;
    private int idLaboratorio;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public int getValorMinimo() { return valorMinimo; }

    public void setValorMinimo(int valorMinimo) { this.valorMinimo = valorMinimo; }

    public int getIdLaboratorio() { return idLaboratorio; }

    public void setIdLaboratorio(int idLaboratorio) { this.idLaboratorio = idLaboratorio; }

}