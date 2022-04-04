package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.Producto;

import java.util.List;

public interface ProductoDao {
  List<Producto> getAll();
  Producto getById(long id);
  Producto update(Producto entity);
  Producto insert(Producto entity);
  Boolean delete(long id);
}
