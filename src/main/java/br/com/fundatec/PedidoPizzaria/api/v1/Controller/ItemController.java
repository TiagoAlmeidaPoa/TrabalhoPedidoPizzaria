package br.com.fundatec.PedidoPizzaria.api.v1.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.PedidoPizzaria.api.v1.dto.ErroDto;
import br.com.fundatec.PedidoPizzaria.api.v1.dto.ItemInputDto;
import br.com.fundatec.PedidoPizzaria.api.v1.dto.ItemOutputDto;
import br.com.fundatec.PedidoPizzaria.api.v1.entity.Item;
import br.com.fundatec.PedidoPizzaria.api.v1.entity.Pedido;
import br.com.fundatec.PedidoPizzaria.api.v1.mapper.ItemMapper;
import br.com.fundatec.PedidoPizzaria.api.v1.service.ItemService;
import br.com.fundatec.PedidoPizzaria.api.v1.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {
	
	private ItemService itemService;
	private ItemMapper itemMapper;
	private PedidoService pedidoService;

	public ItemController(ItemService itemService, ItemMapper itemMapper,
			PedidoService pedidoService) {
		this.itemService = itemService;
		this.itemMapper = itemMapper;
		this.pedidoService = pedidoService;
	}

	@GetMapping("/v1/itens/{id}")
	@ApiOperation(value = "Consulta um item",
    notes = "Consulta um item pelo o id passado como parâmetro, caso não encontre retorna um codigo de erro")
	@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Item retornado com sucesso", response = ItemOutputDto.class),
	})
	
	public ResponseEntity<?> ConsultarItem(@PathVariable Long id){		
		try {
			Item item = itemService.consultar(id);
			ItemOutputDto itemOutputDto = itemMapper.mapearItemOutPutDto(item);
			return ResponseEntity.ok(itemOutputDto);
		} catch (IllegalArgumentException e) {
			ErroDto erroDto = new ErroDto(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDto);
		}
	}


	@GetMapping("/v1/itens") // anotação esta pegando
	public ResponseEntity<List<ItemOutputDto>> getItens(@RequestParam(defaultValue ="") String nome) {

		List<Item> listaItem = itemService.listar(nome);
		List<ItemOutputDto> listaItemDto = itemMapper.mapearListaItemOutPutDto(listaItem);
		return ResponseEntity.ok(listaItemDto);
	}

	@PostMapping("/v1/itens") // anotação indica que esta enviando ou incluindo
	
	@GetMapping("/v1/itens/{id}")
	@ApiOperation(value = "Inclui um item",
    notes = "Inclui um item no banco")
	@ApiResponses(value = {
    @ApiResponse(code = 201, message = "Item incluido com sucesso", response = ItemOutputDto.class),
	})
	public ResponseEntity<?> incluirItem(@Valid @RequestBody ItemInputDto itemInputDto) {
		try {
			Item item = itemMapper.mapearItem(itemInputDto);
			if(itemInputDto.getIdPedido() !=null) {				
				Pedido pedido = pedidoService.consultar(itemInputDto.getIdPedido());
				item.setPedido(pedido);
			}
			
			item = itemService.salvar(item);
			ItemOutputDto itemOutputDto = itemMapper.mapearItemOutPutDto(item);
			return ResponseEntity.status(HttpStatus.CREATED).body(itemOutputDto);
		} catch (IllegalArgumentException e) {
			ErroDto erroDto = new ErroDto(e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(erroDto);
		} catch (Exception e) {
			ErroDto erroDto = new ErroDto(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroDto);
		}
	}
	 
	
	@GetMapping("/v1/itens/lista-todos")
	public ResponseEntity<?> listarTodos(@RequestParam(required=false) Long id, 
										@RequestParam(required=false) String nome, 
										@RequestParam(required=false) Integer valor ){
		List<Item> listaItens = itemService.listar(id, nome, valor);
		List<ItemOutputDto> listaItemOutputDto = itemMapper.mapearListaItemOutPutDto(listaItens);
		return ResponseEntity.ok(listaItemOutputDto);
	}
	
	
	@DeleteMapping("/v1/itens/{id}")
	
	@GetMapping("/v1/itens/{id}")
	@ApiOperation(value = "Deleta um Item",
    notes = "Deleta um item pelo id passado como parâmetro, caso não encontre retorna um codigo de erro")
	@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Item Deletado com sucesso", response = ItemOutputDto.class),
	})
	public ResponseEntity<?> deletarItem(@PathVariable Long id){
		
		try {
			itemService.deletar(id);
		return ResponseEntity.ok().build();
		} catch (IllegalArgumentException e) {
			ErroDto erroDto = new ErroDto(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDto);
		}
	} 	

}
