package br.com.fiap.main;

import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dao.LaboratorioDAO;
import br.com.fiap.dto.Laboratorio;

import java.sql.Connection;
import java.util.ArrayList;

public class testeCreate_Laboratorio {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();;
        // Laboratorio laboratorio = new Laboratorio();
        LaboratorioDAO DAO  = new LaboratorioDAO(con);
        ArrayList<Laboratorio> lista;
        lista = DAO.listarTodos();
        for (Laboratorio lab : lista) {
            System.out.printf("ID: %s,\nNOME: %s,\nENDERECO: %s\n", lab.getId(), lab.getNome(), lab.getEndereco());;
        }
        // laboratorio.setNome("Fulano");
        // laboratorio.setEndereco("Rua Fulano");
        // laboratorio.setId("4");
        // LaboratorioDAO laboratorioDAO = new LaboratorioDAO(con);
        // System.out.println(laboratorioDAO.inserir(laboratorio));
        ConnectionFactory.fecharConexao(con);

    }
}
