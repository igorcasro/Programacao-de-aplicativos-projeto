package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import dao.BancoDados;
import dao.ResumoDAO;
import entities.ResumoAnual;
import entities.ResumoMensal;

public class ResumoService {

	public ResumoService() {
		
	}
	
	public ResumoMensal buscarPorMes(ResumoMensal resumo) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		resumo.setRendimentoMensal(new ResumoDAO(conn).buscarRendimentoPorMes(resumo));		
		conn = BancoDados.conectar();
		resumo.setDespesaMensal(new ResumoDAO(conn).buscarDespesaPorMes(resumo));
		conn = BancoDados.conectar();
		resumo.setInvestimentoMensal(new ResumoDAO(conn).buscarInvestimentoPorMes(resumo));
		conn = BancoDados.conectar();
		resumo.setFundoOcasional(new ResumoDAO(conn).buscarFundoOcasionalPorMes(resumo));
		
		return resumo;
	}
	
	public ResumoAnual buscarPorAno(ResumoAnual resumo) throws SQLException, IOException, ParseException {
		
		Connection conn = BancoDados.conectar();
		resumo = new ResumoDAO(conn).buscarRendimentoPorAno(resumo);		
		conn = BancoDados.conectar();
		resumo = new ResumoDAO(conn).buscarDespesaPorAno(resumo);
		conn = BancoDados.conectar();
		resumo = new ResumoDAO(conn).buscarInvestimentoPorAno(resumo);
		conn = BancoDados.conectar();
		resumo = new ResumoDAO(conn).buscarFundoOcasionalPorAno(resumo);
		
		return resumo;
	}

}
