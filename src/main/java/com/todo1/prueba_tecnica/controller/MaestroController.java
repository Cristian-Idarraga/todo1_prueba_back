package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dao.MaestroDao;
import com.todo1.prueba_tecnica.dto.Maestro;
import com.todo1.prueba_tecnica.service.MaestroService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maestro")
public class MaestroController {

  private final MaestroService maestroService;

  public MaestroController(MaestroService maestroService){
    this.maestroService = maestroService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<Maestro>>> getAll() {
    var result = maestroService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<Maestro>> getById(@PathVariable long id) {
    var result = maestroService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<Maestro>> update(@RequestBody Maestro compra) {
    var result = maestroService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<Maestro>> insert(@RequestBody Maestro compra) {
    var result = maestroService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = maestroService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
