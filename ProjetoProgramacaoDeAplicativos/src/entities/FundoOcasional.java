package entities;

import java.util.Date;

import enums.Frequencia;

public class FundoOcasional {

	private String nomeFundoOcasional;
	private Frequencia frequenciaFundoOcasional;
	private double valorFundoOcasional;
	private Date data;
	
	public FundoOcasional(String nomeFundoOcasional, Frequencia frequenciaFundoOcasional, double valorFundoOcasional, Date data) {
		
		this.nomeFundoOcasional = nomeFundoOcasional;
		this.frequenciaFundoOcasional = frequenciaFundoOcasional;
		this.valorFundoOcasional = valorFundoOcasional;
		this.data = data;
	}

	public String getNomeFundoOcasional() {
		return nomeFundoOcasional;
	}

	public void setNomeFundoOcasional(String nomeFundoOcasional) {
		this.nomeFundoOcasional = nomeFundoOcasional;
	}

	public Frequencia getFrequenciaFundoOcasional() {
		return frequenciaFundoOcasional;
	}

	public void setFrequenciaFundoOcasional(Frequencia frequenciaFundoOcasional) {
		this.frequenciaFundoOcasional = frequenciaFundoOcasional;
	}

	public double getValorFundoOcasional() {
		return valorFundoOcasional;
	}

	public void setValorFundoOcasional(double valorFundoOcasional) {
		this.valorFundoOcasional = valorFundoOcasional;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
