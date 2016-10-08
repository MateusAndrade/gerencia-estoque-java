package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDao implements IFuncionariosDao {

	private Connection c;
	
	public FuncionarioDao() {
		GenericDao gDao = new GenericDao();
		try {
			c = gDao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public void insereFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "INSERT INTO funcionarios(CPF_FUNCIONARIO,NOME_FUNCIONARIO,RG_FUNCIONARIO,TELEFONE_FUNCIONARIO,"
				+ "EMAIL_FUNCIONARIO,SENHA_FUNCIONARIO,NIVEL_ACESSO)"
				+ " VALUES(?,?,"
				+ "?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, funcionario.getCpfFuncionario());
		ps.setString(2, funcionario.getNomeFuncionario());
		ps.setString(3, funcionario.getRgFuncionario());
		ps.setString(4, funcionario.getTelefoneFuncionario());
		ps.setString(5, funcionario.getEmailFuncionario());
		ps.setString(6, funcionario.getSenhaFuncionario());
		ps.setInt(7, funcionario.getNivelAcesso());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaFuncionario(Funcionario funcionario) throws SQLException {
		String sql ="UPDATE funcionarios SET CPF_FUNCIONARIO=?,NOME_FUNCIONARIO=?,"
				+ "RG_FUNCIONARIO=?,TELEFONE_FUNCIONARIO=?,EMAIL_FUNCIONARIO=?,"
				+ "SENHA_FUNCIONARIO=?,NIVEL_ACESSO=? WHERE CPF_FUNCIONARIO = "+funcionario.getCpfFuncionario()+"";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, funcionario.getCpfFuncionario());
		ps.setString(2, funcionario.getNomeFuncionario());
		ps.setString(3, funcionario.getRgFuncionario());
		ps.setString(4, funcionario.getTelefoneFuncionario());
		ps.setString(5, funcionario.getEmailFuncionario());
		ps.setString(6, funcionario.getSenhaFuncionario());
		ps.setInt(7, funcionario.getNivelAcesso());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluirFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "DELETE funcionarios WHERE CPF_FUNCIONARIO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, funcionario.getCpfFuncionario());
		ps.execute();
		ps.close();
	}

	@Override
	public List<Funcionario> consultaFuncionarios() throws SQLException {
		String sql = "SELECT NOME_FUNCIONARIO,EMAIL_FUNCIONARIO,CPF_FUNCIONARIO FROM funcionarios";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		while(rs.next()){
			Funcionario func = new Funcionario();
			func.setNomeFuncionario(rs.getString("NOME_FUNCIONARIO"));
			func.setEmailFuncionario(rs.getString("EMAIL_FUNCIONARIO"));
			func.setCpfFuncionario(rs.getString("CPF_FUNCIONARIO"));
			listaFuncionarios.add(func);
		}
		rs.close();
		ps.close();
		return listaFuncionarios;
	}

	@Override
	public Funcionario consultaFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "SELECT NOME_FUNCIONARIO,EMAIL_FUNCIONARIO,CPF_FUNCIONARIO, SENHA_FUNCIONARIO, TELEFONE_FUNCIONARIO,"
				+ "NIVEL_ACESSO,RG_FUNCIONARIO FROM funcionarios WHERE CPF_FUNCIONARIO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, funcionario.getCpfFuncionario());
		ResultSet rs = ps.executeQuery();
		Funcionario func = new Funcionario();
		if (rs.next()){
			func.setNomeFuncionario(rs.getString("nome_funcionario"));
			func.setEmailFuncionario(rs.getString("email_funcionario"));
			func.setCpfFuncionario(rs.getString("cpf_funcionario"));
			func.setRgFuncionario(rs.getString("rg_funcionario"));
			func.setNivelAcesso(rs.getInt("nivel_acesso"));
			func.setTelefoneFuncionario(rs.getString("telefone_funcionario"));
			func.setSenhaFuncionario(rs.getString("senha_funcionario"));
		}
		rs.close();
		ps.close();
		return func;
	}
	
	public Funcionario consultaFuncionarioCpf(String cpf) throws SQLException {
		String sql = "SELECT * FROM funcionarios WHERE cpf_funcionario = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		Funcionario func = new Funcionario();
		if (rs.next()){
			func.setNomeFuncionario(rs.getString("nome_funcionario"));
			func.setEmailFuncionario(rs.getString("email_funcionario"));
			func.setCpfFuncionario(rs.getString("cpf_funcionario"));
			func.setRgFuncionario(rs.getString("rg_funcionario"));
			func.setNivelAcesso(rs.getInt("nivel_acesso"));
			func.setTelefoneFuncionario(rs.getString("telefone_funcionario"));
			func.setSenhaFuncionario(rs.getString("senha_funcionario"));
		}
		rs.close();
		ps.close();
		return func;
	}



}
