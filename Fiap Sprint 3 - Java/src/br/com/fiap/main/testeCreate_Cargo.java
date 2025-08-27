package br.com.fiap.main;

import br.com.fiap.dao.CargoDao;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Cargo;


import java.sql.Connection;

public class testeCreate_Cargo {public static void main(String[] args) {
    Connection con = ConnectionFactory.abrirConexao();
    Cargo cargo = new Cargo();
    cargo.setNome("Maquinista");
    CargoDao cargoDao = new CargoDao(con);
    System.out.println(cargoDao.inserir(cargo));
    ConnectionFactory.fecharConexao(con);
}
}
