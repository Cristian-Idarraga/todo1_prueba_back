package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.Rol;

import java.util.List;

public interface RolDao {
  List<Rol> getAll();
  Rol getById(long id);
  Rol update(Rol entity);
  Rol insert(Rol entity);
  Boolean delete(long id);
}
