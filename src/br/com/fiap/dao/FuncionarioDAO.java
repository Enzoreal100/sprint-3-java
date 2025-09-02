package br.com.fiap.dao;

import br.com.fiap.dto.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FuncionarioDAO  {
    private Connection con;

    public FuncionarioDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Funcionario funcionario) {
        String sql = "insert into FUNCIONARIO(NOME_FUNCIONARIO,CARGO_FUNCIONARIO,LABORATORIO_FUNCIONARIO) VALUES (?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getLaboratorio());
            if (ps.executeUpdate() > 0) {
                return "Funcionario inserido com sucesso!";
            } else {
                return "Erro ao inserir Funcionario!";
            }
        } catch (SQLException e) {
            return "Erro de SQL!: " + e.getMessage();
        }
    }

    public Funcionario[] listarTodos() {
        String sql = "SELECT * FROM FUNCIONARIO";
        Funcionario[] funcionarios = new Funcionario[100];
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getString("id"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCargo(rs.getString("cargo"));
                    funcionario.setLaboratorio(rs.getInt("laboratorio"));
                    funcionarios[i] = funcionario;
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}