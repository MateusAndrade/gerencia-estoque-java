package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produtos;

public class ProdutosDao implements IProdutosDao {
	
	private Connection c;
	
	public ProdutosDao() {
		GenericDao gDao = new GenericDao();
		try {
			c = gDao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void insereProduto(Produtos produto) throws SQLException {
		String sql = "INSERT INTO materiais (NOME_MATERIAL, QTD_MATERIAL) VALUES (?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, produto.getNomeProduto());
		ps.setInt(2, produto.getQtdeProduto());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaProduto(Produtos produto) throws SQLException {
		String sql = "UPDATE materiais SET NOME_MATERIAL = ?, QTD_MATERIAL = ? WHERE CODIGO_MATERIAL = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, produto.getNomeProduto());
		ps.setInt(2, produto.getQtdeProduto());
		ps.setInt(3, produto.getCodigoProduto());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiProduto(Produtos produto) throws SQLException {
		String sql = "DELETE materiais WHERE CODIGO_MATERIAL = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getCodigoProduto());
		ps.execute();
		ps.close();
	}

	@Override
	public List<Produtos> consultaProdutos() throws SQLException {
		String sql = "SELECT CODIGO_MATERIAL, NOME_MATERIAL, QTD_MATERIAL FROM materiais";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Produtos> listaProdutos = new ArrayList<Produtos>();
		while (rs.next()){
			Produtos prod = new Produtos();
			prod.setCodigoProduto(rs.getInt("CODIGO_MATERIAL"));
			prod.setNomeProduto(rs.getString("NOME_MATERIAL"));
			prod.setQtdeProduto(rs.getInt("QTD_MATERIAL"));
			listaProdutos.add(prod);
		}
		rs.close();
		ps.close();
		return listaProdutos;
	}

	@Override
	public Produtos consultaProdutoPesquisa(String codigo) throws SQLException {
		String sql = "SELECT CODIGO_MATERIAL, NOME_MATERIAL, QTD_MATERIAL FROM materiais WHERE CODIGO_MATERIAL = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, codigo);
		ResultSet rs = ps.executeQuery();
		Produtos prod = new Produtos();
		if (rs.next()){
			prod.setCodigoProduto(rs.getInt("CODIGO_MATERIAL"));
			prod.setNomeProduto(rs.getString("NOME_MATERIAL"));
			prod.setQtdeProduto(rs.getInt("QTD_MATERIAL"));
		}
		rs.close();
		ps.close();
		return prod;
	}

	@Override
	public List<Produtos> parametrosPesquisa1(String nome) throws SQLException {
		List<Produtos> lista = new ArrayList<Produtos>();
		String sql = "SELECT CODIGO_MATERIAL, NOME_MATERIAL, QTD_MATERIAL FROM materiais WHERE NOME_MATERIAL LIKE ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%"+nome+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Produtos prod = new Produtos();
			prod.setCodigoProduto(rs.getInt("CODIGO_MATERIAL"));
			prod.setNomeProduto(rs.getString("NOME_MATERIAL"));
			prod.setQtdeProduto(rs.getInt("QTD_MATERIAL"));
			lista.add(prod);
		}
		rs.close();
		ps.close();
		return lista;
	}


	@Override
	public Produtos consultaProdutoTable(Produtos produto) throws SQLException {
		String sql = "SELECT CODIGO_MATERIAL, NOME_MATERIAL, QTD_MATERIAL FROM materiais WHERE CODIGO_MATERIAL = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getCodigoProduto());
		ResultSet rs = ps.executeQuery();
		Produtos prod = new Produtos();
		if (rs.next()){
			prod.setCodigoProduto(rs.getInt("CODIGO_MATERIAL"));
			prod.setNomeProduto(rs.getString("NOME_MATERIAL"));
			prod.setQtdeProduto(rs.getInt("QTD_MATERIAL"));
		}
		rs.close();
		ps.close();
		return prod;
	}
	
	public void alteraQuantiade(Produtos produto, int quantidade) throws SQLException {
		String sql = "UPDATE materiais SET QTD_MATERIAL = ? WHERE CODIGO_MATERIAL = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, quantidade);
		ps.setInt(2, produto.getCodigoProduto());
		ps.execute();
		ps.close();

	}

}
