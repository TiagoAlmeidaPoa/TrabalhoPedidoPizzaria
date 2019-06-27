package br.com.fundatec.PedidoPizzaria.api.v1.mapper;

import br.com.fundatec.PedidoPizzaria.api.v1.dto.PedidoInputDto;
import br.com.fundatec.PedidoPizzaria.api.v1.entity.Pedido;

public class PedidoMapper {
	
	public PedidoOutputDto mapearPedidoOutPutDto(Pedido pedido) {
		return new PedidoOutputDto(pedido.getId(), 
				                   pedido.getMesa(), 
				                   pedido.getItens(), 
				                   pedido.getValores());
	}
	
	public Pedido mapearPedido(PedidoInputDto pedidoInputDto ) {
		return new Pedido(pedidoInputDto.getMesa(), 
				          pedidoInputDto.getItens(), 
				          pedidoInputDto.getValores());
	}	

}
