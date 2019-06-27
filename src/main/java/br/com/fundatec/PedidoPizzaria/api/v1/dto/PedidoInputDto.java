package br.com.fundatec.PedidoPizzaria.api.v1.dto;

public class PedidoInputDto {
	
	private int mesa;
	private String itens;
	private String valores;
	
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public String getItens() {
		return itens;
	}
	public void setItens(String itens) {
		this.itens = itens;
	}
	public String getValores() {
		return valores;
	}
	public void setValores(String valores) {
		this.valores = valores;
	}
	
	

}
