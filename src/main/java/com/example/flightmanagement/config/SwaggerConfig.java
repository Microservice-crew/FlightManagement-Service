package com.example.flightmanagement.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration

public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());

    }
    public Info infoAPI() {
        return new Info().title("Flight").description("TP").contact(contactAPI());

    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("arij").email("arij.hajji@esprit.tn").url("https://www.linkedin.com/in/arij-hajji/");
        return contact;
    }
    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch( "/flights/**")
                .pathsToExclude("**")
                .build();
    }


}
