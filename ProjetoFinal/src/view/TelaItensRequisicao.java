package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.PadraoTableModel;
import model.ItensRequisicao;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class TelaItensRequisicao extends JFrame {

	private static final long serialVersionUID = -395628635269589410L;
	private JPanel contentPane;
	private JTable table = new JTable();
	private JTextField txtFuncionario = new JTextField();
	private JTextField txtRequisicao = new JTextField();
	private JTextField txtData;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaItensRequisicao frame = new TelaItensRequisicao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaItensRequisicao() {
		setTitle("Itens da Requisicao");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 130, 648, 311);
		contentPane.add(scrollPane);
		
		Object[][] dados = new Object[][]{};
		String[] cabecalho = new String[3];
		cabecalho[0] = "Código";
		cabecalho[1] = "Nome do Produto";
		cabecalho[2] = "Quantidade solicitada";
		model = new PadraoTableModel(dados, cabecalho);
		
		
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		JLabel lblRequisicao = new JLabel("Requisi\u00E7\u00E3o");
		lblRequisicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequisicao.setBounds(27, 24, 79, 31);
		contentPane.add(lblRequisicao);
		
		txtFuncionario.setEditable(false);
		txtFuncionario.setBounds(106, 70, 360, 20);
		contentPane.add(txtFuncionario);
		txtFuncionario.setColumns(10);
		
		txtRequisicao.setEditable(false);
		txtRequisicao.setBounds(106, 31, 94, 20);
		contentPane.add(txtRequisicao);
		txtRequisicao.setColumns(10);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionrio.setBounds(27, 70, 79, 17);
		contentPane.add(lblFuncionrio);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(239, 29, 66, 21);
		contentPane.add(lblNewLabel);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(290, 31, 101, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		

	}
	
	public void carregaDados(String codigoRequisicao, String funcionario, String data, List<ItensRequisicao> itensRequisicao ){
		txtFuncionario.setText(funcionario);
		txtRequisicao.setText(codigoRequisicao);
		txtData.setText(data);
		
		
		for (ItensRequisicao itensRequisicao2 : itensRequisicao) {
			Object[] vetor = new Object[3];
			vetor[0] = itensRequisicao2.getProduto().getCodigoProduto();
			vetor[1] = itensRequisicao2.getProduto().getNomeProduto();
			vetor[2] = itensRequisicao2.getQuantidadeSolicitado();
			 model.addRow(vetor);
		}

		
		
		
	}
	
	
}
