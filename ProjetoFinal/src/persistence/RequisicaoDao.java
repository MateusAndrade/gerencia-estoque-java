package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.Requisicao;

public class RequisicaoDao implements IRequisicaoDao {

	private Connection c;
	

	public RequisicaoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	public void adicionaRequisicao(Requisicao requisicao) throws SQLException {
		String sql = "INSERT INTO requisicao (CODIGO_REQUISICAO, CPF_FUNCIONARIO, DATA_REQUISICAO ) VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, requisicao.getCodigoRequiscao());
		ps.setString(2, requisicao.getFuncionario().getCpfFuncionario());
		long dataRequsicao = requisicao.getDataRequisicao().getTime();
		java.sql.Date data = new java.sql.Date(dataRequsicao);
		ps.setDate(3, data);
		ps.execute();
		ps.close();

	}

	@Override
	public int gerarCodigo() throws SQLException {
		String sql = "SELECT MAX(CODIGO_REQUISICAO) + 1 AS geraCodigo FROM requisicao";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt("geraCodigo");
		} else {

			return 1;
		}

	}

	@Override
	public List<Requisicao> pesquisaRequisicoes(Requisicao requisicao) throws SQLException {
		List<Requisicao> lista = new ArrayList<Requisicao>();
		String sql = "SELECT CODIGO_REQUISICAO, CPF_FUNCIONARIO, DATA_REQUISICAO FROM requisicao WHERE DATA_REQUISICAO LIKE ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%+data+%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Requisicao requi = new Requisicao();
			requi.setCodigoRequiscao(rs.getInt("CODIGO_REQUISICAO"));
			FuncionarioDao fDao = new FuncionarioDao();
			requi.setFuncionario(fDao.consultaFuncionarioCpf(rs.getString("CPF_FUNCIONARIO")));
			requi.setDataRequisicao(rs.getDate("DATA_REQUISICAO"));
			lista.add(requi);
		}
		rs.close();
		ps.close();
		return lista;
	}
	
	public List<Requisicao> retornaRequisicoes() throws SQLException {
		List<Requisicao> lista = new ArrayList<Requisicao>();
		String sql = "SELECT * FROM requisicao ";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Requisicao requi = new Requisicao();
			requi.setCodigoRequiscao(rs.getInt("CODIGO_REQUISICAO"));
			FuncionarioDao fDao = new FuncionarioDao();
			requi.setFuncionario(fDao.consultaFuncionarioCpf(rs.getString("CPF_FUNCIONARIO")));
			requi.setDataRequisicao(rs.getDate("DATA_REQUISICAO"));
			lista.add(requi);
		}
		rs.close();
		ps.close();
		return lista;
	}

	@Override
	public Requisicao consultaRequisicao(Requisicao requisicao) throws SQLException {
		String sql = "SELECT CODIGO_REQUISICAO, CPF_FUNCIONARIO, DATA_REQUISICAO FROM requisicao WHERE CODIGO_REQUISICAO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, requisicao.getCodigoRequiscao());
		ResultSet rs = ps.executeQuery();
		Requisicao requi = new Requisicao();
		if (rs.next()) {
			requi.setCodigoRequiscao(rs.getInt("CODIGO_REQUISICAO"));
			Funcionario f1 =  new Funcionario();
			f1.setCpfFuncionario(rs.getString("CPF_FUNCIONARIO"));
			FuncionarioDao fDao =  new FuncionarioDao();
			requi.setFuncionario(fDao.consultaFuncionario(f1));
			requi.setDataRequisicao(rs.getDate("DATA_REQUISICAO"));

		}
		rs.close();
		ps.close();
		return requi;
	}
	
	public Requisicao consultaRequisicao(int codigo) throws SQLException{
		String sql = "SELECT CODIGO_REQUISICAO, CPF_FUNCIONARIO, DATA_REQUISICAO FROM requisicao WHERE CODIGO_REQUISICAO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, codigo);
		ResultSet rs = ps.executeQuery();
		Requisicao requi = new Requisicao();
		if (rs.next()) {			
			requi.setCodigoRequiscao(rs.getInt("CODIGO_REQUISICAO"));
			Funcionario f1 =  new Funcionario();
			f1.setCpfFuncionario(rs.getString("CPF_FUNCIONARIO"));
			FuncionarioDao fDao =  new FuncionarioDao();
			requi.setFuncionario(fDao.consultaFuncionario(f1));
			requi.setDataRequisicao(rs.getDate("DATA_REQUISICAO"));

		}
		rs.close();
		ps.close();
		return requi;
	}
	


}
