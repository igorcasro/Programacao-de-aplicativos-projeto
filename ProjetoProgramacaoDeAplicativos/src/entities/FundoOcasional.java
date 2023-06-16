package entities;

import enums.Frequencia;

public class FundoOcasional {

	private String nomeFundoOcasional;
	private Frequencia frequenciaFundoOcasional;
	private double valorFundoOcasional;
	
	public FundoOcasional(String nomeFundoOcasional, Frequencia frequenciaFundoOcasional, double valorFundoOcasional) {
		
		this.nomeFundoOcasional = nomeFundoOcasional;
		this.frequenciaFundoOcasional = frequenciaFundoOcasional;
		this.valorFundoOcasional = valorFundoOcasional;
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
	
}
