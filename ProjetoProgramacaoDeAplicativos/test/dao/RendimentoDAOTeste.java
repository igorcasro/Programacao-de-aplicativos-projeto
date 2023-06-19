package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import entities.Categoria;
import entities.Rendimento;
import enums.Frequencia;

public class RendimentoDAOTeste {

    public static void cadastrarRendimentoTeste() throws SQLException, IOException, ParseException {

    	Categoria categoria = new Categoria();
    	categoria.setIdCategoria(1);
    	categoria.setNomeCategoria("Categoria Teste");
    	
        Rendimento rendimento = new Rendimento();
        rendimento.setCategoriaRendimento(categoria);
        rendimento.setNomeRendimento("Rendimento Teste");
        rendimento.setFrequenciaRendimento(Frequencia.Mensal);
        rendimento.setValorRendimento(1000.00);
        rendimento.setData("2023-06-19 19:30:00");

        Connection conn = BancoDados.conectar();
        new RendimentoDAO(conn).cadastrar(rendimento);

        System.out.println("Cadastro efetuado com sucesso.");
    }

    public static void atualizarRendimentoTeste() throws SQLException, IOException, ParseException {

    	Categoria categoria = new Categoria();
    	categoria.setIdCategoria(1);
    	categoria.setNomeCategoria("Nova Categoria");
    	
        Rendimento rendimento = new Rendimento();
        rendimento.setIdRendimento(1);
        rendimento.setCategoriaRendimento(categoria);
        rendimento.setNomeRendimento("Rendimento Atualizado");
        rendimento.setFrequenciaRendimento(Frequencia.Ocasional);
        rendimento.setValorRendimento(1500.00);
        rendimento.setData("2023-06-19 19:35:00");

        Connection conn = BancoDados.conectar();
        new RendimentoDAO(conn).atualizar(rendimento);

        System.out.println("Rendimento atualizado com sucesso.");
    }

    public static void buscarTodosRendimentosTeste() throws SQLException, IOException {

        Connection conn = BancoDados.conectar();
        List<Rendimento> listaRendimentos = new RendimentoDAO(conn).buscarTodos();

        for (Rendimento rendimento : listaRendimentos) {
            System.out.println(
                rendimento.getIdRendimento() + " - " +
                rendimento.getCategoriaRendimento().getIdCategoria() + " - " +
                rendimento.getNomeRendimento() + " - " +
                rendimento.getFrequenciaRendimento() + " - " +
                rendimento.getValorRendimento() + " - " +
                rendimento.getData()
            );
        }
    }

    public static void excluirRendimentoTeste() throws SQLException, IOException {

        Rendimento rendimento = new Rendimento();
        rendimento.setIdRendimento(1);

        Connection conn = BancoDados.conectar();
        int linhasManipuladas = new RendimentoDAO(conn).excluir(rendimento);

        if (linhasManipuladas > 0) {
            System.out.println("Rendimento excluído com sucesso.");
        } else {
            System.out.println("Nenhum rendimento foi encontrado.");
        }
    }

    public static void main(String[] args) {

        try {
            RendimentoDAOTeste.excluirRendimentoTeste();
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
