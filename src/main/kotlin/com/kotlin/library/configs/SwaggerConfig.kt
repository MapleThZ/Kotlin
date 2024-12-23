//package com.kotlin.library.configs
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import springfox.documentation.builders.ApiInfoBuilder
//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket
//import springfox.documentation.swagger2.annotations.EnableSwagger2
//import springfox.documentation.service.ApiInfo
//import springfox.documentation.service.SecurityScheme
//import springfox.documentation.service.AuthorizationScope
//import springfox.documentation.service.SecurityReference
//
//@Configuration
//@EnableSwagger2
//class SwaggerConfig {
//
//    @Bean
//    fun api(): Docket {
//        return Docket(DocumentationType.SWAGGER_2)
//            .apiInfo(apiInfo())
//            .select()
//            .apis(RequestHandlerSelectors.basePackage("com.example"))
//            .paths(PathSelectors.any())
//            .build()
//            .securitySchemes(listOf(bearerAuth()))
//            .securityContexts(listOf(securityContext()))
//    }
//
//    private fun apiInfo(): ApiInfo {
//        return ApiInfoBuilder()
//            .title("My API")
//            .description("Description of my API")
//            .version("1.0")
//            .build()
//    }
//
//    private fun bearerAuth(): SecurityScheme {
//        return SecurityScheme()
//            .type(SecurityScheme.Type.HTTP)
//            .scheme("bearer")
//            .bearerFormat("JWT")
//    }
//
//    private fun securityContext(): springfox.documentation.spi.service.contexts.SecurityContext {
//        return springfox.documentation.spi.service.contexts.SecurityContext.builder()
//            .securityReferences(listOf(SecurityReference("bearerAuth", arrayOf(AuthorizationScope("read", "read all")))))
//            .build()
//    }
//}