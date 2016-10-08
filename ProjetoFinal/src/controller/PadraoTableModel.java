package controller;

import javax.swing.table.DefaultTableModel;

public class PadraoTableModel extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PadraoTableModel(Object[][] dados, String[] cabecalho) {
		super.setDataVector(dados, cabecalho);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
	
	}
}
