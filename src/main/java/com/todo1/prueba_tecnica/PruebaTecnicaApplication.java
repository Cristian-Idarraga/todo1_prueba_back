package com.todo1.prueba_tecnica;

import com.todo1.prueba_tecnica.config.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableWebMvc
public class PruebaTecnicaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PruebaTecnicaApplication.class, args);
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistration(){
    FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(new CorsFilter());
    registrationBean.setName("filtros CORS");
    registrationBean.addUrlPatterns("/*");
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return registrationBean;
  }

}
