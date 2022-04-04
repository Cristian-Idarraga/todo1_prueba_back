package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.Venta;
import com.todo1.prueba_tecnica.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/venta")
public class VentaController {

  private final VentaService ventaService;

  public VentaController(VentaService ventaService) {
    this.ventaService = ventaService;
  }

  @PostMapping
  public ResponseEntity<String> venta(Venta venta) throws Exception {
    ventaService.vender(venta);
    return new ResponseEntity<>("venta finalizada", HttpStatus.OK);
  }
}
