package com.milestone.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";
//	@Bean
//	public Docket postsApi() {
//		return (new Docket(DocumentationType.SWAGGER_2)).groupName("public-api").apiInfo(apiInfo()).select()
//				.paths(postPaths()).build();
//	}


	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();

	}

//	private Predicate<String> postPaths() {
//		return Predicates.or(PathSelectors.regex("/api/posts.*"), PathSelectors.regex("/timetable.*"));
//	}
//
//	private ApiInfo apiInfo() {
//		return (new ApiInfoBuilder()).title("Tinka Limited Trader API").description("Trader reference for developers")
//				.termsOfServiceUrl("http://www.gazetilimited.co.ke").contact("079")
//				.license("Tinka Public License").licenseUrl("info@tinka.co.ke").version("1.0").build();
//	}


	private ApiInfo apiInfo() {
		return new ApiInfo(
				"My REST API",
				"Some custom description of API.",
				"1.0",
				"Terms of service",
				new Contact("Sallo Szrajbman", "www.baeldung.com", "salloszraj@gmail.com"),
				"License of API",
				"API license URL",
				Collections.emptyList());
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope
				= new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}



