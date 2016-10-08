package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ItensRequisicao;
import model.Requisicao;
import persistence.ItensRequisicaoDao;
import persistence.RequisicaoDao;
import view.TelaItensRequisicao;

public class RequisicaoTableClick implements MouseListener {

	private DefaultTableModel modelRequisicao;
	private JTable tableRequisicao;

	public RequisicaoTableClick() {
	}

	
	public RequisicaoTableClick(DefaultTableModel modelRequisicao, JTable tableRequisicao) {
		this.modelRequisicao = modelRequisicao;
		this.tableRequisicao = tableRequisicao;
	}
	

	public void mouseClicked(MouseEvent e) {
		
		int coluna = 0;
		Requisicao requisicao = new Requisicao();
		int linha = tableRequisicao.rowAtPoint(e.getPoint());
		int codigo = (int) modelRequisicao.getValueAt(linha, coluna);
		requisicao.setCodigoRequiscao(codigo);
	
		
		try {
			RequisicaoDao rDao = new RequisicaoDao();
			Requisicao r2 = new Requisicao();
			r2 = rDao.consultaRequisicao(requisicao);
			ItensRequisicaoDao itensDao = new ItensRequisicaoDao();
			List<ItensRequisicao> listaItens = itensDao.retornaItensRequisicao(r2);
						
			
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format((r2.getDataRequisicao()));
			
			TelaItensRequisicao telaItens = new TelaItensRequisicao();
			telaItens.setVisible(true);
			telaItens.carregaDados(String.valueOf(r2.getCodigoRequiscao()), r2.getFuncionario().getNomeFuncionario(), data, listaItens);
			
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

}
