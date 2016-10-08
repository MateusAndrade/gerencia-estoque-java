package model;


public class ItensRequisicao {
	
	private Requisicao requisicao;
	private Produtos produto;
	private int quantidadeSolicitado;
	
	public Requisicao getRequisicao() {
		return requisicao;
	}
	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public int getQuantidadeSolicitado() {
		return quantidadeSolicitado;
	}
	public void setQuantidadeSolicitado(int quantidadeSolicitado) {
		this.quantidadeSolicitado = quantidadeSolicitado;
	}
	@Override
	public String toString() {
		return "ItensRequisicao: requisicao =" + requisicao + ", produto =" + produto + ", quantidadeSolicitado ="
				+ quantidadeSolicitado ;
	}

	
	
}
