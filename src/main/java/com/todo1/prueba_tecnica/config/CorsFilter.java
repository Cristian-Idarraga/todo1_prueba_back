package com.todo1.prueba_tecnica.config;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends GenericFilterBean {

  private static final String OPTIONS = "OPTIONS";

  @Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
    httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
    httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
    httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, Authorization");
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    if (OPTIONS.equalsIgnoreCase(httpServletRequest.getMethod())) {
      httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}
