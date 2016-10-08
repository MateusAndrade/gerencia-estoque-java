package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Produtos;
import persistence.IProdutosDao;
import persistence.ProdutosDao;

public class BotaoProdutosController implements ActionListener {

	private JTextField txtNome;
	private JTextField txtQtde;
	private JButton btnLimpar;

	
	public BotaoProdutosController(JTextField txtNome, JTextField txtQtde,
			JButton btnLimpar) {
		this.txtNome = txtNome;
		this.txtQtde = txtQtde;
		this.btnLimpar = btnLimpar;
	}



	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource() == btnLimpar){
			limpaCampos();
		}else{
			Produtos prod = new Produtos();
			prod.setNomeProduto(txtNome.getText());
			prod.setQtdeProduto(Integer.parseInt(txtQtde.getText()));
			cadastrar(prod);
			limpaCampos();
		}
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtQtde.setText("");		
	}



	private void cadastrar(Produtos prod) {
		IProdutosDao pDao = new ProdutosDao();
		try{
			pDao.insereProduto(prod);
			JOptionPane.showMessageDialog(null, "Produto Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	
}
