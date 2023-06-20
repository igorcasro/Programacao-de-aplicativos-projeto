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
import service.CategoriaService;

public class TelaCategorias extends JFrame {

	private JPanel contentPane;
	private JTable tableCategorias;
	private JButton btnCadastrarNovaCategoria;
	private JButton btnEditarCategoria;
	private JButton btnExcluirCategoria;
	private JLabel lblCategorias;
	private JPanel panelCategorias;
	private JScrollPane scrollPane;
	
	private CategoriaService categoriaService;
	
	/**
	 * Create the frame.
	 */
	public TelaCategorias() {
		
		this.initComponents();
		
		this.categoriaService = new CategoriaService();
		
		this.buscarCategorias();
	}
	
	private void buscarCategorias() {
		
		try {
			DefaultTableModel modelo = (DefaultTableModel) tableCategorias.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
			
			List<Categoria> categorias;
			categorias = this.categoriaService.buscarTodos();
		
			for (Categoria categoria : categorias) {

				modelo.addRow(new Object[] { categoria.getIdCategoria(), categoria.getNomeCategoria()});
			}
			JOptionPane.showMessageDialog(null, "Sucesso ao buscar categorias", "Busca de Categorias", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao buscar categorias", "Busca de Categorias", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		
	}
	
	private void initComponents() {	
		
		setTitle("Categorias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCadastrarNovaCategoria = new JButton("Cadastrar Nova Categoria");
		btnCadastrarNovaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarNovaCategoriaActionPerformed();
			}
		});
		btnCadastrarNovaCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovaCategoria.setBounds(10, 344, 246, 42);
		contentPane.add(btnCadastrarNovaCategoria);
		
		btnEditarCategoria = new JButton("Editar Categoria");
		btnEditarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnEditarCategoriaActionPerformed();
			}
		});
		btnEditarCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarCategoria.setBounds(266, 344, 229, 42);
		contentPane.add(btnEditarCategoria);
		
		btnExcluirCategoria = new JButton("Excluir Categoria");
		btnExcluirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Object[] options = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if(opcao == 0) {
					btnExcluirCategoriaActionPerformed();
				}
			}
		});
		btnExcluirCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirCategoria.setBounds(505, 344, 220, 42);
		contentPane.add(btnExcluirCategoria);
		
		lblCategorias = new JLabel("Categorias");
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorias.setForeground(Color.WHITE);
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCategorias.setBounds(10, 10, 715, 42);
		contentPane.add(lblCategorias);
		
		panelCategorias = new JPanel();
		panelCategorias.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categorias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCategorias.setBounds(10, 62, 715, 272);
		contentPane.add(panelCategorias);
		panelCategorias.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelCategorias.add(scrollPane);
		
		tableCategorias = new JTable();
		scrollPane.setViewportView(tableCategorias);
		tableCategorias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Categoria", "Nome Categoria"
			}
		));
		
		tableCategorias.getColumnModel().getColumn(0).setPreferredWidth(95);
		tableCategorias.getColumnModel().getColumn(1).setPreferredWidth(600);
	}
	
	private void btnCadastrarNovaCategoriaActionPerformed() {
		
		Categoria categoria = new Categoria();
		
		new CadastrarEditarCategoria("Cadastrar Categoria", categoria).setVisible(true);
		this.dispose();
	}
	
	private void btnEditarCategoriaActionPerformed() {
		
		Categoria categoria = new Categoria();
		int linhaSelecionada = tableCategorias.getSelectedRow();
		categoria.setIdCategoria((int) tableCategorias.getValueAt(linhaSelecionada, 0));
		categoria.setNomeCategoria(tableCategorias.getValueAt(linhaSelecionada, 1).toString());
		
		new CadastrarEditarCategoria("Editar Categoria", categoria).setVisible(true);
		this.dispose();
	}
	
	private void btnExcluirCategoriaActionPerformed() {
		
		try {
			
			Categoria categoria = new Categoria();
			int linhaSelecionada = tableCategorias.getSelectedRow();
			categoria.setIdCategoria((int) tableCategorias.getValueAt(linhaSelecionada, 0));
			categoria.setNomeCategoria(tableCategorias.getValueAt(linhaSelecionada, 1).toString());
			
			categoriaService.excluir(categoria);
			
			JOptionPane.showMessageDialog(null, "Exclusão concluída com sucesso", "Exclusão de categoria", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new TelaCategorias().setVisible(true);
			
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir categoria", "Exclusão de categoria", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
