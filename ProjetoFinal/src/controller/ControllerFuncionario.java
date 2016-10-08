package controller;


import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.IFuncionariosDao;
import view.TelaPrincipal;
import view.ViewLogin;

public class ControllerFuncionario {


	private IFuncionariosDao fDAO = new FuncionarioDao();
	private Funcionario f = new Funcionario();
	
	public ControllerFuncionario() {
	}

	public void cadastarFuncionario(Funcionario func) {

		try {
			fDAO.insereFuncionario(func);
			JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o Funcionário\n" + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void atualizarFuncionario(Funcionario func) {
		try {
			fDAO.atualizaFuncionario(func);
			JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o Funcionário\n" + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void verificaAcesso(ViewLogin viewLogin, JTextField txtLogin, JPasswordField txtSenha) {
		char[] chars = txtSenha.getPassword();
		String senha = String.valueOf(chars);

		try {
			this.f = fDAO.consultaFuncionarioCpf(txtLogin.getText());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Login incorreto", "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(f.getSenhaFuncionario() != null){
			if (f.getSenhaFuncionario().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login Realizado com Sucesso", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
				viewLogin.dispose();
				new TelaPrincipal(f).setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null, "Login incorreto", "ERRO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Login incorreto", "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public Funcionario getFuncionario(){
		return this.f;
	}

	public void excluirFuncionario(String cpfFuncionario) {
		Funcionario func = new Funcionario();
		func.setCpfFuncionario(cpfFuncionario);
		try {
			JOptionPane.showMessageDialog(null,"Funcionário Excluido com Sucesso.");
			fDAO.excluirFuncionario(func);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	

}
