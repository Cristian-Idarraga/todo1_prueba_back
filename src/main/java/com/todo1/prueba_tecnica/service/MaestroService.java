package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.Maestro;

import java.util.List;

public interface MaestroService {
  List<Maestro> getAll();
  Maestro getById(long id);
  Maestro update(Maestro compra);
  Maestro insert(Maestro compra);
  Boolean delete(long id);
}
