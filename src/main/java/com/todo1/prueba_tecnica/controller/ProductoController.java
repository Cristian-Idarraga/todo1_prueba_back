package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.Producto;
import com.todo1.prueba_tecnica.service.ProductoService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

  private final ProductoService productoService;

  public ProductoController(ProductoService productoService){
    this.productoService = productoService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<Producto>>> getAll() {
    var result = productoService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<Producto>> getById(@PathVariable long id) {
    var result = productoService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<Producto>> update(@RequestBody Producto compra) {
    var result = productoService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<Producto>> insert(@RequestBody Producto compra) {
    var result = productoService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = productoService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
