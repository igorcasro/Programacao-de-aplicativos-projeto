package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import entities.ResumoMensal;
import enums.Meses;
import javax.swing.JFormattedTextField;

public class SelecionarAnoMesResumo extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cbMes;
	private JButton btnGerarResumo;
	private Meses mesSelecionado;
	private JLabel lblAno;


	private MaskFormatter mascaraAno;
	private JFormattedTextField formattedTextFieldAno;
	
	/**
	 * Create the frame.
	 */
	public SelecionarAnoMesResumo() {
		
		this.criarMascaraAno();
		this.initComponents();
	
		this.buscarMeses();
	}
	
	private void criarMascaraAno() {
		
		try {

			this.mascaraAno = new MaskFormatter("####");

		} catch (ParseException e) {

			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	private void buscarMeses() {

		List<Meses> meses = Arrays.asList(Meses.values());

		for (Meses mes : meses) {

			this.cbMes.addItem(mes);
		}
	}
	
	private void initComponents() {
		
		setTitle("Selecionar Ano e Mês");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Mês:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 45, 49, 25);
		contentPane.add(lblNewLabel);
		
		cbMes = new JComboBox();
		cbMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				mesSelecionado = (Meses) cbMes.getSelectedItem();
			}
		});
		cbMes.setBounds(69, 45, 357, 25);
		contentPane.add(cbMes);
		
		btnGerarResumo = new JButton("Gerar Resumo");
		btnGerarResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnGerarResumoActionPerformed();
			}
		});
		btnGerarResumo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerarResumo.setBounds(240, 80, 186, 30);
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
		
		ResumoMensal resumoMensal = new ResumoMensal();
		resumoMensal.setMes(mesSelecionado);
		resumoMensal.setAno(formattedTextFieldAno.getText());
		new VisualizarResumoMensal(resumoMensal).setVisible(true);
		
		this.dispose();
	}
}
