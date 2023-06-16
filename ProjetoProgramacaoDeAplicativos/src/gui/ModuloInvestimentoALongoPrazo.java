package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class ModuloInvestimentoALongoPrazo extends JFrame {

	private JPanel contentPaneModuloInvestimentoALongoPrazo;
	private JButton btnCadastrarNovoInvestimento;
	private JButton btnEditarInvestimento;
	private JButton btnExcluirInvestimento;

	/**
	 * Create the frame.
	 */
	public ModuloInvestimentoALongoPrazo() {
		setTitle("Módulo Investimento a Longo Prazo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneModuloInvestimentoALongoPrazo = new JPanel();
		contentPaneModuloInvestimentoALongoPrazo.setBackground(new Color(128, 128, 128));
		contentPaneModuloInvestimentoALongoPrazo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneModuloInvestimentoALongoPrazo);
		contentPaneModuloInvestimentoALongoPrazo.setLayout(null);
		
		btnCadastrarNovoInvestimento = new JButton("Cadastrar Novo Investimento");
		btnCadastrarNovoInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoInvestimento.setBounds(102, 91, 578, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnCadastrarNovoInvestimento);
		
		btnEditarInvestimento = new JButton("Editar Investimento");
		btnEditarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarInvestimento.setBounds(102, 143, 578, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnEditarInvestimento);
		
		btnExcluirInvestimento = new JButton("Excluir Investimento");
		btnExcluirInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirInvestimento.setBounds(102, 195, 578, 42);
		contentPaneModuloInvestimentoALongoPrazo.add(btnExcluirInvestimento);
	}

}
