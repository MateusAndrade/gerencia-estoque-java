package controller;


import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.IFuncionariosDao;

public class FuncionariosTableController {

	private DefaultTableModel model;
	
	public FuncionariosTableController(DefaultTableModel model){
		this.model = model;
	}
	
	public FuncionariosTableController(){
		
	}
	
	public void preencheTabela() throws SQLException{
		IFuncionariosDao mDao = new FuncionarioDao();
		List<Funcionario> listaFuncionarios = mDao.consultaFuncionarios();
		
		model.setRowCount(0);
		
		for(Funcionario func : listaFuncionarios)
		{
			Object[] linha = new Object[3];
			linha[0] = func.getNomeFuncionario();
			linha[1] = func.getEmailFuncionario();
			linha[2] = func.getCpfFuncionario();
			model.addRow(linha);
		}
		
	}	
	
}
