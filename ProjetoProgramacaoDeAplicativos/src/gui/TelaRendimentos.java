package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Categoria;
import entities.Rendimento;
import enums.Frequencia;
import service.CategoriaService;
import service.RendimentoService;

public class TelaRendimentos extends JFrame {

	private JPanel contentPane;
	private JTable tableRendimentos;
	private JButton btnCadastrarNovoRendimento;
	private JButton btnEditarRendimento;
	private JButton btnExcluirRendimento;
	private JLabel lblRendimentos;
	private JPanel panelRendimentos;
	private JScrollPane scrollPane;

	private RendimentoService rendimentoService;
	private CategoriaService categoriaService;
	
	/**
	 * Create the frame.
	 */
	public TelaRendimentos() {
		
		this.initComponents();
		
		this.rendimentoService = new RendimentoService();
		this.categoriaService = new CategoriaService();
	
		this.buscarRendimentos();
	}
	
	private void buscarRendimentos() {
		
		try {
			DefaultTableModel modelo = (DefaultTableModel) tableRendimentos.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
			
			List<Rendimento> rendimentos;
			rendimentos = this.rendimentoService.buscarTodos();
		
			for (Rendimento rendimento: rendimentos) {

				Categoria categoria = new Categoria();
				categoria = categoriaService.buscarPorId(rendimento.getIdCategoriaRendimento());
				
				modelo.addRow(new Object[] {rendimento.getIdRendimento(), categoria.getNomeCategoria(), rendimento.getNomeRendimento(),
						rendimento.getFrequenciaRendimento().equals(Frequencia.Mensal) ? rendimento.getValorRendimento() : "",
						rendimento.getFrequenciaRendimento().equals(Frequencia.Ocasional) ? rendimento.getValorRendimento() : "",
						rendimento.getFrequenciaRendimento().equals(Frequencia.Mensal) ? rendimento.getValorRendimento() * 12 : rendimento.getValorRendimento()});
			}
			JOptionPane.showMessageDialog(null, "Sucesso ao buscar rendimentos", "Busca de Rendimentos", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao buscar rendimentos", "Busca de Rendimentos", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void initComponents() {		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCadastrarNovoRendimento = new JButton("Cadastrar Novo Rendimento");
		btnCadastrarNovoRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarNovoRendimentoActionPerformed();
			}
		});
		btnCadastrarNovoRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovoRendimento.setBounds(10, 344, 313, 42);
		contentPane.add(btnCadastrarNovoRendimento);
		
		btnEditarRendimento = new JButton("Editar Rendimento");
		btnEditarRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnEditarCategoriaActionPerformed();
			}
		});
		btnEditarRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarRendimento.setBounds(333, 344, 191, 42);
		contentPane.add(btnEditarRendimento);
		
		btnExcluirRendimento = new JButton("Excluir Rendimento");
		btnExcluirRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Object[] options = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if(opcao == 0) {
					btnExcluirRendimentoActionPerformed();
				}
				
			}
		});
		btnExcluirRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirRendimento.setBounds(534, 344, 191, 42);
		contentPane.add(btnExcluirRendimento);
		
		lblRendimentos = new JLabel("Rendimentos");
		lblRendimentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRendimentos.setForeground(Color.WHITE);
		lblRendimentos.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRendimentos.setBounds(10, 10, 715, 42);
		contentPane.add(lblRendimentos);
		
		panelRendimentos = new JPanel();
		panelRendimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rendimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRendimentos.setBounds(10, 62, 715, 272);
		contentPane.add(panelRendimentos);
		panelRendimentos.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelRendimentos.add(scrollPane);
		
		tableRendimentos = new JTable();
		scrollPane.setViewportView(tableRendimentos);
		tableRendimentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Rendimento", "Categoria", "Rendimento", "Mensal", "Ocasional", "Total Ano"
			}
		));
	}

	private void btnCadastrarNovoRendimentoActionPerformed() {
		
		try {
			List<Categoria> categorias;
			categorias = this.categoriaService.buscarTodos();
				
			if(categorias.size() != 0) {
				
				Rendimento rendimento = new Rendimento();
				
				new CadastrarEditarRendimento("Cadastrar Novo Rendimento", rendimento).setVisible(true);;
				this.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "É necessário que tenham categorias cadastradas", "Cadastro de Rendimento", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}
		} catch(SQLException | IOException e ) {
			
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar rendimento", "Cadastro de Rendimento", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	private void btnEditarCategoriaActionPerformed() {
		
		Rendimento rendimento = new Rendimento();
		int linhaSelecionada = tableRendimentos.getSelectedRow();
		
		try {
			rendimento = rendimentoService.buscarPorId(Integer.parseInt(tableRendimentos.getValueAt(linhaSelecionada, 0).toString()));
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao buscar rendimento", "Busca de Rendimento", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			this.dispose();
		}
		
		System.out.println(rendimento);
		
		new CadastrarEditarRendimento("Editar Rendimento", rendimento).setVisible(true);
		this.dispose();
	}
	
	private void btnExcluirRendimentoActionPerformed() {
		
		try {
			
			Rendimento rendimento = new Rendimento();
			int linhaSelecionada = tableRendimentos.getSelectedRow();
			
			try {
				rendimento = rendimentoService.buscarPorId(Integer.parseInt(tableRendimentos.getValueAt(linhaSelecionada, 0).toString()));
			} catch (NumberFormatException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao buscar rendimento", "Busca de Rendimento", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				this.dispose();
			}
			
			rendimentoService.excluir(rendimento);
			
			JOptionPane.showMessageDialog(null, "Exclusão concluída com sucesso", "Exclusão de Rendimento", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new TelaRendimentos().setVisible(true);
			
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir rendimento", "Exclusão de Rendimento", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
