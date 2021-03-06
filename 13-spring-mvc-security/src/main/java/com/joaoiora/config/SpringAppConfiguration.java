package com.joaoiora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author João Iora
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.joaoiora")
public class SpringAppConfiguration
  implements WebMvcConfigurer {

  /**
   * @return
   */
  @Bean
  public ViewResolver getViewResolver() {
    final var viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

}
