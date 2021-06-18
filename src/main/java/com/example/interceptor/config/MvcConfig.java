package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    // @Autowired를 사용하면 순환참조가 일어 날 수 있다.
    private final AuthInterceptor authInterceptor;

    @Override

    public void addInterceptors(InterceptorRegistry registry) {
                                                //excludePathPatterns("/api/public/*)
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
