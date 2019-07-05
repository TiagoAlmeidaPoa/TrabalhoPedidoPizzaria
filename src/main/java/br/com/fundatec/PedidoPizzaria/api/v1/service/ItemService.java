package br.com.fundatec.PedidoPizzaria.api.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Item;
import br.com.fundatec.PedidoPizzaria.api.v1.repository.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<Item> listar(String nome) {
		return itemRepository.findByNomeContainingIgnoringCase(nome);
	}

	public Item salvar(Item item) { // aqui estou incluindo no banco
		
		return itemRepository.save(item);
	}

	public void deletar(Long id) { // aqui estou deletando do banco

		if (itemRepository.existsById(id)) {
			itemRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Item não existe para este ID");
		}

	}

	public Item consultar(Long id) {

		return itemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Não encontrou item para o id: " + id));
	}

	public List<Item> listar(Long id, String nome, Integer valor) {
		return itemRepository.listar(id, nome, valor);
	}

}
