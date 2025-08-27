package br.com.fiap.main;

import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dao.LaboratorioDAO;
import br.com.fiap.dto.Laboratorio;

import java.sql.Connection;

public class testeCreate_Laboratorio {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();;
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setNome("Fulano");
        laboratorio.setEndereco("Rua Fulano");
        laboratorio.setId("4");
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO(con);
        System.out.println(laboratorioDAO.inserir(laboratorio));
        ConnectionFactory.fecharConexao(con);

    }
}
