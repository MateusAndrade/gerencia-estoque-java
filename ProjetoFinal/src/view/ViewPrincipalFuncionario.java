package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerFuncionario;
import controller.FuncionariosTableClick;
import controller.FuncionariosTableController;
import controller.PadraoTableModel;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewPrincipalFuncionario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblFuncionarios;
	private JTextField btnCadastrar;
	private ControllerFuncionario controlFuncionario = new ControllerFuncionario();
	private FuncionariosTableController funcTableControl = new FuncionariosTableController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipalFuncionario frame = new ViewPrincipalFuncionario();
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
	public ViewPrincipalFuncionario() {
		setTitle("Gerenciamento de Funcion\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[][] dados = new Object[][]{};
		String[] cabecalho = new String[3];		
		cabecalho[0] = "Nome";
		cabecalho[1] = "Email";
		cabecalho[2] = "CPF";
		
		DefaultTableModel modelTabela = new PadraoTableModel(dados, cabecalho);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 36, 576, 365);
		contentPane.add(scrollPane);
		
		tblFuncionarios = new JTable();
		scrollPane.setViewportView(tblFuncionarios);
		tblFuncionarios.setModel(modelTabela);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(270,415,99,23);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(this);
		
		FuncionariosTableController tmController = new FuncionariosTableController(modelTabela);
		
		try {
			tmController.preencheTabela();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MouseListener evento = new FuncionariosTableClick(tblFuncionarios, modelTabela);

		tblFuncionarios.addMouseListener(evento);

	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if("Cadastrar".equals(cmd))
		{
			new ViewCadastraFuncionario().setVisible(true);
			this.dispose();
		}

		
	}
	
	
}
