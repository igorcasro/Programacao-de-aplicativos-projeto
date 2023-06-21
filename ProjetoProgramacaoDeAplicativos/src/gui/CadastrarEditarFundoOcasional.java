package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import entities.FundoOcasional;
import enums.Frequencia;
import service.FundoOcasionalService;

public class CadastrarEditarFundoOcasional extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JLabel lblNome;
	private JPanel panelFrequencia;
	private JRadioButton rdbtnMensal;
	private JRadioButton rdbtnOcasional;
	private JLabel lblValor;
	private JButton btnCadastrarEditar;
	private JLabel lblData;
	private JFormattedTextField formattedTextField;

	private MaskFormatter mascaraData;
	
	private String titulo;
	private FundoOcasionalService fundoOcasionalService;
	private FundoOcasional fundoOcasional;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public CadastrarEditarFundoOcasional(String titulo, FundoOcasional fundoOcasional) {
		this.titulo = titulo;
		setTitle(titulo);
		
		this.fundoOcasional = fundoOcasional;
		
		this.criarMascaraData();
		this.initComponents();
		
		this.fundoOcasionalService = new FundoOcasionalService();		
	}
	
	private void criarMascaraData() {

		try {

			this.mascaraData = new MaskFormatter("####-##-## ##:##:##");

		} catch (ParseException e) {

			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 260);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 10, 83, 25);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setText(titulo.equals("Cadastrar Novo Fundo Ocasional") ? "" : fundoOcasional.getNomeFundoOcasional());
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(103, 13, 198, 25);
		contentPane.add(textFieldNome);
		
		panelFrequencia = new JPanel();
		panelFrequencia.setLayout(null);
		panelFrequencia.setBorder(new TitledBorder(null, "Frequ\u00EAncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFrequencia.setBounds(10, 45, 291, 57);
		contentPane.add(panelFrequencia);
		
		rdbtnMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setBounds(45, 22, 103, 21);
		panelFrequencia.add(rdbtnMensal);
		
		rdbtnOcasional = new JRadioButton("Ocasional");
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setBounds(165, 22, 103, 21);
		panelFrequencia.add(rdbtnOcasional);
		
		if(!titulo.equals("Cadastrar Novo Investimento")) {
			this.selecionaBotao(); 
		}	
		
		lblValor = new JLabel("Valor:");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 112, 83, 25);
		contentPane.add(lblValor);
		
		textFieldValor = new JTextField();
		textFieldValor.setText(titulo.equals("Cadastrar Novo Fundo Ocasional") ? "0.00" : String.valueOf(fundoOcasional.getValorFundoOcasional()));
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(103, 112, 198, 25);
		contentPane.add(textFieldValor);
		
		btnCadastrarEditar = new JButton("Editar");
		btnCadastrarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarEditarActionPerformed();
			}
		});
		btnCadastrarEditar.setText(titulo.equals("Cadastrar Novo Fundo Ocasional") ? "Cadastrar" : "Editar");
		btnCadastrarEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarEditar.setBounds(165, 185, 136, 30);
		contentPane.add(btnCadastrarEditar);
		
		lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(10, 147, 83, 25);
		contentPane.add(lblData);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("yyyy-MM-dd").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
		formattedTextField = new JFormattedTextField(mascaraData);
		formattedTextField.setText(data + " " + hora);
		formattedTextField.setBounds(103, 150, 198, 25);
		contentPane.add(formattedTextField);
	}

	private void selecionaBotao() {
		if (fundoOcasional.getFrequenciaFundoOcasional() == Frequencia.Mensal) {
			rdbtnMensal.setSelected(true);
			rdbtnOcasional.setSelected(false);
		} else {
			rdbtnMensal.setSelected(false);
			rdbtnOcasional.setSelected(true);
		}
	}
	
	private void btnCadastrarEditarActionPerformed() {
		
		if(titulo.equals("Cadastrar Novo Fundo Ocasional")) {
			this.cadastrar();
		} else {
			this.editar();
		}	
	}
	
	private void cadastrar() {
		
		fundoOcasional.setNomeFundoOcasional(this.textFieldNome.getText());
		fundoOcasional.setFrequenciaFundoOcasional(verificarSelecaoRadioButtonFrequencia());
		fundoOcasional.setValorFundoOcasional(Double.parseDouble(textFieldValor.getText()));
		fundoOcasional.setData(this.formattedTextField.getText());
		
		try {
			fundoOcasionalService.cadastrar(fundoOcasional);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar fundo ocasional", "Cadastro de Fundo Ocasional", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar fundo ocasional", "Cadastro de Fundo Ocasional", JOptionPane.ERROR_MESSAGE);
		} finally {	
			
			this.dispose();
			new ModuloFundoDeDespesasOcasionais().setVisible(true);
		}
		
	}
	
	private void editar() {
			
		fundoOcasional.setNomeFundoOcasional(this.textFieldNome.getText());
		fundoOcasional.setFrequenciaFundoOcasional(verificarSelecaoRadioButtonFrequencia());
		fundoOcasional.setValorFundoOcasional(Double.parseDouble(textFieldValor.getText()));
		fundoOcasional.setData(this.formattedTextField.getText());
		
		try {
			fundoOcasionalService.atualizar(fundoOcasional);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao editar fundo ocasional", "Editar Fundo Ocasional", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao editar fundo ocasional", "Editar Fundo Ocasional", JOptionPane.ERROR_MESSAGE);
		} finally {	
			
			this.dispose();
			new ModuloFundoDeDespesasOcasionais().setVisible(true);
		}
	}
	
	private Frequencia verificarSelecaoRadioButtonFrequencia() {
		
		if (this.rdbtnMensal.isSelected()) {
			return Frequencia.Mensal;
		} else {
			return Frequencia.Ocasional;
		}
	}
}
