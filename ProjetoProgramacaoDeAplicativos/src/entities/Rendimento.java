package entities;

import java.util.Date;

import enums.Frequencia;

public class Rendimento {

	private Categoria categoriaRendimento;
	private String nomeRendimento;
	private Frequencia frequenciaRendimento;
	private double valorRendimento;
	private Date data;
	
	public Rendimento(Categoria categoriaRendimento, String nomeRendimento, Frequencia frequenciaRendimento,
			double valorRendimento, Date data) {
		
		this.categoriaRendimento = categoriaRendimento;
		this.nomeRendimento = nomeRendimento;
		this.frequenciaRendimento = frequenciaRendimento;
		this.valorRendimento = valorRendimento;
		this.data = data;
	}

	public Categoria getCategoriaRendimento() {
		return categoriaRendimento;
	}

	public void setCategoriaRendimento(Categoria categoriaRendimento) {
		this.categoriaRendimento = categoriaRendimento;
	}

	public String getNomeRendimento() {
		return nomeRendimento;
	}

	public void setNomeRendimento(String nomeRendimento) {
		this.nomeRendimento = nomeRendimento;
	}

	public Frequencia getFrequenciaRendimento() {
		return frequenciaRendimento;
	}

	public void setFrequenciaRendimento(Frequencia frequenciaRendimento) {
		this.frequenciaRendimento = frequenciaRendimento;
	}

	public double getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
