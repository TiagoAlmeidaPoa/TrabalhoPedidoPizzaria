package br.com.fundatec.PedidoPizzaria.api.v1.mapper;

public class PedidoOutputDto {
	
	private Long id;
	private int mesa;
	private String itens;
	private String valores;
	
	public PedidoOutputDto() {
		
	}
	
			
	public PedidoOutputDto(Long id, int mesa, String itens, String valores) {
		this.id = id;
		this.mesa = mesa;
		this.itens = itens;
		this.valores = valores;
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
