package model;

import java.util.Date;
import java.util.List;

public class Requisicao {
	
	private int codigoRequiscao;
	private Funcionario funcionario;
	private Date dataRequisicao;
	private List<ItensRequisicao> intensRequisicao;
	
	
	public Requisicao() {
	}
		
	
	public Requisicao(int codigoRequiscao, Funcionario funcionario, Date dataRequisicao,
			List<ItensRequisicao> intensRequisicao) {
		this.codigoRequiscao = codigoRequiscao;
		this.funcionario = funcionario;
		this.dataRequisicao = dataRequisicao;
		this.intensRequisicao = intensRequisicao;
	}



	public int getCodigoRequiscao() {
		return codigoRequiscao;
	}
	public void setCodigoRequiscao(int codigoRequiscao) {
		this.codigoRequiscao = codigoRequiscao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Date getDataRequisicao() {
		return dataRequisicao;
	}
	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}
	public List<ItensRequisicao> getIntensRequisicao() {
		return intensRequisicao;
	}
	public void setIntensRequisicao(List<ItensRequisicao> intensRequisicao) {
		this.intensRequisicao = intensRequisicao;
	}


	@Override
	public String toString() {
		return "Requisicao" + codigoRequiscao;
	} 
	
	
	
	
}
