package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CategoriaDAO;
import entities.Categoria;

public class CategoriaService {

	public CategoriaService() {
		
	}
	
	public List<Categoria> buscarTodos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Categoria> categoriasLista = new CategoriaDAO(conn).buscarTodas();
		return categoriasLista;
		
	}
	
	public Categoria buscarPorId(int idCategoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		Categoria categoria = new CategoriaDAO(conn).buscarPorId(idCategoria);
		return categoria;
		
	}
	
	public Categoria buscarPorNome(String nome) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		Categoria categoria = new CategoriaDAO(conn).buscarPorNome(nome);
		return categoria;
	}
	
	public void cadastrar(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).cadastrar(categoria);
		
	}
	
	public void atualizar(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).atualizar(categoria);
		
	}
	
	public int excluir(Categoria categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new CategoriaDAO(conn).excluir(categoria);
		
		return linhasManipuladas;
	}
	
}
