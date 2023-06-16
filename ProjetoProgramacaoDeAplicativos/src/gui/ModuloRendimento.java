package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class ModuloRendimento extends JFrame {

	private JPanel contentPaneModuloRendimento;
	private JButton btnCadastrarNovaCategoria;
	private JButton btnEditarCategoria;
	private JButton btnExcluirCategoria;
	private JButton btnCadastrarNovoRendimento;
	private JButton btnEditarRendimentos;
	private JButton btnExclusaoDeRendimentos;

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
		
		btnCadastrarNovaCategoria = new JButton("Cadastrar Nova Categoria");
		btnCadastrarNovaCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovaCategoria.setBounds(102, 39, 578, 42);
		contentPaneModuloRendimento.add(btnCadastrarNovaCategoria);
		
		btnEditarCategoria = new JButton("Editar Categoria");
		btnEditarCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarCategoria.setBounds(102, 91, 578, 42);
		contentPaneModuloRendimento.add(btnEditarCategoria);
		
		btnExcluirCategoria = new JButton("Excluir Categoria");
		btnExcluirCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirCategoria.setBounds(102, 143, 578, 42);
		contentPaneModuloRendimento.add(btnExcluirCategoria);
		
		btnCadastrarNovoRendimento = new JButton("Cadastrar Novo Rendimento");
		btnCadastrarNovoRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoRendimento.setBounds(102, 195, 578, 42);
		contentPaneModuloRendimento.add(btnCadastrarNovoRendimento);
		
		btnEditarRendimentos = new JButton("Editar Rendimentos");
		btnEditarRendimentos.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarRendimentos.setBounds(102, 247, 578, 42);
		contentPaneModuloRendimento.add(btnEditarRendimentos);
		
		btnExclusaoDeRendimentos = new JButton("Exclusão de Rendimentos");
		btnExclusaoDeRendimentos.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExclusaoDeRendimentos.setBounds(102, 299, 578, 42);
		contentPaneModuloRendimento.add(btnExclusaoDeRendimentos);
	}

}
