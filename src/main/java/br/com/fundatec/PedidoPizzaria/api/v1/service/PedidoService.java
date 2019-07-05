package br.com.fundatec.PedidoPizzaria.api.v1.service;

import org.springframework.stereotype.Service;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Pedido;
import br.com.fundatec.PedidoPizzaria.api.v1.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public Pedido consultar(Long id) {
		return pedidoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Não encontrou pedido para o id:" + id));
	}

}

