package entities;

import enums.Frequencia;

public class Despesa {

	private Categoria categoriaDespesa;
	private String nomeDespesa;
	private Frequencia frequenciaDespesa;
	private double valorDespesa;
	private String data;
	private int idDespesa;
	
	public Despesa() {

	}

	public Categoria getCategoriaDespesa() {
		return categoriaDespesa;
	}

	public void setCategoriaDespesa(Categoria categoriaDespesa) {
		this.categoriaDespesa = categoriaDespesa;
	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}

	public Frequencia getFrequenciaDespesa() {
		return frequenciaDespesa;
	}

	public void setFrequenciaDespesa(Frequencia frequenciaDespesa) {
		this.frequenciaDespesa = frequenciaDespesa;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}
	
}
