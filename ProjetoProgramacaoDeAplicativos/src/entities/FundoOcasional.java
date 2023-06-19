package entities;

import enums.Frequencia;

public class FundoOcasional {

	private String nomeFundoOcasional;
	private Frequencia frequenciaFundoOcasional;
	private double valorFundoOcasional;
	private String data;
	private int idFundoOcasional;
	
	public FundoOcasional() {
		
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdFundoOcasional() {
		return idFundoOcasional;
	}

	public void setIdFundoOcasional(int idFundoOcasional) {
		this.idFundoOcasional = idFundoOcasional;
	}
	
}
