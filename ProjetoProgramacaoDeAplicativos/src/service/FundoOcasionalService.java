package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import dao.BancoDados;
import dao.FundoOcasionalDAO;
import entities.FundoOcasional;

public class FundoOcasionalService {
		
	public FundoOcasionalService() {
		
	}
	
	public List<FundoOcasional> buscarTodos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<FundoOcasional> fundosOcasionaisLista = new FundoOcasionalDAO(conn).buscarTodos();
		return fundosOcasionaisLista;
		
	}
	
	public void cadastrar(FundoOcasional fundoOcasional) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new FundoOcasionalDAO(conn).cadastrar(fundoOcasional);
		
	}
	
	public void atualizar(FundoOcasional fundoOcasional) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		new FundoOcasionalDAO(conn).atualizar(fundoOcasional);
		
	}
	
	public int excluir(FundoOcasional fundoOcasional) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new FundoOcasionalDAO(conn).excluir(fundoOcasional);
		
		return linhasManipuladas;
	}
	
}
