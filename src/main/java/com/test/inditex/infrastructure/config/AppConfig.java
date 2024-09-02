package com.test.inditex.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.test.inditex")
@EntityScan(basePackages = "com.test.inditex.domain.entity")
@EnableJpaRepositories(basePackages = "com.test.inditex.domain.repository")
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Store pricing API")
                        .version(appVersion)
                        .description(appDesciption)
                        .contact(new Contact().name("Carlos Setien").email("lucas.walkowicz@gmail.com"))
                );
    }

}
