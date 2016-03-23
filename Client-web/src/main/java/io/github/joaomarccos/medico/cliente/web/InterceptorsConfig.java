package io.github.joaomarccos.medico.cliente.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@Configuration
public class InterceptorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NavigationrHandler()).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login");
    }

}
