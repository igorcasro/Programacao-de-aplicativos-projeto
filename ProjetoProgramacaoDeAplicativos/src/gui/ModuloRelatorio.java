package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class ModuloRelatorio extends JFrame {

	private JPanel contentPaneModuloRelatorio;
	private JButton btnRelatorioAnual;
	private JButton btnRelatorioMensal;
	private JButton btnOrganizacao;
	
	/**
	 * Create the frame.
	 */
	public ModuloRelatorio() {
		setTitle("Módulo Relatório");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloRelatorio = new JPanel();
		contentPaneModuloRelatorio.setBackground(new Color(128, 128, 128));
		contentPaneModuloRelatorio.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloRelatorio);
		contentPaneModuloRelatorio.setLayout(null);
		
		btnRelatorioAnual = new JButton("Relatório Anual");
		btnRelatorioAnual.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRelatorioAnual.setBounds(102, 91, 578, 42);
		contentPaneModuloRelatorio.add(btnRelatorioAnual);
		
		btnRelatorioMensal = new JButton("Relatório Mensal");
		btnRelatorioMensal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRelatorioMensal.setBounds(102, 143, 578, 42);
		contentPaneModuloRelatorio.add(btnRelatorioMensal);
		
		btnOrganizacao = new JButton("Organização");
		btnOrganizacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOrganizacao.setBounds(102, 195, 578, 42);
		contentPaneModuloRelatorio.add(btnOrganizacao);
	}

}
