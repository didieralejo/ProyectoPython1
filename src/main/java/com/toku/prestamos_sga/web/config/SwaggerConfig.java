package com.toku.prestamos_sga.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Este been es el que crea la documentacion
     * se le debe indicar el paquete que queremos que se documente
     * en el application.propiertes se debe agregar la siguiente linea spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
     * Se ejecuta en el navegador como http://127.0.0.1:8081/toku/prestamo/swagger-ui.html
     * @return
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.toku.prestamos_sga.web.controller"))
                .build();
    }
}
