package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.CompraProducto;
import com.todo1.prueba_tecnica.service.CompraProductoService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compraproducto")
public class CompraProductoController {

  private final CompraProductoService compraProductoService;

  public CompraProductoController(CompraProductoService compraProductoService){
    this.compraProductoService = compraProductoService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<CompraProducto>>> getAll() {
    var result = compraProductoService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<CompraProducto>> getById(@PathVariable long id) {
    var result = compraProductoService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<CompraProducto>> update(@RequestBody CompraProducto compra) {
    var result = compraProductoService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<CompraProducto>> insert(@RequestBody  CompraProducto compra) {
    var result = compraProductoService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = compraProductoService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
