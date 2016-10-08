package persistence;

import java.sql.SQLException;
import java.util.List;

import model.ItensRequisicao;
import model.Requisicao;

public interface IItensRequisicao {

	public void adiciona(ItensRequisicao itensRequiscao) throws SQLException;
	public List<ItensRequisicao> consultaItensRequisicao() throws SQLException, ClassNotFoundException;
	public List<ItensRequisicao> retornaItensRequisicao(Requisicao requisicao) throws SQLException;
}
