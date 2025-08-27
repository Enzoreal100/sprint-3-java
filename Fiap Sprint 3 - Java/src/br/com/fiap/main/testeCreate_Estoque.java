package br.com.fiap.main;

import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dao.EstoqueDAO;
import br.com.fiap.dto.Estoque;

import java.sql.Connection;

public class testeCreate_Estoque {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        Estoque estoque = new Estoque();
        estoque.setQuantidade(10);
        estoque.setNome(null);
        estoque.setId("3");
        estoque.setValorMinimo(20);
        EstoqueDAO estoqueDAO = new EstoqueDAO(con);
        System.out.println(estoqueDAO.inserir(estoque));
        ConnectionFactory.fecharConexao(con);
    }
}
