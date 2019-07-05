package br.com.fundatec.PedidoPizzaria.api.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	List<Item> findByNomeContainingIgnoringCase(String nome);


	
	@Query(" select item from Item item "
			+ "where item.id = :id "
			+ " or item.nome = :nome "
			+ " or item.valor = :valor ")
	List<Item> listar(@Param(value="id") Long id, 
							@Param(value="nome") String nome, 
							@Param(value="valor")Integer valor);
	
}
