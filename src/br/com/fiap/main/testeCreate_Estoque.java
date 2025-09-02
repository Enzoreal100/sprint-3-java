package br.com.fiap.main;

import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dao.InsumoDAO;
import br.com.fiap.dto.Insumo;
import java.sql.Connection;
import java.util.ArrayList;

public class testeCreate_Estoque {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        // Insumo insumo = new Insumo();
        // insumo.setQuantidade(40);
        // insumo.setNome("Caixa de agulhas 100pc");
        // insumo.setValorMinimo(4);
        // insumo.setIdLaboratorio(1);
        InsumoDAO DAO = new InsumoDAO(con);
        // System.out.println(DAO.inserir(insumo));
        ArrayList<Insumo> lista;
        lista = DAO.listarTodos();
        for (Insumo insumo : lista) {
            System.out.println("ID: " + insumo.getId());
            System.out.println("Nome: " + insumo.getNome());
            System.out.println("Quantidade: " + insumo.getQuantidade());
            System.out.println("Valor Minimo: " + insumo.getValorMinimo());
            System.out.println("ID Laboratorio: " + insumo.getIdLaboratorio());
            System.out.println("-------------------------");
        }
        ConnectionFactory.fecharConexao(con);
    }
}
