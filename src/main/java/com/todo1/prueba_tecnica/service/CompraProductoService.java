package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.CompraProducto;

import java.util.List;

public interface CompraProductoService {
  List<CompraProducto> getAll();
  CompraProducto getById(long id);
  CompraProducto update(CompraProducto compra);
  CompraProducto insert(CompraProducto compra);
  Boolean delete(long id);
}
