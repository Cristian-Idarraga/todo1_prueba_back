package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.Compra;
import com.todo1.prueba_tecnica.service.CompraService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraController {
  private final CompraService compraService;

  public CompraController(CompraService compraService){
    this.compraService = compraService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<Compra>>> getAll() {
    var result = compraService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<Compra>> getById(@PathVariable long id) {
    var result = compraService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<Compra>> update(@RequestBody Compra compra) {
    var result = compraService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<Compra>> insert(@RequestBody Compra compra) {
    var result = compraService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = compraService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
