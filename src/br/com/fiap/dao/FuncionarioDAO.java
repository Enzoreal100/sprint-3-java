package br.com.fiap.dao;

import br.com.fiap.dto.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


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
            ps.setInt(2, funcionario.getCargo());
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

    public ArrayList<Funcionario> listarTodos() {
        String sql = "SELECT * FROM FUNCIONARIO ORDER BY DATA_CRIACAO ASC";
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getString("ID_FUNCIONARIO"));
                    funcionario.setNome(rs.getString("NOME_FUNCIONARIO"));
                    funcionario.setCargo(rs.getInt("CARGO_FUNCIONARIO"));
                    funcionario.setLaboratorio(rs.getInt("LABORATORIO_FUNCIONARIO"));
                    funcionarios.add(i, funcionario);
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}