package br.com.fundatec.PedidoPizzaria.api.v1.mapper;

import java.util.List;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Item;

public class PedidoOutputDto {
	
	private Long id;
	private int mesa;
	private List<Item> itens;
	
	public PedidoOutputDto() {
		
	}

	public PedidoOutputDto(Long id, int mesa, List<Item> itens) {
		this.id = id;
		this.mesa = mesa;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
