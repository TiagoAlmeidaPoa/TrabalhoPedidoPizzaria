package br.com.fundatec.PedidoPizzaria.api.v1.service;

import org.springframework.stereotype.Service;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Pedido;
import br.com.fundatec.PedidoPizzaria.api.v1.repository.PedidoRepository;


@Service
public class PedidoService {
	
	PedidoRepository pedidoRepository;
	
	
	
	public Pedido salvar(Pedido pedido) { // aqui estou incluindo no banco
		
		return pedidoRepository.save(pedido);
	}
	
	
	

}
