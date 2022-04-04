package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.Producto;

import java.util.List;

public interface ProductoService {
  List<Producto> getAll();
  Producto getById(long id);
  Producto update(Producto compra);
  Producto insert(Producto compra);
  Boolean delete(long id);
}
