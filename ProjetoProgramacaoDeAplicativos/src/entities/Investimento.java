package entities;

import enums.Frequencia;

public class Investimento {

	private String nomeInvestimento;
	private Frequencia frequenciaInvestimento;
	private double valorInvestimento;
	
	public Investimento(String nomeInvestimento, Frequencia frequenciaInvestimento, double valorInvestimento) {
	
		this.nomeInvestimento = nomeInvestimento;
		this.frequenciaInvestimento = frequenciaInvestimento;
		this.valorInvestimento = valorInvestimento;
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
	
}
