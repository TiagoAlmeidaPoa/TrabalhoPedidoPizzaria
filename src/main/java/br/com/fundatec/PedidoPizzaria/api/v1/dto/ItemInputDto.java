package br.com.fundatec.PedidoPizzaria.api.v1.dto;

import javax.validation.constraints.NotBlank;

public class ItemInputDto {

	@NotBlank(message = "o campo nome deve ser preenchido")
	private String nome;
	private Integer valor;	
	private Long idPedido;
	
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
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	
	
	
	

}
