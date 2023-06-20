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

public class TelaDespesas extends JFrame {

	private JPanel contentPane;
	private JTable tblDespesas;
	private JButton btnCadastrarNovaDespesa;
	private JButton btnEditarDespesa;
	private JButton btnExcluirDespesa;
	private JLabel lblDespesas;
	private JPanel panelDespesas;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public TelaDespesas() {
		setTitle("Despesas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCadastrarNovaDespesa = new JButton("Cadastrar Nova Despesa");
		btnCadastrarNovaDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovaDespesa.setBounds(10, 344, 246, 42);
		contentPane.add(btnCadastrarNovaDespesa);
		
		btnEditarDespesa = new JButton("Editar Despesa");
		btnEditarDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarDespesa.setBounds(266, 344, 229, 42);
		contentPane.add(btnEditarDespesa);
		
		btnExcluirDespesa = new JButton("Excluir Despesa");
		btnExcluirDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirDespesa.setBounds(505, 344, 220, 42);
		contentPane.add(btnExcluirDespesa);
		
		lblDespesas = new JLabel("Despesas");
		lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespesas.setForeground(Color.WHITE);
		lblDespesas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblDespesas.setBounds(10, 10, 715, 42);
		contentPane.add(lblDespesas);
		
		panelDespesas = new JPanel();
		panelDespesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Despesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDespesas.setBounds(10, 62, 715, 272);
		contentPane.add(panelDespesas);
		panelDespesas.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelDespesas.add(scrollPane);
		
		tblDespesas = new JTable();
		scrollPane.setViewportView(tblDespesas);
		tblDespesas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Despesa", "Mensal", "Ocasional", "Total Anual"
			}
		));
	}
}
