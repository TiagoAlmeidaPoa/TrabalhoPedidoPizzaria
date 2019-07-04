package br.com.fundatec.PedidoPizzaria.api.v1.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int mesa;
	
	@OneToMany(mappedBy = "pedido")
	private List<Item> itens;
	
	public Pedido() {
		
	}

	public Pedido(Long id, int mesa, List<Item> itens) {
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
