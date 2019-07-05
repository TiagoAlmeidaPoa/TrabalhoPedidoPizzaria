package br.com.fundatec.PedidoPizzaria.api.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fundatec.PedidoPizzaria.api.v1.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	
}
