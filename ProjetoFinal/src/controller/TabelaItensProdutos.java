package controller;

import javax.swing.table.DefaultTableModel;

import model.ItensRequisicao;

public class TabelaItensProdutos {
	
	private DefaultTableModel model;
	private ItensRequisicao itensRequisicao;
	
	
	public TabelaItensProdutos() {
	}
	
	
	public TabelaItensProdutos(DefaultTableModel model, ItensRequisicao itensRequisicao) {
		this.model = model;
		this.itensRequisicao = itensRequisicao;
	}

	public TabelaItensProdutos(DefaultTableModel model) {
		this.model = model;
	}


	public void preencheTabela(){
		if(itensRequisicao != null){
			
			Object[] linha = new Object[3];
			linha[0] = itensRequisicao.getRequisicao();
			linha[1] = itensRequisicao.getProduto();
			linha[2] = itensRequisicao.getQuantidadeSolicitado();
			model.addRow(linha);
			
			
			
		}
	}
	

	public void removeLinha(int linha) {
		if (model.getRowCount() > 0) {
			model.removeRow(linha);
			

		}
	}

	
}
