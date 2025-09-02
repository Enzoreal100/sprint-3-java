package br.com.fiap.main;

import br.com.fiap.dao.CargoDao;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Cargo;
import java.sql.Connection;
import java.util.ArrayList;

public class testeCreate_Cargo {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        // Cargo cargo = new Cargo();
        // cargo.setNome("Enfermeiro");
        CargoDao cargoDao = new CargoDao(con);
        ArrayList<Cargo> lista;
        lista = cargoDao.listarTodos();
        for (Cargo cargo : lista) {
            System.out.printf("ID: %s,\nNOME: %s\n", cargo.getId(), cargo.getNome());
        }
        ConnectionFactory.fecharConexao(con);
    }
}
 