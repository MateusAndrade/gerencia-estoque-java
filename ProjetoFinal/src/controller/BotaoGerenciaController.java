package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import persistence.IProdutosDao;
import persistence.ProdutosDao;

public class BotaoGerenciaController implements ActionListener {
	
	DefaultTableModel model;
	private JTextField txtNomeAltera;
	private JTextField txtQtde;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JTextField txtCodigo;
	private JTable tblProdutos;
	
	


	
	public BotaoGerenciaController() {
		
	}

	public BotaoGerenciaController(JTextField txtNomeAltera, JTextField txtQtde, JButton btnAlterar,
			JButton btnExcluir, JTextField txtCodigo, JTable tblProdutos) {
		this.txtNomeAltera = txtNomeAltera;
		this.txtQtde = txtQtde;
		this.btnAlterar = btnAlterar;
		this.btnExcluir = btnExcluir;
		this.txtCodigo = txtCodigo;
		this.tblProdutos = tblProdutos;
	}
	
	IProdutosController ipController = new ProdutosController();
	IProdutosDao ipDao = new ProdutosDao();
	Produtos prod = new Produtos();
	
	

	@Override
	public void actionPerformed(ActionEvent e) {	
		Produtos prod = new Produtos();
		List<Produtos> produto = new ArrayList<Produtos>();
		prod.setCodigoProduto(Integer.parseInt(txtCodigo.getText()));
		prod.setNomeProduto(txtNomeAltera.getText());
		prod.setQtdeProduto(Integer.parseInt(txtQtde.getText()));
		produto.add(prod);
		if (e.getSource() == btnAlterar){
			alterar(prod);
			try {
				ipController = new ProdutosController(tblProdutos);
				ipController.listaProduto2(prod);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnExcluir){
			excluir(prod);
			limpaTela();
		}
	}

	private void limpaTela() {
		txtCodigo.setText("");
		txtNomeAltera.setText("");
		txtQtde.setText("");	
	}

	private void excluir(Produtos prod) {
		IProdutosDao ipDao = new ProdutosDao();
		try {
			ipDao.excluiProduto(prod);
			JOptionPane.showMessageDialog(null, "Produto Excluido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void alterar(Produtos prod) {
		IProdutosDao ipDao = new ProdutosDao();
		try {
			ipDao.atualizaProduto(prod);
			JOptionPane.showMessageDialog(null, "Produto Atualizado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	

}
