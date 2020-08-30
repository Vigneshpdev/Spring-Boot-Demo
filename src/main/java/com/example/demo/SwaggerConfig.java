package com.example.demo;


import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
//import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo());
				
	}

	private ApiInfo apiInfo() {
		 
		return new ApiInfo("Demo Project Documentation", "Demo Project", "1.0", "urn:tos",
		          new Contact("Vignesh", "www.demo.com", "demo@gmail.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());
	}

}
