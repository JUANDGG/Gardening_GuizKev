package com.guizKev.api.segurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ConfigCors {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080/api", "https://apigardeningguizkev-production.up.railway.app/api")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*") 
                        .exposedHeaders("Authorization") 
                        .allowCredentials(true); 
            }
        };
    }
}

