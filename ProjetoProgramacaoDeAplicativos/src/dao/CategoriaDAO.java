package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Categoria;

public class CategoriaDAO {

	private Connection conn;
	
	public CategoriaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into categoria (nome) values (?)");
			st.setString(1, categoria.getNomeCategoria());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
			
		}
	}
	
	public void atualizar(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update categoria set nome = ? where id_categoria = ?");
			st.setString(1, categoria.getNomeCategoria());
			st.setInt(2, categoria.getIdCategoria());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
			
		}
	}
	
	public int excluir(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {

			st = conn.prepareStatement("delete from categoria where id_categoria = ?");

			st.setInt(1, categoria.getIdCategoria());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Categoria> buscarTodas() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from categoria order by nome");

			rs = st.executeQuery();

			List<Categoria> listaCategorias = new ArrayList<>();

			while (rs.next()) {

				Categoria categoria = new Categoria();

				categoria.setNomeCategoria(rs.getString("nome"));
				categoria.setIdCategoria(rs.getInt("id_categoria"));
				
				listaCategorias.add(categoria);
			}

			return listaCategorias;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
