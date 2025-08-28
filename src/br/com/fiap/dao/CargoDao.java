package br.com.fiap.dao;

import br.com.fiap.dto.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CargoDao  {
    private Connection con;

    public CargoDao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Cargo cargo) {
        String sql = "inst into ddd_cargo(cargo) VALUES (?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, cargo.getNome());
            if (ps.executeUpdate() > 0) {
                return "Cargo inserido com sucesso!";
            } else {
                return "Erro ao inserir Cargo!";
            }
        } catch (SQLException e) {
            return "Erro de SQL!: " + e.getMessage();
        }
    }
}