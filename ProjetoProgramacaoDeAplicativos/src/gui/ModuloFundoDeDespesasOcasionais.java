package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.FundoOcasional;
import entities.Investimento;
import enums.Frequencia;
import service.FundoOcasionalService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloFundoDeDespesasOcasionais extends JFrame {

	private JPanel contentPaneModuloFundoDeDespesasOcasionais;
	private JButton btnCadastrarNovoFundo;
	private JButton btnEditarFundo;
	private JButton btnExcluirFundo;
	private JLabel lblTitulo;
	private JPanel panelFundoOcasional;
	private JTable tableFundoOcasional;
	private JScrollPane scrollPane;

	private FundoOcasionalService fundoOcasionalService;
	
	/**
	 * Create the frame.
	 */
	public ModuloFundoDeDespesasOcasionais() {
		
		this.initComponents();
		
		this.fundoOcasionalService = new FundoOcasionalService();
		
		this.buscarFundosOcasionais();	
	}
	
	private void buscarFundosOcasionais() {
		
		try {
			DefaultTableModel modelo = (DefaultTableModel) tableFundoOcasional.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
			
			List<FundoOcasional> fundosOcasionais;
			fundosOcasionais = this.fundoOcasionalService.buscarTodos();
		
			for (FundoOcasional fundoOcasional: fundosOcasionais) {
				
				modelo.addRow(new Object[] {fundoOcasional.getIdFundoOcasional(), fundoOcasional.getNomeFundoOcasional(),
						fundoOcasional.getFrequenciaFundoOcasional().equals(Frequencia.Mensal) ? fundoOcasional.getValorFundoOcasional() : "",
						fundoOcasional.getFrequenciaFundoOcasional().equals(Frequencia.Ocasional) ? fundoOcasional.getValorFundoOcasional() : "",
						fundoOcasional.getFrequenciaFundoOcasional().equals(Frequencia.Mensal) ? fundoOcasional.getValorFundoOcasional() * 12 : fundoOcasional.getValorFundoOcasional()});
			}
			JOptionPane.showMessageDialog(null, "Sucesso ao buscar fundos ocasionais", "Busca de Fundos Ocasionais", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao buscar fundos ocasionais", "Busca de Fundos Ocasionais", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void initComponents() {
		
		setTitle("Módulo Fundo de Despesas Ocasionais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloFundoDeDespesasOcasionais = new JPanel();
		contentPaneModuloFundoDeDespesasOcasionais.setBackground(new Color(128, 128, 128));
		contentPaneModuloFundoDeDespesasOcasionais.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloFundoDeDespesasOcasionais);
		contentPaneModuloFundoDeDespesasOcasionais.setLayout(null);
		
		btnCadastrarNovoFundo = new JButton("Cadastrar Novo Fundo");
		btnCadastrarNovoFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarNovoFundoActionPerformed();
			}
		});
		btnCadastrarNovoFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoFundo.setBounds(10, 344, 220, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnCadastrarNovoFundo);
		
		btnEditarFundo = new JButton("Editar Fundo");
		btnEditarFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnEditarFundoActionPerformed();
			}
		});
		btnEditarFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarFundo.setBounds(240, 344, 255, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnEditarFundo);
		
		btnExcluirFundo = new JButton("Excluir Fundo");
		btnExcluirFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Object[] options = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if(opcao == 0) {
					btnExcluirFundoActionPerformed();
				}

			}
		});
		btnExcluirFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirFundo.setBounds(505, 344, 220, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnExcluirFundo);
		
		lblTitulo = new JLabel("Fundo de Despesas Ocasionais");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(10, 10, 715, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(lblTitulo);
		
		panelFundoOcasional = new JPanel();
		panelFundoOcasional.setLayout(null);
		panelFundoOcasional.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fundo de Despesas Ocasionais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFundoOcasional.setBounds(10, 62, 715, 272);
		contentPaneModuloFundoDeDespesasOcasionais.add(panelFundoOcasional);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelFundoOcasional.add(scrollPane);
		
		tableFundoOcasional = new JTable();
		scrollPane.setViewportView(tableFundoOcasional);
		tableFundoOcasional.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Fundo Ocasional", "Fundo Ocasional", "Mensal", "Ocasional", "Total Anual"
			}
		));
	}
	
	private void btnCadastrarNovoFundoActionPerformed() {

		FundoOcasional fundoOcasional = new FundoOcasional();
				
		new CadastrarEditarFundoOcasional("Cadastrar Novo Fundo Ocasional", fundoOcasional).setVisible(true);;
		this.dispose();
		
	}
	
	private void btnEditarFundoActionPerformed() {
		
		FundoOcasional fundoOcasional = new FundoOcasional();
		int linhaSelecionada = tableFundoOcasional.getSelectedRow();
		
		try {
			fundoOcasional = fundoOcasionalService.buscarPorId(Integer.parseInt(tableFundoOcasional.getValueAt(linhaSelecionada, 0).toString()));
			
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao buscar fundo ocasional", "Busca de Fundo Ocasional", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			this.dispose();
		} 
		
		new CadastrarEditarFundoOcasional("Editar Fundo Ocasional", fundoOcasional).setVisible(true);
		this.dispose();
		
	}
	
	private void btnExcluirFundoActionPerformed() {
		
		try {
			
			FundoOcasional fundoOcasional = new FundoOcasional();
			int linhaSelecionada = tableFundoOcasional.getSelectedRow();
			
			try {
				fundoOcasional = fundoOcasionalService.buscarPorId(Integer.parseInt(tableFundoOcasional.getValueAt(linhaSelecionada, 0).toString()));
			} catch (NumberFormatException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao buscar fundo ocasional", "Busca de Fundo Ocasional", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				this.dispose();
			}
			
			fundoOcasionalService.excluir(fundoOcasional);
			
			JOptionPane.showMessageDialog(null, "Exclusão concluída com sucesso", "Exclusão de Fundo Ocasional", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new ModuloFundoDeDespesasOcasionais().setVisible(true);
			
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir fundo ocasional", "Exclusão de Fundo Ocasional", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
