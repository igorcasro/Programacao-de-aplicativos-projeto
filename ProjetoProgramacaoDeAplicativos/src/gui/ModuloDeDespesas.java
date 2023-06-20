package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ModuloDeDespesas extends JFrame {

	private JPanel contentPaneModuloDeDespesas;
	private JButton btnCategorias;
	private JButton btnDespesas;
	private JLabel lblDespesas;

	/**
	 * Create the frame.
	 */
	public ModuloDeDespesas() {
		setTitle("Módulo de Despesas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloDeDespesas = new JPanel();
		contentPaneModuloDeDespesas.setBackground(new Color(128, 128, 128));
		contentPaneModuloDeDespesas.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloDeDespesas);
		contentPaneModuloDeDespesas.setLayout(null);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCategoriasActionPerformed();
			}
		});
		btnCategorias.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCategorias.setBounds(102, 143, 578, 42);
		contentPaneModuloDeDespesas.add(btnCategorias);
		
		btnDespesas = new JButton("Despesas");
		btnDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnDespesasActionPerformed();
			}
		});
		btnDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDespesas.setBounds(102, 195, 578, 42);
		contentPaneModuloDeDespesas.add(btnDespesas);
		
		lblDespesas = new JLabel("Despesas");
		lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespesas.setForeground(Color.WHITE);
		lblDespesas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblDespesas.setBounds(10, 10, 715, 42);
		contentPaneModuloDeDespesas.add(lblDespesas);
	}

	private void btnCategoriasActionPerformed() {
		
		new TelaCategorias().setVisible(true);
	}
	
	private void btnDespesasActionPerformed() {
		
		new TelaDespesas().setVisible(true);
	}
}
