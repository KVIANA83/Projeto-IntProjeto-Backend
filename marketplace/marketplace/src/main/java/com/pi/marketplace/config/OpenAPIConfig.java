package com.pi.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI stringOpenAI() {
        return new OpenAPI().info(new Info()
                                    .title("TEM no Bairro API")
                                    .description("API E-commerce para vínculo de vendedores com compradores")
                                    .version(""));
    }

}
