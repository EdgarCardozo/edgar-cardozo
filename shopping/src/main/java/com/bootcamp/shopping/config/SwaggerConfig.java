package com.bootcamp.shopping.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket shoppingApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bootcamp.shopping"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Shopping cart Api")
                .description("Shopping cart API reference for developers")
                .termsOfServiceUrl("https://github.com/java-bootcamp-rcia/user-guide/wiki/Topic-3:-Services")
                .contact(new Contact("edgar07cardozo@hotmail.com","mywebsite.com","edgar07cardozo@hotmail.com"))
                .license("TheLicense")
                .licenseUrl("tothelicence@email.com").version("1.0").build();
    }

}
