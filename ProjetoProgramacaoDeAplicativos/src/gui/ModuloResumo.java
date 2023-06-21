package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloResumo extends JFrame {

	private JPanel contentPaneModuloResumo;
	private JButton btnResumoMensal;
	private JButton btnResumoAnual;

	/**
	 * Create the frame.
	 */
	public ModuloResumo() {
		setTitle("Módulo Resumo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloResumo = new JPanel();
		contentPaneModuloResumo.setBackground(new Color(128, 128, 128));
		contentPaneModuloResumo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloResumo);
		contentPaneModuloResumo.setLayout(null);
		
		btnResumoMensal = new JButton("Resumo Mensal");
		btnResumoMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnResumoMensalActionPerformed();
			}
		});
		btnResumoMensal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnResumoMensal.setBounds(102, 139, 578, 42);
		contentPaneModuloResumo.add(btnResumoMensal);
		
		btnResumoAnual = new JButton("Resumo Anual");
		btnResumoAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnResumoAnualActionPerformed();
			}
		});
		btnResumoAnual.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnResumoAnual.setBounds(102, 191, 578, 42);
		contentPaneModuloResumo.add(btnResumoAnual);
	}

	private void btnResumoMensalActionPerformed() {
		
		new SelecionarAnoMesResumo().setVisible(true);
	}
	
	private void btnResumoAnualActionPerformed() {
		
		new SelecionarAnoResumo().setVisible(true);
	}
}
