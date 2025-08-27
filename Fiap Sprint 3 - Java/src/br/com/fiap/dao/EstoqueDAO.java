package br.com.fiap.dao;

import br.com.fiap.dto.Estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO  {
    private Connection con;

    public EstoqueDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Estoque estoque) {
        String sql = "inst into ddd_estoque(id,nome,quantidade,valorminimo) VALUES (?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, estoque.getId());
            ps.setString(2, estoque.getNome());
            ps.setInt(3, estoque.getQuantidade());
            ps.setInt(4, estoque.getValorMinimo());
            if (ps.executeUpdate() > 0) {
                return "Insumo inserido com sucesso!";
            } else {
                return "Erro ao inserir insumo!";
            }
        } catch (SQLException e) {
            return "Erro de SQL!: " + e.getMessage();
        }
    }
}
