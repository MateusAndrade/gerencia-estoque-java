package model;

public class Produtos {

	private int codigoProduto;
	private String nomeProduto;
	private int qtdeProduto;

	
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public int getQtdeProduto() {
		return qtdeProduto;
	}
	public void setQtdeProduto(int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}

	@Override
	public String toString() {
		return nomeProduto;
	}
	
	
	
	
	
	
}
