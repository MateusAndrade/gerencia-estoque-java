package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.BotaoProdutosController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNome;
	public JTextField txtQtde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaCadastroProdutos frame = new TelaCadastroProdutos();
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
	public TelaCadastroProdutos() {
		setResizable(false);
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("CADASTRO DE PRODUTOS");
		lblCadastroDeProdutos.setBounds(130, 11, 129, 14);
		contentPane.add(lblCadastroDeProdutos);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 53, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(73, 50, 225, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 92, 65, 14);
		contentPane.add(lblQuantidade);
		
		txtQtde = new JTextField();
		txtQtde.setBounds(73, 89, 46, 20);
		contentPane.add(txtQtde);
		txtQtde.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(110, 151, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(209, 151, 89, 23);
		contentPane.add(btnLimpar);
		
		BotaoProdutosController botaoController = new BotaoProdutosController(txtNome, txtQtde, btnLimpar);
		btnCadastrar.addActionListener(botaoController);
		btnLimpar.addActionListener(botaoController);
		
	}
}
