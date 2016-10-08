package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import persistence.IProdutosDao;
import persistence.ProdutosDao;
import view.TelaCadastroProdutos;

public class RadioGerenciaProdutosController implements ActionListener {
	
	DefaultTableModel model;
	private JRadioButton rdbtnNome;
	private JRadioButton rdbtnCodigo;
	private JButton btnPesqisar;
	private JTextField txtPesquisar;
	private JTable tblProdutos;
	
	

	public RadioGerenciaProdutosController(JRadioButton rdbtnNome, JRadioButton rdbtnCodigo, JButton btnPesquisar, JTextField txtPesquisar, JTable tblProdutos) {
		this.rdbtnNome = rdbtnNome;
		this.rdbtnCodigo = rdbtnCodigo;
		this.btnPesqisar = btnPesquisar;
		this.txtPesquisar = txtPesquisar;
		this.tblProdutos = tblProdutos;
	}

	TelaCadastroProdutos tcProdutos = new TelaCadastroProdutos();
	IProdutosController pContProd = new ProdutosController();
	IProdutosDao ipDao = new ProdutosDao();
	Produtos prod = new Produtos();
	ProdutosTableController ipController = new ProdutosTableController(model);
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPesqisar){
			List<Produtos> produto;
			if (rdbtnNome.isSelected()){
				try {
					produto = ipController.pesquisar(txtPesquisar.getText());
					pContProd = new ProdutosController(tblProdutos);
					pContProd.listaProdutos(produto);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				if(rdbtnCodigo.isSelected()){
					try {
						prod = ipDao.consultaProdutoPesquisa(txtPesquisar.getText());
						pContProd = new ProdutosController(tblProdutos);
						pContProd.listaProduto2(prod);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		txtPesquisar.setText("");

	}

}
