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

import entities.Categoria;
import entities.Rendimento;
import enums.Frequencia;

public class RendimentoDAO {

    private Connection conn;
    
    public RendimentoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void cadastrar(Rendimento rendimento) throws SQLException, ParseException {
        PreparedStatement st = null;
        
        try {
            st = conn.prepareStatement("INSERT INTO rendimento (nome, codigo_categoria, frequencia, valor, data) VALUES (?, ?, ?, ?, ?)");
            
            st.setString(1, rendimento.getNomeRendimento());
            st.setInt(2, rendimento.getCategoriaRendimento().getIdCategoria());
            st.setInt(3, rendimento.getFrequenciaRendimento().ordinal());
            st.setDouble(4, rendimento.getValorRendimento());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date data = sdf.parse(rendimento.getData());
            Timestamp dataTimestamp = new Timestamp(data.getTime());
            st.setTimestamp(5, dataTimestamp);
            
            st.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }
    
    public void atualizar(Rendimento rendimento) throws SQLException, ParseException {
        PreparedStatement st = null;
        
        try {
            st = conn.prepareStatement("UPDATE rendimento SET nome = ?, codigo_categoria = ?, frequencia = ?, valor = ?, data = ? WHERE id_rendimento = ?");
            
            st.setString(1, rendimento.getNomeRendimento());
            st.setInt(2, rendimento.getCategoriaRendimento().getIdCategoria());
            st.setInt(3, rendimento.getFrequenciaRendimento().ordinal());
            st.setDouble(4, rendimento.getValorRendimento());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date data = sdf.parse(rendimento.getData());
            Timestamp dataTimestamp = new Timestamp(data.getTime());
            st.setTimestamp(5, dataTimestamp);
            
            st.setInt(6, rendimento.getIdRendimento());
            
            st.executeUpdate();
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }
    
    public int excluir(Rendimento rendimento) throws SQLException {
        PreparedStatement st = null;
        
        try {
            st = conn.prepareStatement("DELETE FROM rendimento WHERE id_rendimento = ?");
            st.setInt(1, rendimento.getIdRendimento());
            
            int linhasManipuladas = st.executeUpdate();
            return linhasManipuladas;
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }
    
    public List<Rendimento> buscarTodos() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            st = conn.prepareStatement("SELECT * FROM rendimento ORDER BY nome");
            rs = st.executeQuery();
            
            List<Rendimento> listaRendimentos = new ArrayList<>();
            
            while (rs.next()) {
                Rendimento rendimento = new Rendimento();
                
                rendimento.setIdRendimento(rs.getInt("id_rendimento"));
                rendimento.setNomeRendimento(rs.getString("nome"));
                
                int idCategoria = rs.getInt("codigo_categoria");
                Categoria categoriaRendimento = new Categoria();
                categoriaRendimento.setIdCategoria(idCategoria);
                rendimento.setCategoriaRendimento(categoriaRendimento);
                
                rendimento.setFrequenciaRendimento(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
                rendimento.setValorRendimento(rs.getDouble("valor"));
                rendimento.setData(rs.getTimestamp("data").toString());
                
                listaRendimentos.add(rendimento);
            }
            
            return listaRendimentos;
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }
}
