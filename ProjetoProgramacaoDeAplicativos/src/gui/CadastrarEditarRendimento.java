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
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import entities.Categoria;
import entities.Rendimento;
import enums.Frequencia;
import service.CategoriaService;
import service.RendimentoService;

public class CadastrarEditarRendimento extends JFrame {

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

	private MaskFormatter mascaraData;
	
	private String titulo;
	private CategoriaService categoriaService;
	private RendimentoService rendimentoService;
	private Rendimento rendimento;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblData;
	private JFormattedTextField formattedTextField;

	/**
	 * Create the frame.
	 */
	public CadastrarEditarRendimento(String titulo, Rendimento rendimento) {
		
		this.titulo = titulo;
		setTitle(titulo);
		
		this.rendimento = rendimento;
		
		this.criarMascaraData();
		this.initComponents();
		
		this.categoriaService = new CategoriaService();
		this.rendimentoService = new RendimentoService();
		
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
		lblCategoria.setForeground(new Color(255, 255, 255));
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategoria.setBounds(10, 12, 83, 25);
		contentPane.add(lblCategoria);
		
		cbCategorias = new JComboBox();
		cbCategorias.setBounds(103, 12, 198, 25);
		contentPane.add(cbCategorias);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 47, 83, 25);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setText(titulo.equals("Cadastrar Novo Rendimento") ? "" : rendimento.getNomeRendimento());
		textFieldNome.setBounds(103, 47, 198, 25);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		panelFrequencia = new JPanel();
		panelFrequencia.setBorder(new TitledBorder(null, "Frequ\u00EAncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFrequencia.setBounds(10, 82, 291, 57);
		contentPane.add(panelFrequencia);
		panelFrequencia.setLayout(null);
		
		rdbtnMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setBounds(45, 22, 103, 21);
		panelFrequencia.add(rdbtnMensal);
		
		rdbtnOcasional = new JRadioButton("Ocasional");
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setBounds(165, 22, 103, 21);
		panelFrequencia.add(rdbtnOcasional);
		
		if(!titulo.equals("Cadastrar Novo Rendimento?")) {
			this.selecionaBotao(); 
		}	
		
		lblValor = new JLabel("Valor:");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 149, 83, 25);
		contentPane.add(lblValor);
		
		textFieldValor = new JTextField();
		textFieldValor.setText(titulo.equals("Cadastrar Novo Rendimento") ? "0.00" : String.valueOf(rendimento.getValorRendimento()));
		textFieldValor.setBounds(103, 149, 198, 25);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		btnCadastrarEditar = new JButton("New button");
		btnCadastrarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarEditarActionPerformed();
			}
		});
		btnCadastrarEditar.setText(titulo.equals("Cadastrar Novo Rendimento") ? "Cadastrar" : "Editar");
		btnCadastrarEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarEditar.setBounds(165, 219, 136, 30);
		contentPane.add(btnCadastrarEditar);
		
		lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(10, 184, 83, 25);
		contentPane.add(lblData);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("yyyy-MM-dd").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
		formattedTextField = new JFormattedTextField(mascaraData);
		formattedTextField.setText(data + " " + hora);
		formattedTextField.setBounds(103, 184, 198, 25);
		contentPane.add(formattedTextField);
	}
	
	private void selecionaBotao() {
		if (rendimento.getFrequenciaRendimento() == Frequencia.Mensal) {
			rdbtnMensal.setSelected(true);
			rdbtnOcasional.setSelected(false);
		} else {
			rdbtnMensal.setSelected(false);
			rdbtnOcasional.setSelected(true);
		}
	}
	
	private void btnCadastrarEditarActionPerformed() {
		
		if( titulo.equals("Cadastrar Novo Rendimento")) {
			this.cadastrar();
		} else {
			this.editar();
		}
		
	}
	
	private void cadastrar() {
		
		Categoria categoriaSelecionada = (Categoria) cbCategorias.getSelectedItem();
		
		rendimento.setIdCategoriaRendimento(categoriaSelecionada.getIdCategoria());
		rendimento.setNomeRendimento(this.textFieldNome.getText());
		rendimento.setFrequenciaRendimento(verificarSelecaoRadioButtonFrequencia());
		rendimento.setValorRendimento(Double.parseDouble(textFieldValor.getText()));
		rendimento.setData(this.formattedTextField.getText());
		
		try {
			rendimentoService.cadastrar(rendimento);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar rendimento", "Cadastro de Rendimento", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar rendimento", "Cadastro de Rendimento", JOptionPane.ERROR_MESSAGE);
		} finally {	
			
			this.dispose();
			new TelaRendimentos().setVisible(true);
		}
		
	}
	
	private void editar() {
		
		Categoria categoriaSelecionada = (Categoria) cbCategorias.getSelectedItem();
		
		rendimento.setIdCategoriaRendimento(categoriaSelecionada.getIdCategoria());
		rendimento.setNomeRendimento(this.textFieldNome.getText());
		rendimento.setFrequenciaRendimento(verificarSelecaoRadioButtonFrequencia());
		rendimento.setValorRendimento(Double.parseDouble(textFieldValor.getText()));
		rendimento.setData(this.formattedTextField.getText());
		
		try {
			rendimentoService.atualizar(rendimento);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao editar rendimento", "Editar Rendimento", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao editar rendimento", "Editar Rendimento", JOptionPane.ERROR_MESSAGE);
		} finally {	
			
			this.dispose();
			new TelaRendimentos().setVisible(true);
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
