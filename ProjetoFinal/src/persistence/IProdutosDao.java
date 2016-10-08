package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Produtos;

public interface IProdutosDao {

	public void insereProduto(Produtos produto)throws SQLException;
	public void atualizaProduto(Produtos produto)throws SQLException;
	public void excluiProduto(Produtos produto)throws SQLException;
	public List<Produtos> consultaProdutos ()throws SQLException;
	public Produtos consultaProdutoPesquisa(String codigo)throws SQLException;
	public List<Produtos> parametrosPesquisa1(String nome)throws SQLException;
	public Produtos consultaProdutoTable(Produtos produto)throws SQLException;
	public void alteraQuantiade(Produtos produto, int quantidade) throws SQLException;
}
