package br.com.fundatec.PedidoPizzaria.api.v1.mapper;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fundatec.PedidoPizzaria.api.v1.dto.ItemInputDto;
import br.com.fundatec.PedidoPizzaria.api.v1.dto.ItemOutputDto;
import br.com.fundatec.PedidoPizzaria.api.v1.entity.Item;

@Component
public class ItemMapper {

	public ItemOutputDto mapearItemOutPutDto(Item item) {
		return new ItemOutputDto(item.getId(), item.getNome(), item.getValor());
	}

	public Item mapearItem(ItemInputDto itemInputDto) {
		return new Item(null, itemInputDto.getNome(), itemInputDto.getValor());
	}

	public List<ItemOutputDto> mapearListaItemOutPutDto(List<Item> itens) {
		List<ItemOutputDto> listItemDtos = new ArrayList<>();
		for (Item item : itens) {
			listItemDtos.add(mapearItemOutPutDto(item));
		}
		return listItemDtos;
	}

}
