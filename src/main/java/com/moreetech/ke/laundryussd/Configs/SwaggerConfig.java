package com.moreetech.ke.laundryussd.Configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2

/**
 * @author momondi  on 9/26/2021
 **/
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/*"), regex("/*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("USSD application API")
                .description("Laundry service ussd application ")
                .termsOfServiceUrl("moreecetech.com.ke")
                .contact("momondi547@gmail.com").license("maury@2021")
                .licenseUrl("momondi547@gmail.com").version("1.0").build();
    }


}