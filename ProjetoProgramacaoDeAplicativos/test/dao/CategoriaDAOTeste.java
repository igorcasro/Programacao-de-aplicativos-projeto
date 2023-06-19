package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Categoria;

public class CategoriaDAOTeste {

	public static void cadastrarCategoriaTeste() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria("Teste");
		
		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).cadastrar(categoria);

		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void main(String[] args) {
		
		try {

			CategoriaDAOTeste.cadastrarCategoriaTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
