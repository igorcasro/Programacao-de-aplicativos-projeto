package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import entities.FundoOcasional;
import enums.Frequencia;

public class FundoOcasionalDAOTeste {

	public static void cadastrarFundoOcasionalTeste() throws SQLException, IOException, ParseException {
		
		FundoOcasional fundoOcasional = new FundoOcasional();
		fundoOcasional.setNomeFundoOcasional("Teste");
		fundoOcasional.setFrequenciaFundoOcasional(Frequencia.Mensal);
		fundoOcasional.setValorFundoOcasional(1200.00);
		fundoOcasional.setData("2023-06-19 20:07:35");
		
		Connection conn = BancoDados.conectar();
		new FundoOcasionalDAO(conn).cadastrar(fundoOcasional);

		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void atualizarFundoOcasionalTeste() throws SQLException, IOException, ParseException {
		
		FundoOcasional fundoOcasional = new FundoOcasional();
		fundoOcasional.setNomeFundoOcasional("Testeeeeeeeeeeeeeeeeeee");
		fundoOcasional.setFrequenciaFundoOcasional(Frequencia.Ocasional);
		fundoOcasional.setValorFundoOcasional(1300.00);
		fundoOcasional.setData("2023-06-19 20:07:35");
		fundoOcasional.setIdFundoOcasional(1);
		
		Connection conn = BancoDados.conectar();
		new FundoOcasionalDAO(conn).atualizar(fundoOcasional);
		
		System.out.println("Fundo Ocasional atualizado com sucesso.");
		
	}
	
	public static void buscarTodosFundosOcasionaisTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<FundoOcasional> listaFundosOcasionais = new FundoOcasionalDAO(conn).buscarTodos();

		for (FundoOcasional fundoOcasional : listaFundosOcasionais) {

			System.out.println(fundoOcasional.getIdFundoOcasional() + " - " + fundoOcasional.getNomeFundoOcasional()
			+ " - " + fundoOcasional.getData() + " - " + fundoOcasional.getFrequenciaFundoOcasional() + 
			" - " + fundoOcasional.getValorFundoOcasional());
		}
	}
	
	public static void excluirFundoOcasionalTeste() throws SQLException, IOException {
		
		FundoOcasional fundoOcasional = new FundoOcasional();
		fundoOcasional.setIdFundoOcasional(1);

		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new FundoOcasionalDAO(conn).excluir(fundoOcasional);

		if (linhasManipuladas > 0) {

			System.out.println("Fundo Ocasional excluído com sucesso.");

		} else {

			System.out.println("Nenhum Fundo Ocasional foi encontrado.");
		}
		
	}
	
	public static void main(String[] args) {
		
		try {

			FundoOcasionalDAOTeste.excluirFundoOcasionalTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
