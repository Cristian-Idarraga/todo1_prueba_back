package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.DatoMaestro;

import java.util.List;

public interface DatoMaestroDao {
  List<DatoMaestro> getAll();
  DatoMaestro getById(long id);
  DatoMaestro update(DatoMaestro entity);
  DatoMaestro insert(DatoMaestro entity);
  Boolean delete(long id);
}
