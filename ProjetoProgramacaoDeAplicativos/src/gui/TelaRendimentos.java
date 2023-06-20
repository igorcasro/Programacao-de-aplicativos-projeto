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

public class TelaRendimentos extends JFrame {

	private JPanel contentPane;
	private JTable tableRendimentos;
	private JButton btnCadastrarNovoRendimento;
	private JButton btnEditarRendimento;
	private JButton btnExcluirRendimento;
	private JLabel lblRendimentos;
	private JPanel panelRendimentos;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public TelaRendimentos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCadastrarNovoRendimento = new JButton("Cadastrar Novo Rendimento");
		btnCadastrarNovoRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoRendimento.setBounds(10, 344, 313, 42);
		contentPane.add(btnCadastrarNovoRendimento);
		
		btnEditarRendimento = new JButton("Editar Rendimento");
		btnEditarRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarRendimento.setBounds(333, 344, 191, 42);
		contentPane.add(btnEditarRendimento);
		
		btnExcluirRendimento = new JButton("Excluir Rendimento");
		btnExcluirRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirRendimento.setBounds(534, 344, 191, 42);
		contentPane.add(btnExcluirRendimento);
		
		lblRendimentos = new JLabel("Rendimentos");
		lblRendimentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRendimentos.setForeground(Color.WHITE);
		lblRendimentos.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRendimentos.setBounds(10, 10, 715, 42);
		contentPane.add(lblRendimentos);
		
		panelRendimentos = new JPanel();
		panelRendimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rendimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRendimentos.setBounds(10, 62, 715, 272);
		contentPane.add(panelRendimentos);
		panelRendimentos.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelRendimentos.add(scrollPane);
		
		tableRendimentos = new JTable();
		scrollPane.setViewportView(tableRendimentos);
		tableRendimentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Rendimento", "Mensal", "Ocasional", "Total Ano"
			}
		));
	}

}
