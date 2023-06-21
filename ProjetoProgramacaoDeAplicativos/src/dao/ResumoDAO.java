package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Despesa;
import entities.FundoOcasional;
import entities.Investimento;
import entities.Rendimento;
import entities.ResumoAnual;
import entities.ResumoMensal;
import enums.Frequencia;
import enums.Meses;

public class ResumoDAO {

	private Connection conn;
	
	public ResumoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public double buscarRendimentoPorMes(ResumoMensal resumoMensal) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from rendimento where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(resumoMensal.getMes().equals(Meses.Janeiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-01-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-01-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Fevereiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-02-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-02-28 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Março)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-03-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-03-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Abril)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-04-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-04-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Maio)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-05-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-05-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Junho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-06-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-06-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Julho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-07-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-07-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Agosto)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-08-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-08-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Setembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-09-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-09-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Outubro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-10-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-10-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Dezembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-11-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-11-30 23:59:59");
			} else {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-12-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-12-31 23:59:59");
			}
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorRendimentos = 0.0;
		    
		    while(rs.next()) {
		    	
		    	Rendimento rendimento = new Rendimento();
		    	
		    	rendimento.setValorRendimento(rs.getDouble("valor"));
		    	
		    	valorRendimentos += rendimento.getValorRendimento();
		    	
		    }
		    
		    return valorRendimentos;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public double buscarDespesaPorMes(ResumoMensal resumoMensal) throws SQLException, ParseException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from despesa where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(resumoMensal.getMes().equals(Meses.Janeiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-01-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-01-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Fevereiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-02-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-02-28 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Março)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-03-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-03-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Abril)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-04-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-04-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Maio)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-05-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-05-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Junho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-06-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-06-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Julho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-07-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-07-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Agosto)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-08-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-08-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Setembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-09-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-09-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Outubro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-10-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-10-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Dezembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-11-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-11-30 23:59:59");
			} else {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-12-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-12-31 23:59:59");
			}
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorDespesas = 0.0;
		    
		    while(rs.next()) {
		    	
		    	Despesa despesa = new Despesa();
		    	
		    	despesa.setValorDespesa(rs.getDouble("valor"));
		    	
		    	valorDespesas += despesa.getValorDespesa();
		    	
		    }
		    
		    return valorDespesas;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}		
	}
	
	public double buscarInvestimentoPorMes(ResumoMensal resumoMensal) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from investimento where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(resumoMensal.getMes().equals(Meses.Janeiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-01-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-01-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Fevereiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-02-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-02-28 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Março)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-03-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-03-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Abril)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-04-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-04-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Maio)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-05-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-05-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Junho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-06-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-06-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Julho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-07-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-07-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Agosto)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-08-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-08-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Setembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-09-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-09-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Outubro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-10-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-10-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Dezembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-11-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-11-30 23:59:59");
			} else {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-12-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-12-31 23:59:59");
			}
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorInvestimentos = 0.0;
		    
		    while(rs.next()) {
		    	
		    	Investimento investimento = new Investimento();
		    	
		    	investimento.setValorInvestimento(rs.getDouble("valor"));
		    	
		    	valorInvestimentos += investimento.getValorInvestimento();
		    	
		    }
		    
		    return valorInvestimentos;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public double buscarFundoOcasionalPorMes(ResumoMensal resumoMensal) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from fundo_ocasional where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(resumoMensal.getMes().equals(Meses.Janeiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-01-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-01-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Fevereiro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-02-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-02-28 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Março)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-03-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-03-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Abril)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-04-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-04-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Maio)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-05-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-05-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Junho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-06-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-06-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Julho)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-07-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-07-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Agosto)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-08-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-08-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Setembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-09-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-09-30 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Outubro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-10-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-10-31 23:59:59");
			} else if(resumoMensal.getMes().equals(Meses.Dezembro)) {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-11-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-11-30 23:59:59");
			} else {
				dataInicial = sdf.parse(resumoMensal.getAno() + "-12-01 00:00:00");
				dataFinal = sdf.parse(resumoMensal.getAno() + "-12-31 23:59:59");
			}
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorFundoOcasional = 0.0;
		    
		    while(rs.next()) {
		    	
		    	FundoOcasional fundoOcasional = new FundoOcasional();
		    	
		    	fundoOcasional.setValorFundoOcasional(rs.getDouble("valor"));
		    	fundoOcasional.setNomeFundoOcasional(rs.getString("nome"));
		    	
		    	String[] nomeSplit = fundoOcasional.getNomeFundoOcasional().split(" ");
		    	if(!nomeSplit[0].equals("Excedente")) 
		    		valorFundoOcasional += fundoOcasional.getValorFundoOcasional();
		    	
		    }
		    
		    return valorFundoOcasional;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public ResumoAnual buscarRendimentoPorAno(ResumoAnual resumoAnual) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from rendimento where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			dataInicial = sdf.parse(resumoAnual.getAno() + "-01-01 00:00:00");
			dataFinal = sdf.parse(resumoAnual.getAno() + "-12-31 23:59:59");
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorRendimentosMes = 0.0;
		    double valorRendimentosOcasional = 0.0;
		    
		    while(rs.next()) {
		    	
		    	Rendimento rendimento = new Rendimento();
		    	
		    	rendimento.setValorRendimento(rs.getDouble("valor"));
		    	rendimento.setFrequenciaRendimento(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
		    	
		    	if(rendimento.getFrequenciaRendimento() == Frequencia.Mensal) {
		    		valorRendimentosMes += (rendimento.getValorRendimento() * 12);
		    	} else {
		    		valorRendimentosOcasional += rendimento.getValorRendimento();
		    	}
		    	
		    }
		    
		    resumoAnual.setRendimentoAnualMes(valorRendimentosMes);
		    resumoAnual.setRendimentoAnualOcasional(valorRendimentosOcasional);
		    
		    return resumoAnual;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public ResumoAnual buscarDespesaPorAno(ResumoAnual resumoAnual) throws SQLException, ParseException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from despesa where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			dataInicial = sdf.parse(resumoAnual.getAno() + "-01-01 00:00:00");
			dataFinal = sdf.parse(resumoAnual.getAno() + "-12-31 23:59:59");
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorDespesasMes = 0.0;
		    double valorDespesasOcasional = 0.0;
		    
		    while(rs.next()) {
		    	
		    	Despesa despesa = new Despesa();
		    	
		    	despesa.setValorDespesa(rs.getDouble("valor"));
		    	despesa.setFrequenciaDespesa(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
		    	
		    	if(despesa.getFrequenciaDespesa() == Frequencia.Mensal) {
		    		valorDespesasMes += (despesa.getValorDespesa() * 12);
		    	} else {
		    		valorDespesasOcasional += despesa.getValorDespesa();
		    	}
		    	
		    }
		    
		    resumoAnual.setDespesaAnualMes(valorDespesasMes);
		    resumoAnual.setDespesaAnualOcasional(valorDespesasOcasional);
		    
		    return resumoAnual;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}		
	}
	
	public ResumoAnual buscarInvestimentoPorAno(ResumoAnual resumoAnual) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from investimento where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			dataInicial = sdf.parse(resumoAnual.getAno() + "-01-01 00:00:00");
			dataFinal = sdf.parse(resumoAnual.getAno() + "-12-31 23:59:59");
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorInvestimentosMes = 0.0;
		    double valorInvestimentosOcasional = 0.0;
		    
		    while(rs.next()) {
		    	
		    	Investimento investimento = new Investimento();
		    	
		    	investimento.setValorInvestimento(rs.getDouble("valor"));
		    	investimento.setValorInvestimento(rs.getDouble("valor"));
		    	investimento.setFrequenciaInvestimento(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
		    	
		    	if(investimento.getFrequenciaInvestimento() == Frequencia.Mensal) {
		    		valorInvestimentosMes += (investimento.getValorInvestimento() * 12);
		    	} else {
		    		valorInvestimentosOcasional += investimento.getValorInvestimento();
		    	}
		    
		    }
		    
		    resumoAnual.setInvestimentoAnualMes(valorInvestimentosMes);
		    resumoAnual.setInvestimentoAnualOcasional(valorInvestimentosOcasional);
		    
		    return resumoAnual;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public ResumoAnual buscarFundoOcasionalPorAno(ResumoAnual resumoAnual) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from fundo_ocasional where data between ? and ?");
			
			Date dataInicial = null;
			Date dataFinal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			dataInicial = sdf.parse(resumoAnual.getAno() + "-01-01 00:00:00");
			dataFinal = sdf.parse(resumoAnual.getAno() + "-12-31 23:59:59");
			
			Timestamp dataInicialTimestamp = new Timestamp(dataInicial.getTime());
		    Timestamp dataFinalTimestamp = new Timestamp(dataFinal.getTime());
		    
		    st.setTimestamp(1, dataInicialTimestamp);
		    st.setTimestamp(2, dataFinalTimestamp);
			
		    rs = st.executeQuery();
		    
		    double valorFundoMes = 0.0;
		    double valorFundoOcasional = 0.0;
		    double valorFundoExcedente = 0.0;
		    
		    while(rs.next()) {
		    	
		    	FundoOcasional fundoOcasional = new FundoOcasional();
		    	
		    	fundoOcasional.setValorFundoOcasional(rs.getDouble("valor"));
		    	fundoOcasional.setNomeFundoOcasional(rs.getString("nome"));
		    	
		    	fundoOcasional.setFrequenciaFundoOcasional(rs.getInt("frequencia") == 0 ? Frequencia.Mensal : Frequencia.Ocasional);
		    	
		    	String[] nomeSplit = fundoOcasional.getNomeFundoOcasional().split(" ");
		    	if(nomeSplit[0].equals("Excedente")) {
		    		valorFundoExcedente += fundoOcasional.getValorFundoOcasional();
		    	} else {
		    		if(fundoOcasional.getFrequenciaFundoOcasional() == Frequencia.Mensal) {
			    		valorFundoMes += (fundoOcasional.getValorFundoOcasional() * 12);
			    	} else {
			    		valorFundoOcasional += fundoOcasional.getValorFundoOcasional();
			    	}
		    	}
		    		
		    	
		    }
		    
		    resumoAnual.setFundoAnualMes(valorFundoMes);
		    resumoAnual.setFundoAnualOcasional(valorFundoOcasional);
		    resumoAnual.setFundoExcedente(valorFundoExcedente);
		    
		    return resumoAnual;
		    
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
