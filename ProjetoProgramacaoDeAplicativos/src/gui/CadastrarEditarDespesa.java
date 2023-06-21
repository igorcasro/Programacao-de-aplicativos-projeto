package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import entities.Categoria;
import entities.Despesa;
import enums.Frequencia;
import service.CategoriaService;
import service.DespesaService;
import service.RendimentoService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarEditarDespesa extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JLabel lblCategoria;
	private JComboBox cbCategorias;
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
	private CategoriaService categoriaService;
	private DespesaService despesaService;
	private Despesa despesa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Create the frame.
	 */
	public CadastrarEditarDespesa(String titulo, Despesa despesa) {
		this.titulo = titulo;
		setTitle(titulo);
		
		this.despesa = despesa;
		
		this.criarMascaraData();
		this.initComponents();
		
		this.categoriaService = new CategoriaService();
		this.despesaService = new DespesaService();
		
		this.buscarCategorias();
	}
	
	private void criarMascaraData() {

		try {

			this.mascaraData = new MaskFormatter("####-##-## ##:##:##");

		} catch (ParseException e) {

			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	private void buscarCategorias() {

		List<Categoria> categorias;
		try {
			categorias = this.categoriaService.buscarTodos();
		
			for (Categoria categoria : categorias) {

				this.cbCategorias.addItem(categoria);
			}
			
			JOptionPane.showMessageDialog(null, "Sucesso ao buscar categorias", "Busca de Categorias", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao buscar categorias", "Busca de Categorias", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 295);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategoria.setBounds(10, 10, 83, 25);
		contentPane.add(lblCategoria);
		
		cbCategorias = new JComboBox();
		cbCategorias.setBounds(103, 10, 198, 25);
		contentPane.add(cbCategorias);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 45, 83, 25);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setText(titulo.equals("Cadastrar Nova Despesa") ? "" : despesa.getNomeDespesa());
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(103, 45, 198, 25);
		contentPane.add(textFieldNome);
		
		panelFrequencia = new JPanel();
		panelFrequencia.setLayout(null);
		panelFrequencia.setBorder(new TitledBorder(null, "Frequ\u00EAncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFrequencia.setBounds(10, 80, 291, 57);
		contentPane.add(panelFrequencia);
		
		rdbtnMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setBounds(45, 22, 103, 21);
		panelFrequencia.add(rdbtnMensal);
		
		rdbtnOcasional = new JRadioButton("Ocasional");
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setBounds(165, 22, 103, 21);
		panelFrequencia.add(rdbtnOcasional);
		
		if(!titulo.equals("Cadastrar Nova Despesa")) {
			this.selecionaBotao(); 
		}	
		
		lblValor = new JLabel("Valor:");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 147, 83, 25);
		contentPane.add(lblValor);
		
		textFieldValor = new JTextField();
		textFieldValor.setText(titulo.equals("Cadastrar Nova Despesa") ? "0.00" : String.valueOf(despesa.getValorDespesa()));
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(103, 147, 198, 25);
		contentPane.add(textFieldValor);
		
		btnCadastrarEditar = new JButton("Editar");
		btnCadastrarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarEditarActionPerformed();
			}
		});
		btnCadastrarEditar.setText(titulo.equals("Cadastrar Nova Despesa") ? "Cadastrar" : "Editar");
		btnCadastrarEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarEditar.setBounds(165, 217, 136, 30);
		contentPane.add(btnCadastrarEditar);
		
		lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(10, 182, 83, 25);
		contentPane.add(lblData);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("yyyy-MM-dd").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
		formattedTextField = new JFormattedTextField(mascaraData);
		formattedTextField.setText(data + " " + hora);
		formattedTextField.setBounds(103, 182, 198, 25);
		contentPane.add(formattedTextField);
	}

	private void selecionaBotao() {
		if (despesa.getFrequenciaDespesa() == Frequencia.Mensal) {
			rdbtnMensal.setSelected(true);
			rdbtnOcasional.setSelected(false);
		} else {
			rdbtnMensal.setSelected(false);
			rdbtnOcasional.setSelected(true);
		}
	}
	
	private void btnCadastrarEditarActionPerformed() {
		
		if( titulo.equals("Cadastrar Nova Despesa")) {
			this.cadastrar();
		} else {
			this.editar();
		}	
	}
	
	private void cadastrar() {
		
		Categoria categoriaSelecionada = (Categoria) cbCategorias.getSelectedItem();
		
		despesa.setIdCategoriaDespesa(categoriaSelecionada.getIdCategoria());
		despesa.setNomeDespesa(this.textFieldNome.getText());
		despesa.setFrequenciaDespesa(verificarSelecaoRadioButtonFrequencia());
		despesa.setValorDespesa(Double.parseDouble(textFieldValor.getText()));
		despesa.setData(this.formattedTextField.getText());
		
		try {
			despesaService.cadastrar(despesa);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar despesa", "Cadastro de Despesa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar despesa", "Cadastro de Despesa", JOptionPane.ERROR_MESSAGE);
		} finally {	
			
			this.dispose();
			new TelaDespesas().setVisible(true);
		}
		
	}
	
	private void editar() {
		
		Categoria categoriaSelecionada = (Categoria) cbCategorias.getSelectedItem();
		
		despesa.setIdCategoriaDespesa(categoriaSelecionada.getIdCategoria());
		despesa.setNomeDespesa(this.textFieldNome.getText());
		despesa.setFrequenciaDespesa(verificarSelecaoRadioButtonFrequencia());
		despesa.setValorDespesa(Double.parseDouble(textFieldValor.getText()));
		despesa.setData(this.formattedTextField.getText());
		
		try {
			despesaService.atualizar(despesa);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao editar despesa", "Editar Despesa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao editar despesa", "Editar Despesa", JOptionPane.ERROR_MESSAGE);
		} finally {	
			
			this.dispose();
			new TelaDespesas().setVisible(true);
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
