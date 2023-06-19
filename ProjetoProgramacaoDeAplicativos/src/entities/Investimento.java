package entities;

import java.util.Date;

import enums.Frequencia;

public class Investimento {

	private String nomeInvestimento;
	private Frequencia frequenciaInvestimento;
	private double valorInvestimento;
	private Date data;
	private int idInvestimento;
	
	public Investimento() {
		
	}

	public String getNomeInvestimento() {
		return nomeInvestimento;
	}

	public void setNomeInvestimento(String nomeInvestimento) {
		this.nomeInvestimento = nomeInvestimento;
	}

	public Frequencia getFrequenciaInvestimento() {
		return frequenciaInvestimento;
	}

	public void setFrequenciaInvestimento(Frequencia frequenciaInvestimento) {
		this.frequenciaInvestimento = frequenciaInvestimento;
	}

	public double getValorInvestimento() {
		return valorInvestimento;
	}

	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdInvestimento() {
		return idInvestimento;
	}

	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
	}
	
}
