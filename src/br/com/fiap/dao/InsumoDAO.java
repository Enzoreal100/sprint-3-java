package br.com.fiap.dao;

import br.com.fiap.dto.Insumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsumoDAO  {
    private Connection con;

    public InsumoDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Insumo estoque) {
        String sql = "insert into ESTOQUE(NOME_INSUMO,QUANTIDADE_INSUMO,QUANTIDADE_MINIMA,ID_LABORATORIO) VALUES (?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, estoque.getNome());
            ps.setInt(2, estoque.getQuantidade());
            ps.setInt(3, estoque.getValorMinimo());
            ps.setInt(4, estoque.getIdLaboratorio());
            if (ps.executeUpdate() > 0) {
                return "Insumo inserido com sucesso!";
            } else {
                return "Erro ao inserir insumo!";
            }
        } catch (SQLException e) {
            return "Erro de SQL!: " + e.getMessage();
        }
    }

    public ArrayList<Insumo> listarTodos(int idLab){
        String sql = "SELECT * FROM ESTOQUE WHERE ID_LABORATORIO = ?";
        ArrayList<Insumo> estoque = new ArrayList<>();
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, idLab);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                int i = 0;
                while (rs.next()) {
                    Insumo insumo = new Insumo();
                    insumo.setId(rs.getInt("ID_INSUMO"));
                    insumo.setNome(rs.getString("NOME_INSUMO"));
                    insumo.setQuantidade(rs.getInt("QUANTIDADE_INSUMO"));
                    insumo.setValorMinimo(rs.getInt("QUANTIDADE_MINIMA"));
                    insumo.setIdLaboratorio(rs.getInt("ID_LABORATORIO"));
                    estoque.add(i, insumo);
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estoque;
    }
}
