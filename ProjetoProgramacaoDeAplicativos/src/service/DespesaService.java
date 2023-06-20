package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import dao.BancoDados;
import dao.DespesaDAO;
import entities.Despesa;

public class DespesaService {

	public DespesaService() {
		
	}
	
	public List<Despesa> buscarTodos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Despesa> despesasLista = new DespesaDAO(conn).buscarTodas();
		return despesasLista;
		
	}
	
	public void cadastrar(Despesa despesa) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new DespesaDAO(conn).cadastrar(despesa);
		
	}
	
	public void atualizar(Despesa despesa) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new DespesaDAO(conn).atualizar(despesa);
		
	}
	
	public int excluir(Despesa despesa) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new DespesaDAO(conn).excluir(despesa);
		
		return linhasManipuladas;
	}
}
