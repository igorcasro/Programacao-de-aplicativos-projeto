package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import dao.BancoDados;
import dao.InvestimentoDAO;
import entities.Investimento;

public class InvestimentoService {

	public InvestimentoService() {
		
	}
	
	public List<Investimento> buscarTodos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Investimento> investimentosLista = new InvestimentoDAO(conn).buscarTodos();
		return investimentosLista;
		
	}
	
	public void cadastrar(Investimento investimento) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new InvestimentoDAO(conn).cadastrar(investimento);
		
	}
	
	public void atualizar(Investimento investimento) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new InvestimentoDAO(conn).atualizar(investimento);
		
	}
	
	public int excluir(Investimento investimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new InvestimentoDAO(conn).excluir(investimento);
		
		return linhasManipuladas;
	}	
}
