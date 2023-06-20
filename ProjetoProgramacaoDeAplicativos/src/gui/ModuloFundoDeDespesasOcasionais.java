package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModuloFundoDeDespesasOcasionais extends JFrame {

	private JPanel contentPaneModuloFundoDeDespesasOcasionais;
	private JButton btnCadastrarNovoFundo;
	private JButton btnEditarFundo;
	private JButton btnExcluirFundo;
	private JLabel lblTitulo;
	private JPanel panelInvestimentos;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public ModuloFundoDeDespesasOcasionais() {
		setTitle("Módulo Fundo de Despesas Ocasionais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloFundoDeDespesasOcasionais = new JPanel();
		contentPaneModuloFundoDeDespesasOcasionais.setBackground(new Color(128, 128, 128));
		contentPaneModuloFundoDeDespesasOcasionais.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloFundoDeDespesasOcasionais);
		contentPaneModuloFundoDeDespesasOcasionais.setLayout(null);
		
		btnCadastrarNovoFundo = new JButton("Cadastrar Novo Fundo");
		btnCadastrarNovoFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoFundo.setBounds(10, 344, 220, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnCadastrarNovoFundo);
		
		btnEditarFundo = new JButton("Editar Fundo");
		btnEditarFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarFundo.setBounds(240, 344, 255, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnEditarFundo);
		
		btnExcluirFundo = new JButton("Excluir Fundo");
		btnExcluirFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirFundo.setBounds(505, 344, 220, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnExcluirFundo);
		
		lblTitulo = new JLabel("Fundo de Despesas Ocasionais");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(10, 10, 715, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(lblTitulo);
		
		panelInvestimentos = new JPanel();
		panelInvestimentos.setLayout(null);
		panelInvestimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fundo de Despesas Ocasionais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInvestimentos.setBounds(10, 62, 715, 272);
		contentPaneModuloFundoDeDespesasOcasionais.add(panelInvestimentos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelInvestimentos.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fundo Ocasional", "Mensal", "Ocasional", "Total Anual"
			}
		));
	}
}
