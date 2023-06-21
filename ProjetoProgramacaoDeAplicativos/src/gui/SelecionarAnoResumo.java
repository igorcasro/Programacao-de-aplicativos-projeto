package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import entities.ResumoAnual;
import enums.Meses;

public class SelecionarAnoResumo extends JFrame {

	private JPanel contentPane;
	private JButton btnGerarResumo;
	private Meses mesSelecionado;
	private JLabel lblAno;


	private MaskFormatter mascaraAno;
	private JFormattedTextField formattedTextFieldAno;

	/**
	 * Create the frame.
	 */
	public SelecionarAnoResumo() {
		
		this.criarMascaraAno();
		this.initComponents();
	}
	
	private void criarMascaraAno() {
		
		try {

			this.mascaraAno = new MaskFormatter("####");

		} catch (ParseException e) {

			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	private void initComponents() {
		
		setTitle("Selecionar Ano");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnGerarResumo = new JButton("Gerar Resumo");
		btnGerarResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnGerarResumoActionPerformed();
			}
		});
		btnGerarResumo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerarResumo.setBounds(240, 45, 186, 30);
		contentPane.add(btnGerarResumo);
		
		lblAno = new JLabel("Ano:");
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAno.setBounds(10, 10, 49, 25);
		contentPane.add(lblAno);
		
		formattedTextFieldAno = new JFormattedTextField(mascaraAno);
		formattedTextFieldAno.setBounds(69, 10, 357, 25);
		contentPane.add(formattedTextFieldAno);
	}
	
	private void btnGerarResumoActionPerformed() {
		
		ResumoAnual resumoAnual = new ResumoAnual();
		resumoAnual.setAno(formattedTextFieldAno.getText());
		new VisualizarResumoAnual(resumoAnual).setVisible(true);
		
		this.dispose();
	}

}
