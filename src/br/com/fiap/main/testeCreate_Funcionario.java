package br.com.fiap.main;

import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dto.Funcionario;
import java.sql.Connection;

public class testeCreate_Funcionario {
    public static void main(String[] args){
        Connection con = ConnectionFactory.abrirConexao();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Astrogildo");
        funcionario.setCargo("Enfermeiro");
        funcionario.setLaboratorio(1);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
        System.out.println(funcionarioDAO.inserir(funcionario));
        ConnectionFactory.fecharConexao(con);
    }
}
