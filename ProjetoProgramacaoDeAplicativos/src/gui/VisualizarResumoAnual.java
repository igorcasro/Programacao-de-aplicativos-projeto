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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import entities.ResumoAnual;
import service.FundoOcasionalService;
import service.ResumoService;

public class VisualizarResumoAnual extends JFrame {

	private JPanel contentPane;
	private JTable tableResumoAnual;
	
	private ResumoAnual resumoAnual;
	private ResumoService resumoService;
	private FundoOcasionalService fundoOcasionalService;

	/**
	 * Create the frame.
	 */
	public VisualizarResumoAnual(ResumoAnual resumoAnual) {
		this.resumoAnual = resumoAnual;
		
		this.resumoService = new ResumoService();
		this.fundoOcasionalService = new FundoOcasionalService();
		
		this.initComponents();
		
		this.buscarResumoAnual();
		
	}
	
	private void buscarResumoAnual() {
		
		try {
		    DefaultTableModel modelo = (DefaultTableModel) tableResumoAnual.getModel();
		    modelo.setDataVector(null, new Object[]{"Descrição", "Mensal (x12)", "Ocasional", "Total Anual"}); // Limpa os dados antigos e define os títulos das colunas
		    
		    resumoAnual = this.resumoService.buscarPorAno(resumoAnual);

		    resumoAnual.calculoTotalDisponivelDespesasAno();
		    resumoAnual.calculoTotalDisponivelMes();
		    
		    double rendimentoAnual = resumoAnual.getRendimentoAnualMes() + resumoAnual.getRendimentoAnualOcasional();
		    double investimentoAnual = resumoAnual.getInvestimentoAnualMes() + resumoAnual.getInvestimentoAnualOcasional();
		    double fundoAnual = resumoAnual.getFundoAnualMes() + resumoAnual.getFundoAnualOcasional();
		    
		    modelo.addRow(new Object[]{
		    		"Rendimento", resumoAnual.getRendimentoAnualMes(), resumoAnual.getRendimentoAnualOcasional(), 
		    		"R$" + rendimentoAnual });
		    modelo.addRow(new Object[]{
		    		"Investimento a Longo Prazo", resumoAnual.getInvestimentoAnualMes(), resumoAnual.getInvestimentoAnualOcasional(),
		    		"R$" + investimentoAnual});
		    modelo.addRow(new Object[]{
		    		"Fundo para Despesas Ocasionais", resumoAnual.getFundoAnualMes(), resumoAnual.getFundoAnualOcasional(),
		    		"R$" + fundoAnual});
		    modelo.addRow(new Object[]{
		    		"Total Disponível para Despesas Durante o Ano", null, null,
		    		"R$" + resumoAnual.getTotalDisponivelDespesas()});
		    modelo.addRow(new Object[]{
		    		"Total Despesas Mensais Orçadas (12 meses)", null, null,
		    		"R$" + resumoAnual.getDespesaAnualMes()});
		    modelo.addRow(new Object[]{
		    		"Total Despesas Mensais Ocasionais para o Ano", null, null,
		    		"R$" + resumoAnual.getDespesaAnualOcasional()});
		    modelo.addRow(new Object[]{
		    		"Valor Total Restante ao Final do Ano", null, null,
		    		"R$" + resumoAnual.getTotalFinal()});

		    tableResumoAnual.getColumnModel().getColumn(0).setPreferredWidth(400);
		    
		    JOptionPane.showMessageDialog(null, "Sucesso ao buscar resumo", "Busca de Resumo", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
		    JOptionPane.showMessageDialog(null, "Erro ao buscar resumo", "Busca de Resumo", JOptionPane.ERROR_MESSAGE);
		    e.printStackTrace();
		    this.dispose();
		}

		
	}
	
	private void initComponents() {
		
		setTitle("Resumo " + resumoAnual.getAno());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResumoDoAno = new JLabel("Resumo do ano de " + resumoAnual.getAno());
		lblResumoDoAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumoDoAno.setForeground(Color.WHITE);
		lblResumoDoAno.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblResumoDoAno.setBounds(10, 10, 715, 42);
		contentPane.add(lblResumoDoAno);
		
		JPanel panelResumoAnual = new JPanel();
		panelResumoAnual.setLayout(null);
		panelResumoAnual.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resumo Anual", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelResumoAnual.setBounds(10, 62, 715, 214);
		contentPane.add(panelResumoAnual);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 180);
		panelResumoAnual.add(scrollPane);
		
		tableResumoAnual = new JTable();
		tableResumoAnual.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableResumoAnual.setRowHeight(22);
		scrollPane.setViewportView(tableResumoAnual);
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(headerRenderer.getFont().deriveFont(Font.BOLD, 20));
        for (int i = 0; i < tableResumoAnual.getColumnModel().getColumnCount(); i++) {
        	tableResumoAnual.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
		tableResumoAnual.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rendimento", null, null, null},
				{"Investimento a Longo Prazo", null, null, null},
				{"Fundo para Despesas Ocasionais", null, null, null},
				{"Total Dispon\u00EDvel para Despesas Durante o Ano", null, null, null},
				{"Total Despesas Mensais Orçadas (12 meses)", null, null, null},
				{"Total Despesas Ocasionais para o Ano", null, null, null},
				{"Valor Total Restante ao Final do Ano", null, null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Mensal (x12)", "Ocasional", "Total Anual"
			}
		));
		
		
	}

}
