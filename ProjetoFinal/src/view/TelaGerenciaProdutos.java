package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.PadraoTableModel;
import controller.ProdutosTableClick;
import controller.ProdutosTableController;
import controller.RadioGerenciaProdutosController;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TelaGerenciaProdutos extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblProdutos;
	private JTextField txtPesquisa;
	private JButton btnAdicionarProdutos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaGerenciaProdutos frame = new TelaGerenciaProdutos();
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
	public TelaGerenciaProdutos() {
		setResizable(false);
		setTitle("Gerenciamento de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 68, 638, 376);
		contentPane.add(scrollPane);
		
		tblProdutos = new JTable();
		scrollPane.setViewportView(tblProdutos);
		Object[][] dados = new Object[][]{};
		String[] cabecalho = new String[3];
		cabecalho[0] = "Código";
		cabecalho[1] = "Nome do Produto";
		cabecalho[2] = "Quantidade";
		DefaultTableModel model = new PadraoTableModel(dados, cabecalho);
		tblProdutos.setModel(model);
		
		ProdutosTableController ptController = new ProdutosTableController(model);
		try{
			ptController.preencheTable();			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		MouseListener evento = new ProdutosTableClick(tblProdutos, model);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(60, 8, 489, 20);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JLabel lblPesquisarPor = new JLabel("Pesquisar Por:");
		lblPesquisarPor.setBounds(10, 40, 69, 14);
		contentPane.add(lblPesquisarPor);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome do Produto");
		rdbtnNome.setSelected(true);
		rdbtnNome.setBounds(85, 35, 109, 23);
		contentPane.add(rdbtnNome);
		
		JRadioButton rdbtnCodigo = new JRadioButton("C\u00F3digo");
		rdbtnCodigo.setBounds(216, 35, 59, 23);
		contentPane.add(rdbtnCodigo);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rdbtnCodigo);
		grupo1.add(rdbtnNome);
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
		lblPesquisa.setBounds(10, 11, 57, 14);
		contentPane.add(lblPesquisa);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(559, 7, 89, 23);
		contentPane.add(btnPesquisar);
		tblProdutos.addMouseListener(evento);
		
		RadioGerenciaProdutosController rgProdCont = new RadioGerenciaProdutosController(rdbtnNome, rdbtnCodigo, btnPesquisar, txtPesquisa, tblProdutos);
		
	
		btnAdicionarProdutos = new JButton("Adicionar produtos");
		btnAdicionarProdutos.setBounds(240, 455, 146, 23);
		contentPane.add(btnAdicionarProdutos);
		rdbtnNome.addActionListener(rgProdCont);
		rdbtnCodigo.addActionListener(rgProdCont);
		btnPesquisar.addActionListener(rgProdCont);
		btnAdicionarProdutos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionarProdutos){
			new TelaCadastroProdutos().setVisible(true);
		}
		
	}
}
