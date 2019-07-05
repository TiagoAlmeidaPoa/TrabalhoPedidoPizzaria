package br.com.fundatec.PedidoPizzaria.api.v1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, nullable = false)
	private Integer mesa;

	@OneToMany(mappedBy = "pedido")
	private List<Item> itens;

	public Pedido() {

	}

	public Pedido(Long id, Integer mesa) {
		this.id = id;
		this.mesa = mesa;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMesa() {
		return mesa;
	}

	public void setNome(Integer mesa) {
		this.mesa = mesa;
	}

}
