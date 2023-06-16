package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class ModuloDeDespesas extends JFrame {

	private JPanel contentPaneModuloDeDespesas;
	private JButton btnCadastrarNovaCategoria;
	private JButton btnEditarCategoria;
	private JButton btnExcluirCategoria;
	private JButton btnCadastrarNovaDespesa;
	private JButton btnEditarDespesa;
	private JButton btnExcluirDespesa;

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
		
		btnCadastrarNovaCategoria = new JButton("Cadastrar Nova Categoria");
		btnCadastrarNovaCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovaCategoria.setBounds(102, 39, 578, 42);
		contentPaneModuloDeDespesas.add(btnCadastrarNovaCategoria);
		
		btnEditarCategoria = new JButton("Editar Categoria");
		btnEditarCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarCategoria.setBounds(102, 91, 578, 42);
		contentPaneModuloDeDespesas.add(btnEditarCategoria);
		
		btnExcluirCategoria = new JButton("Excluir Categoria");
		btnExcluirCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirCategoria.setBounds(102, 143, 578, 42);
		contentPaneModuloDeDespesas.add(btnExcluirCategoria);
		
		btnCadastrarNovaDespesa = new JButton("Cadastrar Nova Despesa");
		btnCadastrarNovaDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovaDespesa.setBounds(102, 195, 578, 42);
		contentPaneModuloDeDespesas.add(btnCadastrarNovaDespesa);
		
		btnEditarDespesa = new JButton("Editar Despesa");
		btnEditarDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarDespesa.setBounds(102, 247, 578, 42);
		contentPaneModuloDeDespesas.add(btnEditarDespesa);
		
		btnExcluirDespesa = new JButton("Excluir Despesa");
		btnExcluirDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirDespesa.setBounds(102, 299, 578, 42);
		contentPaneModuloDeDespesas.add(btnExcluirDespesa);
	}

}
