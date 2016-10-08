package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItensRequisicao;
import model.Requisicao;

public class ItensRequisicaoDao implements IItensRequisicao{
	

	private Connection c;
	

	public ItensRequisicaoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	
	public void adiciona(model.ItensRequisicao itensRequiscao) throws SQLException {
		String sql = "INSERT INTO ItensRequisicao (CODIGO_MATERIAL, CODIGO_REQUISICAO, QTD_MATERIAL_SOLICITADO) VALUES (?,?,?) ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, itensRequiscao.getProduto().getCodigoProduto());
		ps.setInt(2, itensRequiscao.getRequisicao().getCodigoRequiscao());
		ps.setInt(3, itensRequiscao.getQuantidadeSolicitado());
		
		ps.execute();
		ps.close();
	}

	public List<model.ItensRequisicao> consultaItensRequisicao() throws SQLException, ClassNotFoundException {
		List<ItensRequisicao> lista = new ArrayList<ItensRequisicao>();
		
		String sql = "SELECT * FROM ItensRequisicao ";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
			try {
				{
					ItensRequisicao itensRequisicao = new ItensRequisicao();
					ProdutosDao p1 =  new ProdutosDao();
					itensRequisicao.setProduto(p1.consultaProdutoPesquisa(String.valueOf(rs.getInt("CODIGO_MATERIAL"))));
					itensRequisicao.setQuantidadeSolicitado(rs.getInt("QTD_MATERIAL_SOLICITADO"));
					RequisicaoDao rDao = new RequisicaoDao();
					itensRequisicao.setRequisicao(rDao.consultaRequisicao(rs.getInt("CODIGO_REQUISICAO")));
					lista.add(itensRequisicao);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		rs.close();
		ps.close();
		return lista;
	
	}


	@Override
	public List<ItensRequisicao> retornaItensRequisicao(Requisicao requisicao) throws SQLException {
		List<ItensRequisicao> lista = new ArrayList<ItensRequisicao>();
		
		String sql = "SELECT * FROM ItensRequisicao WHERE CODIGO_REQUISICAO = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, requisicao.getCodigoRequiscao());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
			try {
				{
					ItensRequisicao itensRequisicao = new ItensRequisicao();
					ProdutosDao p1 =  new ProdutosDao();
					itensRequisicao.setProduto(p1.consultaProdutoPesquisa(String.valueOf(rs.getInt("CODIGO_MATERIAL"))));
					itensRequisicao.setQuantidadeSolicitado(rs.getInt("QTD_MATERIAL_SOLICITADO"));
					RequisicaoDao rDao = new RequisicaoDao();
					itensRequisicao.setRequisicao(rDao.consultaRequisicao(rs.getInt("CODIGO_REQUISICAO")));
					lista.add(itensRequisicao);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		rs.close();
		ps.close();
		return lista;
	}

}
