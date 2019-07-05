package br.com.fundatec.PedidoPizzaria.api.v1.dto;

public class ItemOutputDto {

	private Long id;
	private String nome;
	private Integer valor;

	public ItemOutputDto() {

	}

	public ItemOutputDto(Long id, String nome, Integer valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
