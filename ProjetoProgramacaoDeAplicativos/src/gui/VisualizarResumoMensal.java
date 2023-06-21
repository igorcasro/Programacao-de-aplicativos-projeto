package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.FundoOcasional;
import entities.ResumoMensal;
import enums.Frequencia;
import service.FundoOcasionalService;
import service.ResumoService;

public class VisualizarResumoMensal extends JFrame {

	private JPanel contentPane;
	private JTable tableResumoMensal;
	
	private ResumoMensal resumoMensal;
	private ResumoService resumoService;
	private FundoOcasionalService fundoOcasionalService;
	
	/**
	 * Create the frame.
	 */
	public VisualizarResumoMensal(ResumoMensal resumoMensal) {
		
		this.resumoMensal = resumoMensal;
		
		this.resumoService = new ResumoService();
		this.fundoOcasionalService = new FundoOcasionalService();
		
		this.initComponents();
		
		this.buscarResumoMensal();
		
	}
	
	private void buscarResumoMensal() {
		
		try {
		    DefaultTableModel modelo = (DefaultTableModel) tableResumoMensal.getModel();
		    modelo.setDataVector(null, new Object[]{"Descrição", "Total Mensal"}); // Limpa os dados antigos e define os títulos das colunas
		    
		    resumoMensal = this.resumoService.buscarPorMes(resumoMensal);

		    resumoMensal.calculoTotalDisponivelDespesasMes();
		    resumoMensal.calculoTotalDisponivelMes();

		    modelo.addRow(new Object[]{"Rendimento", "R$" + resumoMensal.getRendimentoMensal()});
		    modelo.addRow(new Object[]{"Investimento a Longo Prazo", "R$" + resumoMensal.getInvestimentoMensal()});
		    modelo.addRow(new Object[]{"Fundo para Despesas Ocasionais", "R$" + resumoMensal.getFundoOcasional()});
		    modelo.addRow(new Object[]{"Valor Total Disponível por Mês para Despesas", "R$" + resumoMensal.getTotalDisponivelDespesas()});
		    modelo.addRow(new Object[]{"Valor Total das Despesas Orçadas para o Mês", "R$" + resumoMensal.getDespesaMensal()});
		    modelo.addRow(new Object[]{"Valor Total", "R$" + resumoMensal.getTotalFinal()});
		    
		    if(resumoMensal.getTotalFinal() > 0.0) {
		    	FundoOcasional fundoOcasional = new FundoOcasional();
		    	fundoOcasional.setNomeFundoOcasional("Excedente " + resumoMensal.getMes());
		    	if(resumoMensal.getMes().ordinal() < 10) {
		    		fundoOcasional.setData(resumoMensal.getAno()+ "-0" + resumoMensal.getMes().ordinal() + "-01 00:00:00");
		    	} else {
		    		fundoOcasional.setData(resumoMensal.getAno()+ "-" + resumoMensal.getMes().ordinal() + "-01 00:00:00");
		    	}
		    	
		    	fundoOcasional.setFrequenciaFundoOcasional(Frequencia.Ocasional);
		    	fundoOcasional.setValorFundoOcasional(resumoMensal.getTotalFinal());
		    	
		    	fundoOcasionalService.cadastrar(fundoOcasional);
		    }

		    JOptionPane.showMessageDialog(null, "Sucesso ao buscar resumo", "Busca de Resumo", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
		    JOptionPane.showMessageDialog(null, "Erro ao buscar resumo", "Busca de Resumo", JOptionPane.ERROR_MESSAGE);
		    e.printStackTrace();
		    this.dispose();
		}

		
	}
	
	private void initComponents() {
		
		setTitle("Resumo " + resumoMensal.getMes());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResumoDoMs = new JLabel("Resumo do mês de " + resumoMensal.getMes());
		lblResumoDoMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumoDoMs.setForeground(Color.WHITE);
		lblResumoDoMs.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblResumoDoMs.setBounds(10, 10, 715, 42);
		contentPane.add(lblResumoDoMs);
		
		JPanel panelResumoMensal = new JPanel();
		panelResumoMensal.setLayout(null);
		panelResumoMensal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resumo Mensal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelResumoMensal.setBounds(10, 62, 715, 196);
		contentPane.add(panelResumoMensal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 160);
		panelResumoMensal.add(scrollPane);
		
		tableResumoMensal = new JTable();
		tableResumoMensal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableResumoMensal.setRowHeight(22);
		scrollPane.setViewportView(tableResumoMensal);
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(headerRenderer.getFont().deriveFont(Font.BOLD, 20));
        for (int i = 0; i < tableResumoMensal.getColumnModel().getColumnCount(); i++) {
        	tableResumoMensal.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
		tableResumoMensal.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rendimento", null},
				{"Investimento a Longo Prazo", null},
				{"Fundo para Despesas Ocasionais", null},
				{"Valor Total Dispon\u00EDvel por M\u00EAs para Despesas", null},
				{"Valor Total das Despesas Or\u00E7adas para o M\u00EAs", null},
				{"Valor Total", null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Total Mensal"
			}
		));
	}
}
