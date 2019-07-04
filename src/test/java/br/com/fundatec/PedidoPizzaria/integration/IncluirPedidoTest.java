package br.com.fundatec.PedidoPizzaria.integration;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IncluirPedidoTest {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void deveIncluirUmPedido() {
		RestAssured
			.given()
			.header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE)
			.header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
			.body("{" + 
					"	\"mesa\": 1," + 
					"	\"itens\": \"guarana|pizza calabresa|fritas\"," + 
					"	\"valores\": \"6|30|12\"" + 
					"" + 
					"}")
			.when()
			.post("/v1/pedidos")
			.then()
			.body("mesa", Matchers.equalTo(1))
			.body("itens.nome", Matchers.hasItems("guarana","pizza calabresa","fritas"))
			.body("itens.valor", Matchers.hasItems(6,30,12))
			.statusCode(HttpStatus.OK.value());			
			
			
	}

}
