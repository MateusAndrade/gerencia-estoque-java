package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import persistence.ProdutosDao;
import view.TelaExcluiAlteraProduto;

public class ProdutosTableClick implements MouseListener  {
	

	private JTable tblProdutos;
	private DefaultTableModel model;


	public ProdutosTableClick(JTable tblProdutos, DefaultTableModel model) {
		this.tblProdutos = tblProdutos;
		this.model = model;
	}
	
	BotaoGerenciaController bgController = new BotaoGerenciaController();

	@Override
	public void mouseClicked(MouseEvent evento) {
		int linha = tblProdutos.rowAtPoint(evento.getPoint());
		int coluna = 0;		
		Produtos prod = new Produtos();
		int codigoProduto = (int) model.getValueAt(linha, coluna);;
		prod.setCodigoProduto(codigoProduto);
		ProdutosDao pDao = new ProdutosDao();
		TelaExcluiAlteraProduto tcEAProduto = new TelaExcluiAlteraProduto();
		tcEAProduto.setVisible(true);
		try{
			prod = pDao.consultaProdutoTable(prod);	
			tcEAProduto.passaDados(this, prod.getNomeProduto(), Integer.toString(prod.getQtdeProduto()), Integer.toString(prod.getCodigoProduto()));
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
