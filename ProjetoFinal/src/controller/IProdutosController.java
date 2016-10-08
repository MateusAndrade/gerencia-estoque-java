package controller;

import java.sql.SQLException;
import java.util.List;

import model.Produtos;

public interface IProdutosController {
	public void listaProdutos(List<Produtos> listaProduto)throws SQLException;
	public void listaProduto2(Produtos produto)throws SQLException;

}
