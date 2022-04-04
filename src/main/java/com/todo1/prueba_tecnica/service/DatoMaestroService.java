package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.DatoMaestro;

import java.util.List;

public interface DatoMaestroService {
  List<DatoMaestro> getAll();
  DatoMaestro getById(long id);
  DatoMaestro update(DatoMaestro compra);
  DatoMaestro insert(DatoMaestro compra);
  Boolean delete(long id);
}
