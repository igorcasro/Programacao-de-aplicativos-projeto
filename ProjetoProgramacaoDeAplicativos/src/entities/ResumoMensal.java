package entities;

import enums.Meses;

public class ResumoMensal {

	private Meses mes;
	private String ano;
	private double rendimentoMensal;
	private double investimentoMensal;
	private double fundoOcasional;
	private double totalDisponivelDespesas;
	private double despesaMensal;
	private double totalFinal;
	
	public ResumoMensal() {

	}	

	public Meses getMes() {
		return mes;
	}

	public void setMes(Meses mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}

	public double getInvestimentoMensal() {
		return investimentoMensal;
	}

	public void setInvestimentoMensal(double investimentoMensal) {
		this.investimentoMensal = investimentoMensal;
	}

	public double getFundoOcasional() {
		return fundoOcasional;
	}

	public void setFundoOcasional(double fundoOcasional) {
		this.fundoOcasional = fundoOcasional;
	}

	public double getTotalDisponivelDespesas() {
		return totalDisponivelDespesas;
	}

	public void setTotalDisponivelDespesas(double totalDisponivelDespesas) {
		this.totalDisponivelDespesas = totalDisponivelDespesas;
	}

	public double getDespesaMensal() {
		return despesaMensal;
	}

	public void setDespesaMensal(double despesaMensal) {
		this.despesaMensal = despesaMensal;
	}

	public double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}

	public void calculoTotalDisponivelDespesasMes() {
		
		double totalDespesasDisponivel = this.rendimentoMensal - this.investimentoMensal - this.fundoOcasional;
		
		setTotalDisponivelDespesas(totalDespesasDisponivel);
	}
	
	public void calculoTotalDisponivelMes() {
		
		double totalDisponivel = this.totalDisponivelDespesas - this.despesaMensal;
		
		setTotalFinal(totalDisponivel);
		
	}

}
