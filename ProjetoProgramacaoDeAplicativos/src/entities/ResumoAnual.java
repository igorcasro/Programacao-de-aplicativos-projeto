package entities;

public class ResumoAnual {

	private String ano;
	private double rendimentoAnualMes;
	private double rendimentoAnualOcasional;
	private double investimentoAnualMes;
	private double investimentoAnualOcasional;
	private double fundoAnualMes;
	private double fundoAnualOcasional;
	private double fundoExcedente;
	private double totalDisponivelDespesas;
	private double despesaAnualMes;
	private double despesaAnualOcasional;
	private double totalFinal;
	
	public ResumoAnual() {
		
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public double getRendimentoAnualMes() {
		return rendimentoAnualMes;
	}
	
	public void setRendimentoAnualMes(double rendimentoAnualMes) {
		this.rendimentoAnualMes = rendimentoAnualMes;
	}
	
	public double getRendimentoAnualOcasional() {
		return rendimentoAnualOcasional;
	}
	
	public void setRendimentoAnualOcasional(double rendimentoAnualOcasional) {
		this.rendimentoAnualOcasional = rendimentoAnualOcasional;
	}
	
	public double getInvestimentoAnualMes() {
		return investimentoAnualMes;
	}
	
	public void setInvestimentoAnualMes(double investimentoAnualMes) {
		this.investimentoAnualMes = investimentoAnualMes;
	}
	
	public double getInvestimentoAnualOcasional() {
		return investimentoAnualOcasional;
	}
	
	public void setInvestimentoAnualOcasional(double investimentoAnualOcasional) {
		this.investimentoAnualOcasional = investimentoAnualOcasional;
	}
	
	public double getFundoAnualMes() {
		return fundoAnualMes;
	}
	
	public void setFundoAnualMes(double fundoAnualMes) {
		this.fundoAnualMes = fundoAnualMes;
	}
	
	public double getFundoAnualOcasional() {
		return fundoAnualOcasional;
	}
	
	public void setFundoAnualOcasional(double fundoAnualOcasional) {
		this.fundoAnualOcasional = fundoAnualOcasional;
	}
	
	public double getTotalDisponivelDespesas() {
		return totalDisponivelDespesas;
	}
	
	public void setTotalDisponivelDespesas(double totalDisponivelDespesas) {
		this.totalDisponivelDespesas = totalDisponivelDespesas;
	}
	
	public double getDespesaAnualMes() {
		return despesaAnualMes;
	}
	
	public void setDespesaAnualMes(double despesaAnualMes) {
		this.despesaAnualMes = despesaAnualMes;
	}
	
	public double getDespesaAnualOcasional() {
		return despesaAnualOcasional;
	}
	
	public void setDespesaAnualOcasional(double despesaAnualOcasional) {
		this.despesaAnualOcasional = despesaAnualOcasional;
	}
	
	public double getTotalFinal() {
		return totalFinal;
	}
	
	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}
	
	public double getFundoExcedente() {
		return fundoExcedente;
	}

	public void setFundoExcedente(double fundoExcedente) {
		this.fundoExcedente = fundoExcedente;
	}

	public void calculoTotalDisponivelDespesasAno() {
		
		double totalDespesasDisponivel = this.rendimentoAnualMes + this.rendimentoAnualOcasional - this.investimentoAnualMes - this.investimentoAnualOcasional;
		
		setTotalDisponivelDespesas(totalDespesasDisponivel);
	}
	
	public void calculoTotalDisponivelMes() {
		
		double totalDisponivel = this.totalDisponivelDespesas - this.despesaAnualMes - this.despesaAnualOcasional;
		
		setTotalFinal(totalDisponivel);
		
	}
	
}
