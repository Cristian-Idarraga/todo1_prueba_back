package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.Rol;

import java.util.List;

public interface RolService {
  List<Rol> getAll();
  Rol getById(long id);
  Rol update(Rol compra);
  Rol insert(Rol compra);
  Boolean delete(long id);
}
