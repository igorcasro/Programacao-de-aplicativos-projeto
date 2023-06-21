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
import enums.Frequencia;

public class DespesaDAO {

private Connection conn;
	
	public DespesaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Despesa despesa) throws SQLException, ParseException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into despesa (nome, codigo_categoria, data, frequencia, valor) values (?, ?, ?, ?, ?)");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date data = sdf.parse(despesa.getData());
	        Timestamp dataTimestamp = new Timestamp(data.getTime());
			
			st.setString(1, despesa.getNomeDespesa());
			st.setInt(2, despesa.getIdCategoriaDespesa());
			st.setTimestamp(3, dataTimestamp);
			st.setInt(4, despesa.getFrequenciaDespesa().ordinal());
			st.setDouble(5, despesa.getValorDespesa());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
			
		}
	}
	
	public void atualizar(Despesa despesa) throws SQLException, ParseException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update despesa set nome = ?, codigo_categoria = ?, data = ?, frequencia = ?, valor = ? where id_despesa = ?");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date data = sdf.parse(despesa.getData());
	        Timestamp dataTimestamp = new Timestamp(data.getTime());
			
			st.setString(1, despesa.getNomeDespesa());
			st.setInt(2, despesa.getIdCategoriaDespesa());
			st.setTimestamp(3, dataTimestamp);
			st.setInt(4, despesa.getFrequenciaDespesa().ordinal());
			st.setDouble(5, despesa.getValorDespesa());
			st.setInt(6, despesa.getIdDespesa());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
			
		}
	}
	
	public int excluir(Despesa despesa) throws SQLException {
		
		PreparedStatement st = null;
		
		try {

			st = conn.prepareStatement("delete from despesa where id_despesa = ?");

			st.setInt(1, despesa.getIdDespesa());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Despesa> buscarTodas() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT * FROM despesa ORDER BY id_despesa");

			rs = st.executeQuery();

			List<Despesa> listaDespesas = new ArrayList<>();

			while (rs.next()) {
				Despesa despesa = new Despesa();

				despesa.setIdDespesa(rs.getInt("id_despesa"));
				despesa.setNomeDespesa(rs.getString("nome"));
				
				int idCategoria = rs.getInt("codigo_categoria");
				despesa.setIdCategoriaDespesa(idCategoria);
				
				despesa.setFrequenciaDespesa(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
				despesa.setValorDespesa(rs.getDouble("valor"));
				despesa.setData(rs.getTimestamp("data").toString());
				
				listaDespesas.add(despesa);
			}

			return listaDespesas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	 public Despesa buscarPorId(int id) throws SQLException {

			PreparedStatement st = null;
			ResultSet rs = null;

			try {

				st = conn.prepareStatement("select * from despesa where id_despesa = ?");

				st.setInt(1, id);

				rs = st.executeQuery();

				if (rs.next()) {

					Despesa despesa = new Despesa();
					
					despesa.setIdDespesa(rs.getInt("id_despesa"));
					despesa.setNomeDespesa(rs.getString("nome"));
	                
	                int idCategoria = rs.getInt("codigo_categoria");
	                despesa.setIdCategoriaDespesa(idCategoria);
	                
	                despesa.setFrequenciaDespesa(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
	                despesa.setValorDespesa(rs.getDouble("valor"));
	                despesa.setData(rs.getTimestamp("data").toString());
					
					return despesa;
				}

				return null;

			} finally {

				BancoDados.finalizarStatement(st);
				BancoDados.finalizarResultSet(rs);
				BancoDados.desconectar();
			}
		}
}
