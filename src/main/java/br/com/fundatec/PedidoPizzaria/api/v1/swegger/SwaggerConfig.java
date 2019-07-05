package br.com.fundatec.PedidoPizzaria.api.v1.swegger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<ResponseMessage> defaultResponses = new ArrayList<>();
        defaultResponses.add(buildResponseMessage(HttpStatus.PRECONDITION_FAILED, "Falha da pr�-conid��o"));
        defaultResponses.add(buildResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno"));
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, defaultResponses)
                .globalResponseMessage(RequestMethod.DELETE, defaultResponses)
                .globalResponseMessage(RequestMethod.GET, defaultResponses)
                .globalResponseMessage(RequestMethod.PATCH, defaultResponses)
                .globalResponseMessage(RequestMethod.PUT, defaultResponses)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("br.com.fundatec.ExemploApis"))
                .build();
    }

    private ResponseMessage buildResponseMessage(HttpStatus status, String message) {
        return new ResponseMessageBuilder()
                .code(status.value())
                .message(message)
                .build();
    }
}

