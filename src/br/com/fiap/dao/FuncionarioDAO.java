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
        String sql = "inst into ddd_funcionario(id,nome,cargo,laboratorio) VALUES (?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, funcionario.getId());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCargo());
            ps.setString(4, funcionario.getLaboratorio());
            if (ps.executeUpdate() > 0) {
                return "Funcionario inserido com sucesso!";
            } else {
                return "Erro ao inserir Funcionario!";
            }
        } catch (SQLException e) {
            return "Erro de SQL!: " + e.getMessage();
        }
    }
}