package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Requisicao;

public interface IRequisicaoDao {

	public void adicionaRequisicao(Requisicao requisicao) throws SQLException;
	public Requisicao consultaRequisicao(Requisicao requisicao) throws SQLException;
	public List<Requisicao> pesquisaRequisicoes(Requisicao requisicao) throws SQLException;
	public List<Requisicao> retornaRequisicoes() throws SQLException;
	public int  gerarCodigo() throws SQLException;
	public Requisicao consultaRequisicao(int codigo) throws SQLException;
	
	
}
