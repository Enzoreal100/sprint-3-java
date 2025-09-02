package br.com.fiap.dao;

import br.com.fiap.dto.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CargoDao  {
    private Connection con;

    public CargoDao(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Cargo cargo) {
        String sql = "insert into CARGO(NOME_CARGO) VALUES (?)";
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

    public ArrayList<Cargo> listarTodos(){
        String sql = "SELECT * FROM CARGO";
        ArrayList<Cargo> cargos = new ArrayList<>();
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cargo cargo = new Cargo();
                    cargo.setId(rs.getInt("ID_CARGO"));
                    cargo.setNome(rs.getString("NOME_CARGO"));
                    cargos.add(cargo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargos;
    }
}