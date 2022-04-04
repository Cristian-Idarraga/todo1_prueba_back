package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.Usuario;
import com.todo1.prueba_tecnica.service.UsuarioService;
import com.todo1.prueba_tecnica.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService){
    this.usuarioService = usuarioService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage<List<Usuario>>> getAll() {
    var result = usuarioService.getAll();
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage<Usuario>> getById(@PathVariable long id) {
    var result = usuarioService.getById(id);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<ResponseMessage<Usuario>> update(@RequestBody Usuario compra) throws Exception {
    var result = usuarioService.update(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<Usuario>> insert(@RequestBody Usuario compra) throws Exception {
    var result = usuarioService.insert(compra);
    return new ResponseEntity<>(new ResponseMessage<>(0, null, result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable long id) {
    var result = usuarioService.delete(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
