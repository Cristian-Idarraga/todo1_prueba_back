package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.Rol;
import com.todo1.prueba_tecnica.service.RolService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

  private final RolService rolService;

  public RolController(RolService rolService){
    this.rolService = rolService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<Rol>>> getAll() {
    var result = rolService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<Rol>> getById(@PathVariable long id) {
    var result = rolService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<Rol>> update(@RequestBody Rol compra) {
    var result = rolService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<Rol>> insert(@RequestBody Rol compra) {
    var result = rolService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = rolService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
