package entities;

public class ResumoMensal {

	private Rendimento rendimentoMensal;
	private Investimento investimentoMensal;
	private FundoOcasional fundoOcasional;
	private double totalDisponivelDespesas;
	private Despesa despesaMensal;
	private double totalFinal;
	
	public ResumoMensal(Rendimento rendimentoMensal, Investimento investimentoMensal, FundoOcasional fundoOcasional, Despesa despesaMensal) {
		
		this.rendimentoMensal = rendimentoMensal;
		this.investimentoMensal = investimentoMensal;
		this.fundoOcasional = fundoOcasional;
		this.despesaMensal = despesaMensal;
		
		this.totalDisponivelDespesas = 0;
		this.totalFinal = 0;
	}

	public Rendimento getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(Rendimento rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}

	public Investimento getInvestimentoMensal() {
		return investimentoMensal;
	}

	public void setInvestimentoMensal(Investimento investimentoMensal) {
		this.investimentoMensal = investimentoMensal;
	}

	public FundoOcasional getFundoOcasional() {
		return fundoOcasional;
	}

	public void setFundoOcasional(FundoOcasional fundoOcasional) {
		this.fundoOcasional = fundoOcasional;
	}

	public double getTotalDisponivelDespesas() {
		return totalDisponivelDespesas;
	}

	public void setTotalDisponivelDespesas(double totalDisponivelDespesas) {
		this.totalDisponivelDespesas = totalDisponivelDespesas;
	}

	public Despesa getDespesaMensal() {
		return despesaMensal;
	}

	public void setDespesaMensal(Despesa despesaMensal) {
		this.despesaMensal = despesaMensal;
	}
	
	public double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}

	public void calculoTotalDisponivelDespesasMes() {
		
		double totalDespesasDisponivel = this.rendimentoMensal.getValorRendimento() - this.investimentoMensal.getValorInvestimento() - this.fundoOcasional.getValorFundoOcasional();
		
		setTotalDisponivelDespesas(totalDespesasDisponivel);
	}
	
	public void calculoTotalDisponivelMes() {
		
		double totalDisponivel = this.totalDisponivelDespesas - this.despesaMensal.getValorDespesa();
		
		setTotalFinal(totalDisponivel);
		
	}
}
