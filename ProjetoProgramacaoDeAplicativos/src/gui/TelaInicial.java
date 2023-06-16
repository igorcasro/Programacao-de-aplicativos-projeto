package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPaneTelaInicial;
	private JButton btnModuloDeRendimento;
	private JButton btnModuloDeDespesas;
	private JButton btnModuloInvestimentoALongoPrazo;
	private JButton btnModuloFundoDeDespesasOcasionais;
	private JButton btnModuloResumo;
	private JButton btnModuloRelatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		
		this.initComponents();
		
	}
	
	private void initComponents() {
		
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPaneTelaInicial = new JPanel();
		contentPaneTelaInicial.setBackground(new Color(128, 128, 128));
		contentPaneTelaInicial.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneTelaInicial);
		contentPaneTelaInicial.setLayout(null);
		
		btnModuloDeRendimento = new JButton("Módulo de Rendimento");
		btnModuloDeRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnModuloDeRendimentoActionPerformed();
			}
		});
		btnModuloDeRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModuloDeRendimento.setBounds(102, 39, 578, 42);
		contentPaneTelaInicial.add(btnModuloDeRendimento);
		
		btnModuloDeDespesas = new JButton("Módulo de Despesas");
		btnModuloDeDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnModuloDeDespesasActionPerformed();
			}
		});
		btnModuloDeDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModuloDeDespesas.setBounds(102, 91, 578, 42);
		contentPaneTelaInicial.add(btnModuloDeDespesas);
		
		btnModuloInvestimentoALongoPrazo = new JButton("Módulo Investimento a Longo Prazo");
		btnModuloInvestimentoALongoPrazo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnModuloInvestimentoALongoPrazoActionPerformed();
			}
		});
		btnModuloInvestimentoALongoPrazo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModuloInvestimentoALongoPrazo.setBounds(102, 143, 578, 42);
		contentPaneTelaInicial.add(btnModuloInvestimentoALongoPrazo);
		
		btnModuloFundoDeDespesasOcasionais = new JButton("Módulo Fundo de Despesas Ocasionais");
		btnModuloFundoDeDespesasOcasionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnModuloFundoDeDespesasOcasionaisActionPerformed();
			}
		});
		btnModuloFundoDeDespesasOcasionais.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModuloFundoDeDespesasOcasionais.setBounds(102, 195, 578, 42);
		contentPaneTelaInicial.add(btnModuloFundoDeDespesasOcasionais);
		
		btnModuloResumo = new JButton("Módulo Resumo");
		btnModuloResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnModuloResumoActionPerformed();
			}
		});
		btnModuloResumo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModuloResumo.setBounds(102, 247, 578, 42);
		contentPaneTelaInicial.add(btnModuloResumo);
		
		btnModuloRelatorio = new JButton("Módulo Relatório");
		btnModuloRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnModuloRelatorioActionPerformed();
			}
		});
		btnModuloRelatorio.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModuloRelatorio.setBounds(102, 299, 578, 42);
		contentPaneTelaInicial.add(btnModuloRelatorio);
	}
	
	private void btnModuloDeRendimentoActionPerformed() {
		
		new ModuloRendimento().setVisible(true);
	}
	
	private void btnModuloDeDespesasActionPerformed() {
		
		new ModuloDeDespesas().setVisible(true);
	}
	
	private void btnModuloInvestimentoALongoPrazoActionPerformed() {
		
		new ModuloInvestimentoALongoPrazo().setVisible(true);
	}
	
	private void btnModuloFundoDeDespesasOcasionaisActionPerformed() {
		
		new ModuloFundoDeDespesasOcasionais().setVisible(true);
	}
	
	private void btnModuloResumoActionPerformed() {
		
		new ModuloResumo().setVisible(true);
	}
	
	private void btnModuloRelatorioActionPerformed() {
		
		new ModuloRelatorio().setVisible(true);
	}
}
