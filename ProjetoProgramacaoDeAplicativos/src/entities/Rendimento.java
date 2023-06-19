package entities;

import enums.Frequencia;

public class Rendimento {

	private Categoria categoriaRendimento;
	private String nomeRendimento;
	private Frequencia frequenciaRendimento;
	private double valorRendimento;
	private String data;
	private int idRendimento;
	
	public Rendimento() {
		
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdRendimento() {
		return idRendimento;
	}

	public void setIdRendimento(int idRendimento) {
		this.idRendimento = idRendimento;
	}
	
}
