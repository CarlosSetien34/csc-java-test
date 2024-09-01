package com.test.inditex.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
                        .contact(new Contact().name("Lucas Walkowicz").email("lucas.walkowicz@gmail.com"))
                );
    }

}
