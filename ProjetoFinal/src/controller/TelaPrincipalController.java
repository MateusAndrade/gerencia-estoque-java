package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Funcionario;
import view.TelaCadastroProdutos;
import view.TelaGerenciaProdutos;
import view.TelaGerenciaRequisicao;
import view.TelaRequisicao;
import view.ViewCadastraFuncionario;
import view.ViewPrincipalFuncionario;

public class TelaPrincipalController implements ActionListener {

	private JMenuItem cadastrarFuncionario;
	private JMenuItem consultarFuncionario;
	private JMenuItem adicionarMateriais;
	private JMenuItem consultarMateriais;
	private JMenuItem solicitaRequisicao;
	private JMenuItem consultaRequisicao;
	private JMenuItem sobre;

	 Funcionario funcionarioLogado = new Funcionario();
	 int nivelAcesso = funcionarioLogado.getNivelAcesso();
	
	public TelaPrincipalController() {

	}

	public TelaPrincipalController(JMenuItem cadastrarFuncionario, JMenuItem consultarFuncionario,
			JMenuItem adicionarMateriais, JMenuItem consultarMateriais, JMenuItem solicitaRequisicao,
			JMenuItem consultaRequisicao, JMenuItem sobre , Funcionario funcionario) {
		this.cadastrarFuncionario = cadastrarFuncionario;
		this.consultarFuncionario = consultarFuncionario;
		this.adicionarMateriais = adicionarMateriais;
		this.consultarMateriais = consultarMateriais;
		this.solicitaRequisicao = solicitaRequisicao;
		this.consultaRequisicao = consultaRequisicao;
		this.sobre = sobre;
		this.funcionarioLogado = funcionario;

	}
	

	public void telaFuncionario(JPanel panelFuncionario) {
		panelFuncionario.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				if (funcionarioLogado.getNivelAcesso() == 1 ) {
					ViewPrincipalFuncionario telaFuncionario = new ViewPrincipalFuncionario();
					telaFuncionario.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar funcionaro",
							"Sem permissão", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
	}

	public void telaMaterias(JPanel panelMaterias) {
		panelMaterias.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (funcionarioLogado.getNivelAcesso() == 1 || funcionarioLogado.getNivelAcesso() == 3) {
					TelaGerenciaProdutos gerenciaProdutos = new TelaGerenciaProdutos();
					gerenciaProdutos.show();
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar produtos",
							"Sem permissão", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
	}

	public void telaRequisicao(JPanel panelRequisicao) {
		panelRequisicao.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (funcionarioLogado.getNivelAcesso() == 1 || funcionarioLogado.getNivelAcesso() == 2) {
					TelaGerenciaRequisicao telaRequisicao = new TelaGerenciaRequisicao(funcionarioLogado);
					telaRequisicao.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para solicitar requisição",
							"Sem permissão", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == cadastrarFuncionario) {
			if (funcionarioLogado.getNivelAcesso() == 1) {
				ViewCadastraFuncionario cadastraFunc = new ViewCadastraFuncionario();
				cadastraFunc.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar funcionaro", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == consultarFuncionario) {
			if (funcionarioLogado.getNivelAcesso() == 1) {
				ViewPrincipalFuncionario telaFuncionario = new ViewPrincipalFuncionario();
				telaFuncionario.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar funcionaro", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == adicionarMateriais) {
			if (funcionarioLogado.getNivelAcesso() == 1 || funcionarioLogado.getNivelAcesso() == 3) {
				TelaCadastroProdutos cadastraProdutos = new TelaCadastroProdutos();
				cadastraProdutos.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar produtos", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == consultarMateriais) {
			if (funcionarioLogado.getNivelAcesso() == 1 || funcionarioLogado.getNivelAcesso() == 3) {
				TelaGerenciaProdutos gerenciaProdutos = new TelaGerenciaProdutos();
				gerenciaProdutos.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar produtos", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == solicitaRequisicao) {
			if (funcionarioLogado.getNivelAcesso() == 1 || funcionarioLogado.getNivelAcesso() == 2) {
				TelaRequisicao telaRequisicao = new TelaRequisicao(funcionarioLogado);
				telaRequisicao.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para solicitar requisição", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (e.getSource() == consultaRequisicao) {
			if (funcionarioLogado.getNivelAcesso() == 1 || funcionarioLogado.getNivelAcesso() == 2) {
				TelaGerenciaRequisicao gerenciaRequisicao = new TelaGerenciaRequisicao(funcionarioLogado);
				gerenciaRequisicao.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para solicitar requisição", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sobre){
			String msg = "Sistema desenvolvido pelos alunos da Fatec Zona Leste - 2016 \n\nGuilherme Jatobá \nLeandro Vieira \nMateus Andrade ";
			JOptionPane.showMessageDialog(null, msg, "Desenvolvimento",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
