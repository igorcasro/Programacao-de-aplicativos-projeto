package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;

import entities.Investimento;
import enums.Frequencia;
import service.InvestimentoService;

public class ModuloInvestimentoALongoPrazo extends JFrame {

	private JPanel contentPaneModuloInvestimentoALongoPrazo;
	private JButton btnCadastrarNovoInvestimento;
	private JButton btnEditarInvestimento;
	private JButton btnExcluirInvestimento;
	private JLabel lblInvestimentoALongo;
	private JTable tableInvestimentos;
	private JScrollPane scrollPane;

	private InvestimentoService investimentoService;
	
	/**
	 * Create the frame.
	 */
	public ModuloInvestimentoALongoPrazo() {
		
		this.initComponents();
		
		this.investimentoService = new InvestimentoService();
		
		this.buscarInvestimentos();
	}
	
	private void buscarInvestimentos() {
		
		try {
			DefaultTableModel modelo = (DefaultTableModel) tableInvestimentos.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
			
			List<Investimento> investimentos;
			investimentos = this.investimentoService.buscarTodos();
		
			for (Investimento investimento: investimentos) {
				
				modelo.addRow(new Object[] {investimento.getIdInvestimento(), investimento.getNomeInvestimento(),
						investimento.getFrequenciaInvestimento().equals(Frequencia.Mensal) ? investimento.getValorInvestimento() : "",
						investimento.getFrequenciaInvestimento().equals(Frequencia.Ocasional) ? investimento.getValorInvestimento() : "",
						investimento.getFrequenciaInvestimento().equals(Frequencia.Mensal) ? investimento.getValorInvestimento() * 12 : investimento.getValorInvestimento()});
			}
			JOptionPane.showMessageDialog(null, "Sucesso ao buscar investimentos", "Busca de Investimentos", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao buscar investimentos", "Busca de Investimentos", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void initComponents() {
		
		setTitle("Módulo Investimento a Longo Prazo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloInvestimentoALongoPrazo = new JPanel();
		contentPaneModuloInvestimentoALongoPrazo.setBackground(new Color(128, 128, 128));
		contentPaneModuloInvestimentoALongoPrazo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloInvestimentoALongoPrazo);
		contentPaneModuloInvestimentoALongoPrazo.setLayout(null);
		
		btnCadastrarNovoInvestimento = new JButton("Cadastrar Novo Investimento");
		btnCadastrarNovoInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarNovoInvestimentoActionPerformed();
			}
		});
		btnCadastrarNovoInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoInvestimento.setBounds(10, 344, 269, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnCadastrarNovoInvestimento);
		
		btnEditarInvestimento = new JButton("Editar Investimento");
		btnEditarInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnEditarInvestimentoActionPerformed();
			}
		});
		btnEditarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarInvestimento.setBounds(289, 344, 208, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnEditarInvestimento);
		
		btnExcluirInvestimento = new JButton("Excluir Investimento");
		btnExcluirInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Object[] options = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if(opcao == 0) {
					btnExcluirInvestimentoActionPerformed();
				}
			}
		});
		btnExcluirInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirInvestimento.setBounds(507, 344, 218, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnExcluirInvestimento);
		
		lblInvestimentoALongo = new JLabel("Investimento a Longo Prazo");
		lblInvestimentoALongo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvestimentoALongo.setForeground(Color.WHITE);
		lblInvestimentoALongo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblInvestimentoALongo.setBounds(10, 10, 715, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(lblInvestimentoALongo);
		
		JPanel panelInvestimentos = new JPanel();
		panelInvestimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Investimento a Longo Prazo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInvestimentos.setBounds(10, 62, 715, 272);
		contentPaneModuloInvestimentoALongoPrazo.add(panelInvestimentos);
		panelInvestimentos.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelInvestimentos.add(scrollPane);
		
		tableInvestimentos = new JTable();
		scrollPane.setViewportView(tableInvestimentos);
		tableInvestimentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Investimento", "Investimento", "Mensal", "Ocasional", "Total Anual"
			}
		));
	}
	
	private void btnCadastrarNovoInvestimentoActionPerformed() {

		Investimento investimento = new Investimento();
				
		new CadastrarEditarInvestimento("Cadastrar Novo Investimento", investimento).setVisible(true);;
		this.dispose();
		
	}
	
	private void btnEditarInvestimentoActionPerformed() {
		
		Investimento investimento = new Investimento();
		int linhaSelecionada = tableInvestimentos.getSelectedRow();
		
		try {
			investimento = investimentoService.buscarPorId(Integer.parseInt(tableInvestimentos.getValueAt(linhaSelecionada, 0).toString()));
			
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao buscar investimento", "Busca de Investimento", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			this.dispose();
		} 
		
		new CadastrarEditarInvestimento("Editar Investimento", investimento).setVisible(true);
		this.dispose();
		
	}
	
	private void btnExcluirInvestimentoActionPerformed() {
		
		try {
			
			Investimento investimento = new Investimento();
			int linhaSelecionada = tableInvestimentos.getSelectedRow();
			
			try {
				investimento = investimentoService.buscarPorId(Integer.parseInt(tableInvestimentos.getValueAt(linhaSelecionada, 0).toString()));
			} catch (NumberFormatException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao buscar investimento", "Busca de Investimento", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				this.dispose();
			}
			
			investimentoService.excluir(investimento);
			
			JOptionPane.showMessageDialog(null, "Exclusão concluída com sucesso", "Exclusão de Investimento", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new ModuloInvestimentoALongoPrazo().setVisible(true);
			
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir investimento", "Exclusão de Investimento", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
