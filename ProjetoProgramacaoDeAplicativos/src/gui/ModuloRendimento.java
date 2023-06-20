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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloRendimento extends JFrame {

	private JPanel contentPaneModuloRendimento;
	private JButton btnCategorias;
	private JButton btnCadastrarNovoRendimento;
	private JLabel lblRendimento;

	/**
	 * Create the frame.
	 */
	public ModuloRendimento() {
		setTitle("Módulo Rendimento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloRendimento = new JPanel();
		contentPaneModuloRendimento.setBackground(new Color(128, 128, 128));
		contentPaneModuloRendimento.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloRendimento);
		contentPaneModuloRendimento.setLayout(null);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCategoriasActionPerformed();
			}
		});
		btnCategorias.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCategorias.setBounds(102, 143, 578, 42);
		contentPaneModuloRendimento.add(btnCategorias);
		
		btnCadastrarNovoRendimento = new JButton("Rendimentos");
		btnCadastrarNovoRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarNovoRendimentoActionPerformed();
			}
		});
		btnCadastrarNovoRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoRendimento.setBounds(102, 195, 578, 42);
		contentPaneModuloRendimento.add(btnCadastrarNovoRendimento);
		
		lblRendimento = new JLabel("Rendimento");
		lblRendimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRendimento.setForeground(Color.WHITE);
		lblRendimento.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRendimento.setBounds(10, 10, 715, 42);
		contentPaneModuloRendimento.add(lblRendimento);
	}

	private void btnCategoriasActionPerformed() {
		
		new TelaCategorias().setVisible(true);
	}
	
	private void btnCadastrarNovoRendimentoActionPerformed() {
		
		new TelaRendimentos().setVisible(true);
	}
	
}
