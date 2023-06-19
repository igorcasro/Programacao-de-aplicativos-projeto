package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import entities.Categoria;
import entities.Despesa;
import enums.Frequencia;

public class DespesaDAOTeste {

public static void cadastrarDespesaTeste() throws SQLException, IOException, ParseException {
		
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(2);
	
		Despesa despesa = new Despesa();
		despesa.setNomeDespesa("Teste");
		despesa.setCategoriaDespesa(categoria);
		despesa.setData("2023-06-19 19:30:00");
		despesa.setFrequenciaDespesa(Frequencia.Mensal);
		despesa.setValorDespesa(1200.00);
		
		Connection conn = BancoDados.conectar();
		new DespesaDAO(conn).cadastrar(despesa);

		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void atualizarDespesaTeste() throws SQLException, IOException, ParseException {
		
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(2);
		
		Despesa despesa = new Despesa();
		despesa.setNomeDespesa("Testeeeeeeeeeeeeeeeeeee");
		despesa.setCategoriaDespesa(categoria);
		despesa.setData("2023-06-19 19:35:00");
		despesa.setFrequenciaDespesa(Frequencia.Ocasional);
		despesa.setValorDespesa(1300.00);
		despesa.setIdDespesa(2);
		
		Connection conn = BancoDados.conectar();
		new DespesaDAO(conn).atualizar(despesa);
		
		System.out.println("Categoria atualizada com sucesso.");
		
	}
	
	public static void buscarTodasDespesasTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Despesa> listaDespesas = new DespesaDAO(conn).buscarTodas();

		for (Despesa despesa : listaDespesas) {

			System.out.println(despesa.getIdDespesa() + " - " + despesa.getNomeDespesa() + " - " +
			despesa.getCategoriaDespesa().getIdCategoria() + " - " + despesa.getData() + " - " + despesa.getFrequenciaDespesa()
			+ " - " + despesa.getValorDespesa());
		}
	}
	
	public static void excluirDespesaTeste() throws SQLException, IOException {
		
		Despesa despesa = new Despesa();
		despesa.setIdDespesa(1);

		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new DespesaDAO(conn).excluir(despesa);

		if (linhasManipuladas > 0) {

			System.out.println("Despesa excluída com sucesso.");

		} else {

			System.out.println("Nenhuma despesa foi encontrada.");
		}
		
	}
	
	public static void main(String[] args) {
		
		try {

			DespesaDAOTeste.buscarTodasDespesasTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
