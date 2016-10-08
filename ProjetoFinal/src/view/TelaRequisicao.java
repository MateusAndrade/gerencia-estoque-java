package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSpinner;

import controller.PadraoTableModel;
import controller.RequisicaoController;
import model.Funcionario;
import model.Produtos;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class TelaRequisicao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFuncionario;
	private JTextField tfDataEmissao;
	private JTable tableMateriais;
	private JTextField tfCodigoRequisicao;
	
	private static Funcionario funcionario = new Funcionario();
	
	 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaRequisicao frame = new TelaRequisicao(funcionario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaRequisicao(Funcionario f) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Requisica\u00E7\u00E3o de material");
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnRequisicao = new JRadioButton("Nova Requisi\u00E7\u00E3o");
		rdbtnRequisicao.setBounds(192, 26, 109, 23);
		contentPane.add(rdbtnRequisicao);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnRequisicao);

		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFuncionrio.setBounds(57, 111, 93, 23);
		contentPane.add(lblFuncionrio);

		tfFuncionario = new JTextField();
		tfFuncionario.setEditable(false);
		tfFuncionario.setBounds(177, 113, 400, 20);
		contentPane.add(tfFuncionario);
		tfFuncionario.setColumns(10);

		JLabel lblData = new JLabel("Data de emiss\u00E3o:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblData.setBounds(57, 145, 120, 23);
		contentPane.add(lblData);

		tfDataEmissao = new JTextField();
		tfDataEmissao.setEditable(false);
		tfDataEmissao.setBounds(177, 147, 109, 20);
		contentPane.add(tfDataEmissao);
		tfDataEmissao.setColumns(10);

		JLabel lblItens = new JLabel("Mat\u00E9rias para requisica\u00E7\u00E3o:");
		lblItens.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItens.setBounds(57, 193, 195, 23);
		contentPane.add(lblItens);

		JComboBox<Produtos> comboBoxMaterial = new JComboBox<Produtos>();
		comboBoxMaterial.setBounds(57, 248, 457, 20);
		contentPane.add(comboBoxMaterial);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 285, 524, 180);
		contentPane.add(scrollPane);

		tableMateriais = new JTable();
		scrollPane.setViewportView(tableMateriais);

		Object[][] dados = new Object[][] {};
		String[] cabecalho = new String[3];
		cabecalho[0] = "Código";
		cabecalho[1] = "Nome do Produto";
		cabecalho[2] = "Quantidade";

		DefaultTableModel model = new PadraoTableModel(dados, cabecalho);
		tableMateriais.setModel(model);

		tableMateriais.getColumnModel().getColumn(1).setPreferredWidth(467);
		tableMateriais.getColumnModel().getColumn(2).setPreferredWidth(86);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(587, 247, 89, 23);
		contentPane.add(btnIncluir);

		JSpinner spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setBounds(524, 248, 45, 20);
		contentPane.add(spinnerQuantidade);

		JLabel lblMaterial_1 = new JLabel("Material");
		lblMaterial_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaterial_1.setBounds(59, 227, 57, 18);
		contentPane.add(lblMaterial_1);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(212, 476, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(344, 476, 89, 23);
		contentPane.add(btnCancelar);

		JSeparator separator = new JSeparator();
		separator.setBounds(57, 179, 606, 2);
		contentPane.add(separator);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(509, 231, 57, 14);
		contentPane.add(lblQuantidade);

		JLabel lblDadosDoRegistro = new JLabel("Dados do registro:");
		lblDadosDoRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDadosDoRegistro.setBounds(57, 40, 195, 23);
		contentPane.add(lblDadosDoRegistro);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(587, 281, 89, 23);
		contentPane.add(btnRemover);

		tfCodigoRequisicao = new JTextField();
		tfCodigoRequisicao.setEditable(false);
		tfCodigoRequisicao.setBounds(177, 74, 86, 20);
		contentPane.add(tfCodigoRequisicao);
		tfCodigoRequisicao.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(57, 74, 59, 18);
		contentPane.add(lblCodigo);



		TelaRequisicao tela = this;
		RequisicaoController requisicaoController = new RequisicaoController(tfCodigoRequisicao, tfFuncionario,
				tfDataEmissao, comboBoxMaterial, tableMateriais, spinnerQuantidade, btnSalvar, btnCancelar, btnIncluir,
				btnRemover, f, model, tela);
		rdbtnRequisicao.addActionListener(requisicaoController);

		btnSalvar.addActionListener(requisicaoController);
		btnCancelar.addActionListener(requisicaoController);
		
	}

}
