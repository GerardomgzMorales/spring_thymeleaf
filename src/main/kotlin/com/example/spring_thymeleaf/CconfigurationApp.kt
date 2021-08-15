package com.example.spring_thymeleaf

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CconfigurationApp : WebMvcConfigurer {

    @Autowired
    @Qualifier("interceptorSpring")
    private var tiempoInterceptor: HandlerInterceptor? = null

    override fun addInterceptors(registry: InterceptorRegistry) {
        tiempoInterceptor?.let { registry.addInterceptor(it).addPathPatterns("/", "") }
    }
}