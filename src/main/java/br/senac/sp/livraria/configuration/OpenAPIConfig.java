package br.senac.sp.livraria.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return  new OpenAPI()
                .info(
                        new Info()
                                .title("API de gerenciamento de Livros")
                                .version("1.0.0")
                                .description("Documentação da API REST para CRUD de livros, editoras e categorias.")
                                .contact(
                                        new Contact()
                                                .name("Equipe de Back-End")
                                                .email("backend@livraria.com")
                                )
                );
    }

}
