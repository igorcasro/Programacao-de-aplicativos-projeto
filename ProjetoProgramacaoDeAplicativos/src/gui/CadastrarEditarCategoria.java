package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.Categoria;
import service.CategoriaService;

public class CadastrarEditarCategoria extends JFrame {

	private JPanel contentPane;
	private String titulo;
	private JTextField textFieldNome;

	private CategoriaService categoriaService;
	private Categoria categoria;

	/**
	 * Create the frame.
	 */
	public CadastrarEditarCategoria(String titulo, Categoria categoria) {
		this.titulo = titulo;
		setTitle(titulo);
		
		this.categoria = categoria;
				
		this.initComponents();	
		
		this.categoriaService = new CategoriaService();
		
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 136);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 61, 25);
		contentPane.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setText(titulo.equals("Cadastrar Categoria") ? "" : categoria.getNomeCategoria());
		textFieldNome.setBounds(81, 10, 349, 25);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		JButton btnCadastrarEditar = new JButton("New button");
		btnCadastrarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarEditarActionPerformed();
			}
		});
		btnCadastrarEditar.setText(titulo.equals("Cadastrar Categoria") ? "Cadastrar" : "Editar");		
		btnCadastrarEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarEditar.setBounds(298, 45, 132, 30);
		contentPane.add(btnCadastrarEditar);
	}
	
	private void btnCadastrarEditarActionPerformed() {
		
		if( titulo.equals("Cadastrar Categoria")) {
			this.cadastrar();
		} else {
			this.editar();
		}
	}
	
	private void cadastrar() {
		
		categoria.setNomeCategoria(textFieldNome.getText());
		
		try {
			categoriaService.cadastrar(categoria);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar categoria", "Cadastro de Categoria", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar categoria", "Cadastro de Categoria", JOptionPane.ERROR_MESSAGE);
		} finally {
			
			this.dispose();
			new TelaCategorias().setVisible(true);
		}
		
	}
	
	private void editar() {
		
		categoria.setNomeCategoria(textFieldNome.getText());
		
		try {
			categoriaService.atualizar(categoria);
			
			JOptionPane.showMessageDialog(null, "Sucesso ao editar categoria", "Editar Categoria", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao editar categoria", "Editar Categoria", JOptionPane.ERROR_MESSAGE);
		} finally {
			
			this.dispose();
			new TelaCategorias().setVisible(true);
		}
		
	}
}
