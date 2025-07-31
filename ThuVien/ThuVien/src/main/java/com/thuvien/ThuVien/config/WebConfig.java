package com.thuvien.ThuVien.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Cho phép tất cả đường dẫn
                        .allowedOrigins("*") // Cho phép mọi origin (FE ở đâu cũng gọi được)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các method hỗ trợ
                        .allowedHeaders("*") // Cho phép mọi header
                        .allowCredentials(false); // Nếu cần gửi cookie thì để true
            }
        };
    }
}
