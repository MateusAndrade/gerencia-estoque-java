package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TelaPrincipalController;
import model.Funcionario;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;


public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Funcionario f = new Funcionario();
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaPrincipal frame = new TelaPrincipal(f);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	


	public TelaPrincipal(Funcionario f) {
		
		setResizable(false);
		setTitle("Sistema de mat\u00E9rias escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 28);
		contentPane.add(menuBar);
		
		JMenu mnFuncionario = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionario);
		
		JMenuItem mntmCadastrarFuncionrio = new JMenuItem("Cadastrar ");
		mnFuncionario.add(mntmCadastrarFuncionrio);
		
		JMenuItem mntmConsultarFuncionario = new JMenuItem("Consultar");
		mnFuncionario.add(mntmConsultarFuncionario);
		
		JMenu mnMateriais = new JMenu("Mat\u00E9riais");
		menuBar.add(mnMateriais);
		
		JMenuItem mntmAdicionarMateriais = new JMenuItem("Adicionar");
		mnMateriais.add(mntmAdicionarMateriais);
		
		JMenuItem mntmConsultarMateriais = new JMenuItem("Consultar ");
		mnMateriais.add(mntmConsultarMateriais);
		
		JMenu mnRequisies = new JMenu("Requisi\u00E7\u00F5es");
		menuBar.add(mnRequisies);
		
		JMenuItem mntmSolicitarRequisico = new JMenuItem("Solicitar requisi\u00E7\u00E3o");
		mnRequisies.add(mntmSolicitarRequisico);
		
		JMenuItem mntmConsultaRequisicao = new JMenuItem("Consulta Requisi\u00E7\u00E3o");
		mnRequisies.add(mntmConsultaRequisicao);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JMenuItem mnSobreInfo = new JMenuItem("Info");
		mnSobre.add(mnSobreInfo);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio: ");
		lblFuncionrio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFuncionrio.setBounds(33, 62, 139, 28);
		contentPane.add(lblFuncionrio);
		
		JPanel panelGerenciaFuncionario = new JPanel();
		panelGerenciaFuncionario.setBounds(100, 100, 130, 91);
		contentPane.add(panelGerenciaFuncionario);
		panelGerenciaFuncionario.setLayout(null);
		
		JLabel lblGerenciaFuncionario = new JLabel("<html>Gerenciamento <br> de Funcion\u00E1rio</html>");
		lblGerenciaFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGerenciaFuncionario.setBounds(0, 62, 132, 29);
		panelGerenciaFuncionario.add(lblGerenciaFuncionario);
		
		
		JLabel lblImg1 = new JLabel("");
		lblImg1.setIcon(new ImageIcon("C:\\Users\\Gui\\workspace\\ProjetoEstoque\\src\\img\\img_gerencia_funcionario_64x64.png"));
		lblImg1.setBounds(34, 0, 64, 64);
		panelGerenciaFuncionario.add(lblImg1);
		
		JLabel lblMatrias = new JLabel("Mat\u00E9rias:");
		lblMatrias.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMatrias.setBounds(33, 247, 112, 28);
		contentPane.add(lblMatrias);
		
		JPanel panelGerenciaMaterias = new JPanel();
		panelGerenciaMaterias.setBounds(100, 301, 130, 92);
		contentPane.add(panelGerenciaMaterias);
		panelGerenciaMaterias.setLayout(null);
		
		JLabel lblGerenciamentoDeMatrias = new JLabel("<html>Gerenciamento <br> de Mat\u00E9rias</html>");
		lblGerenciamentoDeMatrias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGerenciamentoDeMatrias.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciamentoDeMatrias.setBounds(10, 64, 110, 28);
		panelGerenciaMaterias.add(lblGerenciamentoDeMatrias);
		
		JLabel lblImg2 = new JLabel("");
		lblImg2.setIcon(new ImageIcon("C:\\Users\\Gui\\workspace\\ProjetoEstoque\\src\\img\\img_gerencia_materias_64x64.png"));
		lblImg2.setBounds(0, 0, 120, 64);
		panelGerenciaMaterias.add(lblImg2);
		
		JLabel lblRequisio = new JLabel("Requisi\u00E7\u00E3o:");
		lblRequisio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRequisio.setBounds(432, 65, 163, 23);
		contentPane.add(lblRequisio);
		
		JPanel panelGerenciaRequesicao = new JPanel();
		panelGerenciaRequesicao.setBounds(432, 100, 130, 92);
		contentPane.add(panelGerenciaRequesicao);
		panelGerenciaRequesicao.setLayout(null);
	
		
		JLabel lblRequisies = new JLabel("Requisi\u00E7\u00F5es");
		lblRequisies.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequisies.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRequisies.setBounds(10, 67, 110, 14);
		panelGerenciaRequesicao.add(lblRequisies);
		
		JLabel lblImg3 = new JLabel("");
		lblImg3.setIcon(new ImageIcon("C:\\Users\\Gui\\workspace\\ProjetoEstoque\\src\\img\\img_requesicao_64x64.png"));
		lblImg3.setBounds(33, 0, 64, 81);
		panelGerenciaRequesicao.add(lblImg3);
		
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBounds(10, 439, 543, 53);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Us\u00FAario:");
		lblUsuario.setBounds(99, 4, 177, 16);
		panelUsuario.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		/*
		 * Controler de tela
		 */
		
		TelaPrincipalController tpController = new TelaPrincipalController(mntmCadastrarFuncionrio, mntmConsultarFuncionario, mntmAdicionarMateriais, mntmConsultarMateriais, mntmSolicitarRequisico, mntmConsultaRequisicao, mnSobreInfo,f);
		
		mntmCadastrarFuncionrio.addActionListener(tpController);
		mntmConsultarFuncionario.addActionListener(tpController);
		mntmAdicionarMateriais.addActionListener(tpController);
		mntmConsultarMateriais.addActionListener(tpController);
		mntmSolicitarRequisico.addActionListener(tpController);
		mntmConsultaRequisicao.addActionListener(tpController);
		mnSobreInfo.addActionListener(tpController);
		
		tpController.telaFuncionario(panelGerenciaFuncionario);
		tpController.telaRequisicao(panelGerenciaRequesicao);
		tpController.telaMaterias(panelGerenciaMaterias);
		
		lblUsuario.setText(f.getNomeFuncionario());
		
		JLabel lblUsuario_1 = new JLabel("Usuario:");
		lblUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario_1.setBounds(33, 0, 80, 22);
		panelUsuario.add(lblUsuario_1);
		
		
	}
}
