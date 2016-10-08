package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerFuncionario;
import controller.FuncionariosTableController;
import model.Funcionario;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.JButton;


public class ViewCadastraFuncionario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7101337311919085059L;
	private JPanel contentPane;
	private JTextField txtNomeFuncionario;
	private JTextField txtRGFuncionario;
	private JTextField txtCPFFuncionario;
	private JTextField txtTelefoneFuncionario;
	private JTextField txtEmailFuncionario;
	private JTextField txtNivelAcesso;
	private JTextField txtSenha;
	private JTextField txtConfirmaSenha;
	@SuppressWarnings("unused")
	private JButton btnSalvarFuncionario;
	private JButton btnExcluirFuncionario;
	private JButton btnCancelar;
	public int acaoUpdate=1;
	private String cpfVelho = "";
	private DefaultTableModel model;
	private JTable tabelFuncionarios;
	
	private FuncionariosTableController funcTableControl = new FuncionariosTableController(model); 

	private ControllerFuncionario controlFunc = new ControllerFuncionario();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run( ) {
				try {
					ViewCadastraFuncionario frame = new ViewCadastraFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewCadastraFuncionario() {

		setResizable(false);
		setTitle("Cadastro de Funcion\u00E1rio:");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelCamposPessoais = new JPanel();
		panelCamposPessoais.setBackground(Color.LIGHT_GRAY);
		panelCamposPessoais.setForeground(Color.GRAY);
		panelCamposPessoais.setBounds(10, 11, 525, 136);
		contentPane.add(panelCamposPessoais);
		panelCamposPessoais.setLayout(null);

		JLabel lblNomeFuncionario = new JLabel("Nome Funcion\u00E1rio:");
		lblNomeFuncionario.setBounds(10, 40, 175, 14);
		panelCamposPessoais.add(lblNomeFuncionario);

		JLabel lblDadosCadastrais = new JLabel("Dados Pessoais:");
		lblDadosCadastrais.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadosCadastrais.setBounds(10, 0, 156, 29);
		panelCamposPessoais.add(lblDadosCadastrais);

		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setBounds(126, 37, 389, 20);
		panelCamposPessoais.add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);

		JLabel lblRg = new JLabel("RG Funcion\u00E1rio:");
		lblRg.setBounds(10, 71, 106, 14);
		panelCamposPessoais.add(lblRg);

		txtRGFuncionario = new JTextField(5);
		txtRGFuncionario.setBounds(126, 68, 149, 20);
		panelCamposPessoais.add(txtRGFuncionario);
		txtRGFuncionario.setColumns(10);

		JLabel lblCpfFuncionrio = new JLabel("CPF Funcion\u00E1rio:");
		lblCpfFuncionrio.setBounds(285, 71, 114, 14);
		panelCamposPessoais.add(lblCpfFuncionrio);

		txtCPFFuncionario = new JTextField();
		txtCPFFuncionario.setBounds(383, 68, 132, 20);
		panelCamposPessoais.add(txtCPFFuncionario);
		txtCPFFuncionario.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone Funcion\u00E1rio:");
		lblTelefone.setBounds(10, 102, 156, 14);
		panelCamposPessoais.add(lblTelefone);

		txtTelefoneFuncionario = new JTextField();
		txtTelefoneFuncionario.setBounds(126, 99, 149, 20);
		panelCamposPessoais.add(txtTelefoneFuncionario);
		txtTelefoneFuncionario.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(285, 102, 46, 14);
		panelCamposPessoais.add(lblEmail);

		txtEmailFuncionario = new JTextField();
		txtEmailFuncionario.setBounds(341, 99, 174, 20);
		panelCamposPessoais.add(txtEmailFuncionario);
		txtEmailFuncionario.setColumns(10);

		JPanel panelDadosGerenciais = new JPanel();
		panelDadosGerenciais.setBackground(Color.LIGHT_GRAY);
		panelDadosGerenciais.setBounds(10, 158, 525, 154);
		contentPane.add(panelDadosGerenciais);
		panelDadosGerenciais.setLayout(null);

		JLabel lblDadosGerenciais = new JLabel("Dados Gerenciais:");
		lblDadosGerenciais.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadosGerenciais.setBounds(10, 0, 156, 29);
		panelDadosGerenciais.add(lblDadosGerenciais);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 29, 46, 14);
		panelDadosGerenciais.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(10, 54, 216, 20);
		panelDadosGerenciais.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblConfirmaoSenha = new JLabel("Confirma\u00E7\u00E3o Senha:");
		lblConfirmaoSenha.setBounds(10, 85, 128, 14);
		panelDadosGerenciais.add(lblConfirmaoSenha);

		txtConfirmaSenha = new JTextField();
		txtConfirmaSenha.setBounds(10, 110, 216, 20);
		panelDadosGerenciais.add(txtConfirmaSenha);
		txtConfirmaSenha.setColumns(10);

		JPanel panelNivelAcesso = new JPanel();
		panelNivelAcesso.setBounds(264, 11, 251, 132);
		panelDadosGerenciais.add(panelNivelAcesso);
		panelNivelAcesso.setLayout(null);

		JLabel lblNvelDeAcesso = new JLabel("N\u00EDvel de Acesso:");
		lblNvelDeAcesso.setBounds(86, 5, 176, 14);
		panelNivelAcesso.add(lblNvelDeAcesso);

		txtNivelAcesso = new JTextField();
		txtNivelAcesso.setBounds(10, 45, 231, 20);
		panelNivelAcesso.add(txtNivelAcesso);
		txtNivelAcesso.setColumns(10);
		
		JLabel lblExcluir = new JLabel("Excluir Funcion\u00E1rio");
		lblExcluir.setBounds(75, 76, 135, 14);
		panelNivelAcesso.add(lblExcluir);
		
		JButton btnExcluirFuncionario = new JButton("Excluir");
		btnExcluirFuncionario.setBounds(78, 101, 89, 23);
		panelNivelAcesso.add(btnExcluirFuncionario);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(10, 323, 522, 119);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnSalvarFuncionario = new JButton("Salvar");
		btnSalvarFuncionario.setBounds(0, 5, 246, 103);
		panelBotoes.add(btnSalvarFuncionario);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(265, 5, 257, 103);
		panelBotoes.add(btnCancelar);
		setLocationRelativeTo(null);
		
		btnSalvarFuncionario.addActionListener( this );
		
		btnExcluirFuncionario.addActionListener( this );

		btnCancelar.addActionListener( this );
		
	}

	public Funcionario formToFuncionario() {
		Funcionario func = new Funcionario();
		func.setNomeFuncionario(txtNomeFuncionario.getText());
		func.setRgFuncionario(txtRGFuncionario.getText());
		func.setCpfFuncionario(txtCPFFuncionario.getText());
		func.setTelefoneFuncionario(txtTelefoneFuncionario.getText());
		func.setEmailFuncionario(txtEmailFuncionario.getText());
		func.setSenhaFuncionario(txtSenha.getText());
		func.setNivelAcesso(Integer.parseInt(txtNivelAcesso.getText()));
		return func;
	}

	public void funcionarioToForm(Funcionario func, int acao, JTable tblFuncionarios) {
		txtNomeFuncionario.setText(func.getNomeFuncionario());
		txtRGFuncionario.setText(func.getRgFuncionario());
		txtCPFFuncionario.setText(func.getCpfFuncionario());
		txtSenha.setText(func.getSenhaFuncionario());
		txtConfirmaSenha.setText(func.getSenhaFuncionario());
		txtEmailFuncionario.setText(func.getEmailFuncionario());
		txtNivelAcesso.setText(String.valueOf(func.getNivelAcesso()));
		txtTelefoneFuncionario.setText(func.getTelefoneFuncionario());
		acaoUpdate = acao;	
		tabelFuncionarios = tblFuncionarios;
		
		if( acao == 2){
			txtCPFFuncionario.setEnabled(false);
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();

		if ("Salvar".equals(cmd) && acaoUpdate == 1) {
			controlFunc.cadastarFuncionario(formToFuncionario());
			this.dispose();
			//new ViewPrincipalFuncionario().setVisible(true);
		} else if ("Cancelar".equals(cmd)) {
			this.dispose();
			//new ViewPrincipalFuncionario().setVisible(true);
		}
		
		if("Salvar".equals(cmd) && acaoUpdate == 2){
			controlFunc.atualizarFuncionario(formToFuncionario());
			this.dispose();
			//new ViewPrincipalFuncionario().setVisible(true);
		} else if ("Cancelar".equals(cmd)) {
			this.dispose();
			new ViewPrincipalFuncionario().setVisible(true);
		}
		
		if("Excluir".equals(cmd)){
			controlFunc.excluirFuncionario(txtCPFFuncionario.getText());
			this.dispose();
			//new ViewPrincipalFuncionario().setVisible(true);
		}
	}
}
