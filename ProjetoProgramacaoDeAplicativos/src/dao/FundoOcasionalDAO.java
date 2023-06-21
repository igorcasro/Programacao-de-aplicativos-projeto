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

import entities.FundoOcasional;
import enums.Frequencia;

public class FundoOcasionalDAO {

	private Connection conn;

	public FundoOcasionalDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(FundoOcasional fundoOcasional) throws SQLException, ParseException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO fundo_ocasional (nome, frequencia, valor, data) VALUES (?, ?, ?, ?)");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date data = sdf.parse(fundoOcasional.getData());
	        Timestamp dataTimestamp = new Timestamp(data.getTime());
			
			st.setString(1, fundoOcasional.getNomeFundoOcasional());
			st.setInt(2, fundoOcasional.getFrequenciaFundoOcasional().ordinal());
			st.setDouble(3, fundoOcasional.getValorFundoOcasional());
			st.setTimestamp(4, dataTimestamp);

			st.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public void atualizar(FundoOcasional fundoOcasional) throws SQLException, ParseException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"UPDATE fundo_ocasional SET nome = ?, frequencia = ?, valor = ?, data = ? WHERE id_fundo_ocasional = ?");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date data = sdf.parse(fundoOcasional.getData());
	        Timestamp dataTimestamp = new Timestamp(data.getTime());
			
			st.setString(1, fundoOcasional.getNomeFundoOcasional());
			st.setInt(2, fundoOcasional.getFrequenciaFundoOcasional().ordinal());
			st.setDouble(3, fundoOcasional.getValorFundoOcasional());
			st.setTimestamp(4, dataTimestamp);
			st.setInt(5, fundoOcasional.getIdFundoOcasional());

			st.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public int excluir(FundoOcasional fundoOcasional) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM fundo_ocasional WHERE id_fundo_ocasional = ?");

			st.setInt(1, fundoOcasional.getIdFundoOcasional());

			return st.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<FundoOcasional> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM fundo_ocasional");

			rs = st.executeQuery();

			List<FundoOcasional> listaFundosOcasionais = new ArrayList<>();

			while (rs.next()) {
				FundoOcasional fundoOcasional = new FundoOcasional();

				fundoOcasional.setIdFundoOcasional(rs.getInt("id_fundo_ocasional"));
				fundoOcasional.setNomeFundoOcasional(rs.getString("nome"));
				fundoOcasional.setFrequenciaFundoOcasional(
						Frequencia.values()[rs.getInt("frequencia")]);
				fundoOcasional.setData(rs.getTimestamp("data").toString());
				fundoOcasional.setValorFundoOcasional(rs.getDouble("valor"));

				listaFundosOcasionais.add(fundoOcasional);
			}

			return listaFundosOcasionais;
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public FundoOcasional buscarPorId(int id) throws SQLException {
    	
    	PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from fundo_ocasional where id_fundo_ocasional = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {

				FundoOcasional fundoOcasional = new FundoOcasional();
				
				fundoOcasional.setIdFundoOcasional(rs.getInt("id_fundo_ocasional"));
				fundoOcasional.setNomeFundoOcasional(rs.getString("nome"));
                
				fundoOcasional.setFrequenciaFundoOcasional(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
				fundoOcasional.setValorFundoOcasional(rs.getDouble("valor"));
				fundoOcasional.setData(rs.getTimestamp("data").toString());
				
				return fundoOcasional;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
    }
}