package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.DatoMaestro;
import com.todo1.prueba_tecnica.service.DatoMaestroService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datomaestro")
public class DatoMaestroController {

  private final DatoMaestroService datoMaestroService;

  public DatoMaestroController(DatoMaestroService datoMaestroService){
    this.datoMaestroService = datoMaestroService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<DatoMaestro>>> getAll() {
    var result = datoMaestroService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<DatoMaestro>> getById(@PathVariable long id) {
    var result = datoMaestroService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<DatoMaestro>> update(@RequestBody DatoMaestro compra) {
    var result = datoMaestroService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<DatoMaestro>> insert(@RequestBody DatoMaestro compra) {
    var result = datoMaestroService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = datoMaestroService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
