package entities;

import java.util.Date;

import enums.Frequencia;

public class Despesa {

	private Categoria categoriaDespesa;
	private String nomeDespesa;
	private Frequencia frequenciaDespesa;
	private double valorDespesa;
	private Date data;
	
	public Despesa(Categoria categoriaDespesa, String nomeDespesa, Frequencia frequenciaDespesa,
			double valorDespesa, Date data) {
		
		this.categoriaDespesa = categoriaDespesa;
		this.nomeDespesa = nomeDespesa;
		this.frequenciaDespesa = frequenciaDespesa;
		this.valorDespesa = valorDespesa;
		this.data = data;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
