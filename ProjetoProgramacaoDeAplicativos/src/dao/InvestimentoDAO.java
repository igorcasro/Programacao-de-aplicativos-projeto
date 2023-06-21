package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Despesa;
import entities.Investimento;
import enums.Frequencia;

public class InvestimentoDAO {

    private Connection conn;

    public InvestimentoDAO(Connection conn) {
        this.conn = conn;
    }

    public void cadastrar(Investimento investimento) throws SQLException, ParseException {

        PreparedStatement st = null;

        try {

            st = conn.prepareStatement("INSERT INTO investimento (nome, frequencia, valor, data) VALUES (?, ?, ?, ?)");

            st.setString(1, investimento.getNomeInvestimento());
            st.setInt(2, investimento.getFrequenciaInvestimento().ordinal());
            st.setDouble(3, investimento.getValorInvestimento());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date data = sdf.parse(investimento.getData());
            Timestamp dataTimestamp = new Timestamp(data.getTime());

            st.setTimestamp(4, dataTimestamp);

            st.executeUpdate();

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public void atualizar(Investimento investimento) throws SQLException, ParseException {

        PreparedStatement st = null;
        
        try {

            st = conn.prepareStatement("UPDATE investimento SET nome = ?, frequencia = ?, valor = ?, data = ? WHERE id_investimento = ?");

            st.setString(1, investimento.getNomeInvestimento());
            st.setInt(2, investimento.getFrequenciaInvestimento().ordinal());
            st.setDouble(3, investimento.getValorInvestimento());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date data = sdf.parse(investimento.getData());
            Timestamp dataTimestamp = new Timestamp(data.getTime());

            st.setTimestamp(4, dataTimestamp);

            st.setInt(5, investimento.getIdInvestimento());

            st.executeUpdate();

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public int excluir(Investimento investimento) throws SQLException {

        PreparedStatement st = null;

        try {

            st = conn.prepareStatement("DELETE FROM investimento WHERE id_investimento = ?");

            st.setInt(1, investimento.getIdInvestimento());

            int linhasManipuladas = st.executeUpdate();

            return linhasManipuladas;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public List<Investimento> buscarTodos() throws SQLException {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("SELECT * FROM investimento");

            rs = st.executeQuery();

            List<Investimento> listaInvestimentos = new ArrayList<>();

            while (rs.next()) {
                Investimento investimento = new Investimento();

                investimento.setIdInvestimento(rs.getInt("id_investimento"));
                investimento.setNomeInvestimento(rs.getString("nome"));
                investimento.setFrequenciaInvestimento(Frequencia.values()[rs.getInt("frequencia")]);
                investimento.setValorInvestimento(rs.getDouble("valor"));
                investimento.setData(rs.getTimestamp("data").toString());

                listaInvestimentos.add(investimento);
            }

            return listaInvestimentos;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }
    
    public Investimento buscarPorId(int id) throws SQLException {
    	
    	PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from investimento where id_investimento = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {

				Investimento investimento = new Investimento();
				
				investimento.setIdInvestimento(rs.getInt("id_investimento"));
				investimento.setNomeInvestimento(rs.getString("nome"));
                
				investimento.setFrequenciaInvestimento(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
				investimento.setValorInvestimento(rs.getDouble("valor"));
				investimento.setData(rs.getTimestamp("data").toString());
				
				return investimento;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
    }
}
