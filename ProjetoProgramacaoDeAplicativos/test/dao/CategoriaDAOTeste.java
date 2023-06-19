package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Categoria;

public class CategoriaDAOTeste {

	public static void cadastrarCategoriaTeste() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria("Teste");
		
		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).cadastrar(categoria);

		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void atualizarCategoriaTeste() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria("Testando");
		categoria.setIdCategoria(1);
		
		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).atualizar(categoria);
		
		System.out.println("Categoria atualizada com sucesso.");
		
	}
	
	public static void buscarTodasCategoriasTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Categoria> listaCategorias = new CategoriaDAO(conn).buscarTodas();

		for (Categoria categoria : listaCategorias) {

			System.out.println(categoria.getIdCategoria() + " - " + categoria.getNomeCategoria() );
		}
	}
	
	public static void excluirCategoriaTeste() throws SQLException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(1);

		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new CategoriaDAO(conn).excluir(categoria);

		if (linhasManipuladas > 0) {

			System.out.println("Categoria excluída com sucesso.");

		} else {

			System.out.println("Nenhuma categoria foi encontrada.");
		}
		
	}
	
	public static void main(String[] args) {
		
		try {

			CategoriaDAOTeste.cadastrarCategoriaTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
