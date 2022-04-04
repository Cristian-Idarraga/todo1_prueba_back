package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.Maestro;

import java.util.List;

public interface MaestroDao {
  List<Maestro> getAll();
  Maestro getById(long id);
  Maestro update(Maestro entity);
  Maestro insert(Maestro entity);
  Boolean delete(long id);
}
