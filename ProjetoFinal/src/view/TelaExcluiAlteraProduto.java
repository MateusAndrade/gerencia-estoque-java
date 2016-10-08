package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BotaoGerenciaController;
import controller.ProdutosTableClick;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaExcluiAlteraProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeAltera;
	private JTextField txtQtdeAltera;
	private JTextField txtCodigo;
	JTable t;
	DefaultTableModel tb;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaExcluiAlteraProduto frame = new TelaExcluiAlteraProduto();
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
	public TelaExcluiAlteraProduto() {
		setResizable(false);
		setTitle("Gerenciamento de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 427, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeAltera = new JTextField();
		txtNomeAltera.setColumns(10);
		txtNomeAltera.setBounds(73, 76, 225, 20);
		contentPane.add(txtNomeAltera);
		
		txtQtdeAltera = new JTextField();
		txtQtdeAltera.setColumns(10);
		txtQtdeAltera.setBounds(73, 115, 46, 20);
		contentPane.add(txtQtdeAltera);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 79, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 118, 60, 14);
		contentPane.add(lblQuantidade);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(102, 173, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(201, 173, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblGerenciamentoDeProdutos = new JLabel("GERENCIAMENTO DE PRODUTOS");
		lblGerenciamentoDeProdutos.setBounds(119, 11, 178, 14);
		contentPane.add(lblGerenciamentoDeProdutos);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(73, 45, 57, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setEnabled(false);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 48, 46, 14);
		contentPane.add(lblCdigo);
		
		BotaoGerenciaController bgController = new BotaoGerenciaController(txtNomeAltera, txtQtdeAltera, btnAlterar, btnExcluir,  txtCodigo, null);
		btnAlterar.addActionListener(bgController);
		btnExcluir.addActionListener(bgController);
				
	}
		

	public void passaDados(ProdutosTableClick produtosTableClick, String string, String string2, String string3) {
		txtCodigo.setText(string3);
		txtNomeAltera.setText(string);
		txtQtdeAltera.setText(string2);	
	}
}
