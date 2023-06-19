package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import entities.Investimento;
import enums.Frequencia;

public class InvestimentoDAOTeste {

    public static void cadastrarInvestimentoTeste() throws SQLException, IOException, ParseException {

        Investimento investimento = new Investimento();
        investimento.setNomeInvestimento("Investimento Teste");
        investimento.setFrequenciaInvestimento(Frequencia.Mensal);
        investimento.setValorInvestimento(1500.00);
        investimento.setData("2023-06-19 19:30:00");

        Connection conn = BancoDados.conectar();
        new InvestimentoDAO(conn).cadastrar(investimento);

        System.out.println("Cadastro efetuado com sucesso.");
    }

    public static void atualizarInvestimentoTeste() throws SQLException, IOException, ParseException {

        Investimento investimento = new Investimento();
        investimento.setIdInvestimento(1);
        investimento.setNomeInvestimento("Investimento Atualizado");
        investimento.setFrequenciaInvestimento(Frequencia.Ocasional);
        investimento.setValorInvestimento(2000.00);
        investimento.setData("2023-06-19 19:35:00");

        Connection conn = BancoDados.conectar();
        new InvestimentoDAO(conn).atualizar(investimento);

        System.out.println("Investimento atualizado com sucesso.");
    }

    public static void buscarTodosInvestimentosTeste() throws SQLException, IOException {

        Connection conn = BancoDados.conectar();
        List<Investimento> listaInvestimentos = new InvestimentoDAO(conn).buscarTodos();

        for (Investimento investimento : listaInvestimentos) {
            System.out.println(
                investimento.getIdInvestimento() + " - " +
                investimento.getNomeInvestimento() + " - " +
                investimento.getFrequenciaInvestimento() + " - " +
                investimento.getValorInvestimento() + " - " +
                investimento.getData()
            );
        }
    }

    public static void excluirInvestimentoTeste() throws SQLException, IOException {

        Investimento investimento = new Investimento();
        investimento.setIdInvestimento(1);

        Connection conn = BancoDados.conectar();
        int linhasManipuladas = new InvestimentoDAO(conn).excluir(investimento);

        if (linhasManipuladas > 0) {
            System.out.println("Investimento excluído com sucesso.");
        } else {
            System.out.println("Nenhum investimento foi encontrado.");
        }
    }

    public static void main(String[] args) {

        try {
            InvestimentoDAOTeste.excluirInvestimentoTeste();
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
