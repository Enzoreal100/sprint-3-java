package br.com.fiap.main;

import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dto.Funcionario;
import java.sql.Connection;
import java.util.ArrayList;

public class testeCreate_Funcionario {
    public static void main(String[] args){
        Connection con = ConnectionFactory.abrirConexao();
        // Funcionario funcionario = new Funcionario();
        // funcionario.setNome("Astrogildo");
        // funcionario.setCargo(1);
        // funcionario.setLaboratorio(1);
        // FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
        // System.out.println(funcionarioDAO.inserir(funcionario));
        FuncionarioDAO DAO = new FuncionarioDAO(con);
//        ArrayList<Funcionario> lista;
//        lista = DAO.listarTodos();
//        for (Funcionario func : lista) {
//            System.out.println("ID: " + func.getId());
//            System.out.println("Nome: " + func.getNome());
//            System.out.println("Cargo: " + func.getCargo());
//            System.out.println("Laboratorio: " + func.getLaboratorio());
//            System.out.println("-------------------------");
//        }
        Funcionario funcionario;
        funcionario = DAO.pegarUmPorId(1);
        if (funcionario == null) {
            System.out.println("Usuário não encontrado!");
        }
        else {
            System.out.printf("ID: %d\nNOME: %s\nCARGO: %d\nLAB: %d\n", funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getLaboratorio());
        }
        ConnectionFactory.fecharConexao(con);
    }
}
 