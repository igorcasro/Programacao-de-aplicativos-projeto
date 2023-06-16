package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class ModuloFundoDeDespesasOcasionais extends JFrame {

	private JPanel contentPaneModuloFundoDeDespesasOcasionais;
	private JButton btnCadastrarNovoFundo;
	private JButton btnEditarFundo;
	private JButton btnExcluirFundo;

	/**
	 * Create the frame.
	 */
	public ModuloFundoDeDespesasOcasionais() {
		setTitle("Módulo Fundo de Despesas Ocasionais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloFundoDeDespesasOcasionais = new JPanel();
		contentPaneModuloFundoDeDespesasOcasionais.setBackground(new Color(128, 128, 128));
		contentPaneModuloFundoDeDespesasOcasionais.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloFundoDeDespesasOcasionais);
		contentPaneModuloFundoDeDespesasOcasionais.setLayout(null);
		
		btnCadastrarNovoFundo = new JButton("Cadastrar Novo Fundo");
		btnCadastrarNovoFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoFundo.setBounds(102, 91, 578, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnCadastrarNovoFundo);
		
		btnEditarFundo = new JButton("Editar Fundo");
		btnEditarFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarFundo.setBounds(102, 143, 578, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnEditarFundo);
		
		btnExcluirFundo = new JButton("Excluir Fundo");
		btnExcluirFundo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirFundo.setBounds(102, 195, 578, 42);
		contentPaneModuloFundoDeDespesasOcasionais.add(btnExcluirFundo);
	}
}
