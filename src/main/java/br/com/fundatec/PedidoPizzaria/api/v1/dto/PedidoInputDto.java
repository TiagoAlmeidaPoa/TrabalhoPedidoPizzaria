package br.com.fundatec.PedidoPizzaria.api.v1.dto;

import java.util.List;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Item;

public class PedidoInputDto {
	
	
	private int mesa;
	private List<Item> itens;
	
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
	
	
		
}
