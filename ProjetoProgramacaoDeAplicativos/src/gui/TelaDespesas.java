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
import entities.Despesa;
import enums.Frequencia;
import service.CategoriaService;
import service.DespesaService;

public class TelaDespesas extends JFrame {

	private JPanel contentPane;
	private JTable tableDespesas;
	private JButton btnCadastrarNovaDespesa;
	private JButton btnEditarDespesa;
	private JButton btnExcluirDespesa;
	private JLabel lblDespesas;
	private JPanel panelDespesas;
	private JScrollPane scrollPane;

	private DespesaService despesaService;
	private CategoriaService categoriaService;
	
	/**
	 * Create the frame.
	 */
	public TelaDespesas() {
		
		this.initComponents();
		
		this.despesaService = new DespesaService();
		this.categoriaService = new CategoriaService();
	
		this.buscarDespesas();
	}
	
	private void buscarDespesas() {
		
		try {
			DefaultTableModel modelo = (DefaultTableModel) tableDespesas.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
			
			List<Despesa> despesas;
			despesas = this.despesaService.buscarTodos();
		
			for (Despesa despesa: despesas) {

				Categoria categoria = new Categoria();
				categoria = categoriaService.buscarPorId(despesa.getIdCategoriaDespesa());
				
				modelo.addRow(new Object[] {despesa.getIdDespesa(), categoria.getNomeCategoria(), despesa.getNomeDespesa(),
						despesa.getFrequenciaDespesa().equals(Frequencia.Mensal) ? despesa.getValorDespesa() : "",
						despesa.getFrequenciaDespesa().equals(Frequencia.Ocasional) ? despesa.getValorDespesa() : "",
						despesa.getFrequenciaDespesa().equals(Frequencia.Mensal) ? despesa.getValorDespesa() * 12 : despesa.getValorDespesa()});
			}
			JOptionPane.showMessageDialog(null, "Sucesso ao buscar despesas", "Busca de Despesas", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao buscar despesas", "Busca de Despesas", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void initComponents() {
		setTitle("Despesas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCadastrarNovaDespesa = new JButton("Cadastrar Nova Despesa");
		btnCadastrarNovaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCadastrarNovaDespesaActionPerformed();
			}
		});
		btnCadastrarNovaDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarNovaDespesa.setBounds(10, 344, 246, 42);
		contentPane.add(btnCadastrarNovaDespesa);
		
		btnEditarDespesa = new JButton("Editar Despesa");
		btnEditarDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnEditarDespesaActionPerformed();
			}
		});
		btnEditarDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditarDespesa.setBounds(266, 344, 229, 42);
		contentPane.add(btnEditarDespesa);
		
		btnExcluirDespesa = new JButton("Excluir Despesa");
		btnExcluirDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Object[] options = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if(opcao == 0) {
					btnExcluirDespesaActionPerformed();
				}
				
				
			}
		});
		btnExcluirDespesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirDespesa.setBounds(505, 344, 220, 42);
		contentPane.add(btnExcluirDespesa);
		
		lblDespesas = new JLabel("Despesas");
		lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespesas.setForeground(Color.WHITE);
		lblDespesas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblDespesas.setBounds(10, 10, 715, 42);
		contentPane.add(lblDespesas);
		
		panelDespesas = new JPanel();
		panelDespesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Despesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDespesas.setBounds(10, 62, 715, 272);
		contentPane.add(panelDespesas);
		panelDespesas.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 695, 240);
		panelDespesas.add(scrollPane);
		
		tableDespesas = new JTable();
		scrollPane.setViewportView(tableDespesas);
		tableDespesas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Despesa", "Categoria", "Despesa", "Mensal", "Ocasional", "Total Anual"
			}
		));
	}
	
	private void btnCadastrarNovaDespesaActionPerformed() {
		
		try {
			List<Categoria> categorias;
			categorias = this.categoriaService.buscarTodos();
				
			if(categorias.size() != 0) {
				
				Despesa despesa = new Despesa();
				
				new CadastrarEditarDespesa("Cadastrar Nova Despesa", despesa).setVisible(true);;
				this.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "É necessário que tenham categorias cadastradas", "Cadastro de Despesa", JOptionPane.ERROR_MESSAGE);
				this.dispose();
			}
		} catch(SQLException | IOException e ) {
			
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar despesa", "Cadastro de Despesa", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void btnEditarDespesaActionPerformed() {
		
		Despesa despesa = new Despesa();
		int linhaSelecionada = tableDespesas.getSelectedRow();
		
		try {
			despesa = despesaService.buscarPorId(Integer.parseInt(tableDespesas.getValueAt(linhaSelecionada, 0).toString()));
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao buscar despesa", "Busca de Despesas", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			this.dispose();
		}
		
		new CadastrarEditarDespesa("Editar Despesa", despesa).setVisible(true);
		this.dispose();
		
	}
	
	private void btnExcluirDespesaActionPerformed() {
		
		try {
			
			Despesa despesa = new Despesa();
			int linhaSelecionada = tableDespesas.getSelectedRow();
			
			try {
				despesa = despesaService.buscarPorId(Integer.parseInt(tableDespesas.getValueAt(linhaSelecionada, 0).toString()));
			} catch (NumberFormatException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao buscar despesa", "Busca de Despesa", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				this.dispose();
			}
			
			despesaService.excluir(despesa);
			
			JOptionPane.showMessageDialog(null, "Exclusão concluída com sucesso", "Exclusão de Despesa", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new TelaDespesas().setVisible(true);
			
		} catch (SQLException | IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir despesa", "Exclusão de Despesa", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
