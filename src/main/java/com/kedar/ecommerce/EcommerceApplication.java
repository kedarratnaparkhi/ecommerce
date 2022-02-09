package com.kedar.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Ecommerce Title",
				"Ecommerce description",
				"1.0",
				"http://abcd.com",
				new Contact("Kedar", "http://kedar.com", "abcd@abcd.com"),
				"lic String",
				"hhhh;;;"
		);
	}

	@Bean
	public Docket swaggerCOnfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.build().apiInfo(apiInfo());
	}
}
