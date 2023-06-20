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
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ModuloInvestimentoALongoPrazo extends JFrame {

	private JPanel contentPaneModuloInvestimentoALongoPrazo;
	private JButton btnCadastrarNovoInvestimento;
	private JButton btnEditarInvestimento;
	private JButton btnExcluirInvestimento;
	private JLabel lblInvestimentoALongo;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public ModuloInvestimentoALongoPrazo() {
		setTitle("Módulo Investimento a Longo Prazo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloInvestimentoALongoPrazo = new JPanel();
		contentPaneModuloInvestimentoALongoPrazo.setBackground(new Color(128, 128, 128));
		contentPaneModuloInvestimentoALongoPrazo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloInvestimentoALongoPrazo);
		contentPaneModuloInvestimentoALongoPrazo.setLayout(null);
		
		btnCadastrarNovoInvestimento = new JButton("Cadastrar Novo Investimento");
		btnCadastrarNovoInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoInvestimento.setBounds(10, 344, 269, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnCadastrarNovoInvestimento);
		
		btnEditarInvestimento = new JButton("Editar Investimento");
		btnEditarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarInvestimento.setBounds(289, 344, 208, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnEditarInvestimento);
		
		btnExcluirInvestimento = new JButton("Excluir Investimento");
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Investimento", "Mensal", "Ocasional", "Total Anual"
			}
		));
	}
}
