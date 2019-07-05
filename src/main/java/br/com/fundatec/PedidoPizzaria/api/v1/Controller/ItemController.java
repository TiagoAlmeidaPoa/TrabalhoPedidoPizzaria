package br.com.fundatec.PedidoPizzaria.api.v1.Controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.PedidoPizzaria.api.v1.mapper.ItemMapper;
import br.com.fundatec.PedidoPizzaria.api.v1.service.ItemService;
import br.com.fundatec.PedidoPizzaria.api.v1.service.PedidoService;

@RestController
public class ItemController {
	
	private ItemService itemService;
	private ItemMapper itemMapper;
	private PedidoService pedidoService;

}
