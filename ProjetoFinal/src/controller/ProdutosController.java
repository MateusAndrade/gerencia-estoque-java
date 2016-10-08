package controller;


import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;

public class ProdutosController implements IProdutosController {

	private JTable tabela;
	
	public ProdutosController() {
		super();
	}
	
	
	public ProdutosController(JTable tabela) {
		this.tabela = tabela;
		
	}



	@Override
	public void listaProdutos(List<Produtos> listaProduto) throws SQLException {
		if (tabela != null){
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			if(listaProduto.isEmpty()){
				JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if (modelo.getRowCount() > 0){
					modelo.setRowCount(0);
				}
				for (Produtos p : listaProduto){
					Object [] linha = new Object[3];
					linha[0] = p.getCodigoProduto();
					linha[1] = p.getNomeProduto();
					linha[2] = p.getQtdeProduto();
					modelo.addRow(linha);
				}
			}	
		}
		
	
	}


	@Override
	public void listaProduto2(Produtos produto) throws SQLException {
		if (tabela != null){
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			if(produto.getCodigoProduto() == 0){
				JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}else{
				if (modelo.getRowCount() > 0){
					modelo.setRowCount(0);
				}
					Object [] linha = new Object[3];
					linha[0] = produto.getCodigoProduto();
					linha[1] = produto.getNomeProduto();
					linha[2] = produto.getQtdeProduto();
					modelo.addRow(linha);
				}
			}
		
		
		
		
	}
	
	

}
