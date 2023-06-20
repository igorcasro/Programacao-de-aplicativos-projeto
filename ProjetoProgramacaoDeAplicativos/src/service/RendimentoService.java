package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import dao.BancoDados;
import dao.RendimentoDAO;
import entities.Rendimento;

public class RendimentoService {

	public RendimentoService() {
		
	}
	
	public List<Rendimento> buscarTodos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Rendimento> rendimentosLista = new RendimentoDAO(conn).buscarTodos();
		return rendimentosLista;
		
	}
	
	public Rendimento buscarPorId(int idRendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		Rendimento rendimento = new RendimentoDAO(conn).buscarPorId(idRendimento);
		return rendimento;
		
	}
	
	public void cadastrar(Rendimento rendimento) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new RendimentoDAO(conn).cadastrar(rendimento);
		
	}
	
	public void atualizar(Rendimento rendimento) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new RendimentoDAO(conn).atualizar(rendimento);
		
	}
	
	public int excluir(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new RendimentoDAO(conn).excluir(rendimento);
		
		return linhasManipuladas;
	}
}
