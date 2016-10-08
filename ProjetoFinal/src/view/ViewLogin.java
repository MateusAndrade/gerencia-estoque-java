package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerFuncionario;
import controller.TelaPrincipalController;
import model.Funcionario;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 8836095427615686793L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	
	private ControllerFuncionario controlFunc = new ControllerFuncionario();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ViewLogin frame = new ViewLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLogin() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 216, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCamposLogin = new JPanel();
		panelCamposLogin.setBounds(10, 11, 184, 249);
		contentPane.add(panelCamposLogin);
		panelCamposLogin.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(10, 79, 164, 20);
		panelCamposLogin.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 54, 46, 14);
		panelCamposLogin.add(lblLogin);
		
		JLabel lblAcessoAoSistema = new JLabel("Acesso ao Sistema");
		lblAcessoAoSistema.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcessoAoSistema.setBounds(10, 0, 164, 32);
		panelCamposLogin.add(lblAcessoAoSistema);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 135, 164, 20);
		panelCamposLogin.add(txtSenha);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 110, 46, 14);
		panelCamposLogin.add(lblSenha);
		
		JButton btnLogar = new JButton("Logar");
		
		btnLogar.addActionListener( this );
		
		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogar.setBounds(10, 181, 164, 32);
		panelCamposLogin.add(btnLogar);
		setLocationRelativeTo(null);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		String cmd = e.getActionCommand();
		
		if("Logar".equals(cmd))
		{	

			controlFunc.verificaAcesso(this,txtLogin,txtSenha);
			
		}
		
	}
}
