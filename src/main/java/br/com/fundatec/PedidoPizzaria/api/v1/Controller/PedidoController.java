package br.com.fundatec.PedidoPizzaria.api.v1.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.PedidoPizzaria.api.v1.dto.PedidoInputDto;
import br.com.fundatec.PedidoPizzaria.api.v1.entity.Pedido;
import br.com.fundatec.PedidoPizzaria.api.v1.mapper.PedidoMapper;

@RestController
public class PedidoController {
	

	private PedidoMapper pedidoMapper;
	
	@PostMapping("/v1/pedidos")
	public ResponseEntity<?> incluirPedido(@Valid @RequestBody PedidoInputDto pedidoInputDto){
		
		Pedido pedido = pedidoMapper.mapearPedido(pedidoInputDto);
		return null;
		
	}
			
		
		

}
