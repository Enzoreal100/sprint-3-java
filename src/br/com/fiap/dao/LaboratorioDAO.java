package br.com.fiap.dao;

import br.com.fiap.dto.Laboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LaboratorioDAO  {
    private Connection con;

    public LaboratorioDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Laboratorio laboratorio) {
        String sql = "inst into LABORATORIO(Id,endereco,nome) VALUES (?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, laboratorio.getId());
            ps.setString(2, laboratorio.getEndereco());
            ps.setString(3, laboratorio.getNome());
            if (ps.executeUpdate() > 0) {
                return "Laboratório inserido com sucesso!";
            } else {
                return "Erro ao inserir laboratório!";
            }
        } catch (SQLException e) {
            return "Erro de SQL!: " + e.getMessage();
        }
    }

    public ArrayList<Laboratorio> listarTodos(){
        String sql = "SELECT * FROM LABORATORIO";
        ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    Laboratorio laboratorio = new Laboratorio();
                    laboratorio.setId(rs.getString("ID_LABORATORIO"));
                    laboratorio.setEndereco(rs.getString("ENDERECO_LABORATORIO"));
                    laboratorio.setNome(rs.getString("NOME_LABORATORIO"));
                    laboratorios.add(laboratorio);
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratorios;
    }
}