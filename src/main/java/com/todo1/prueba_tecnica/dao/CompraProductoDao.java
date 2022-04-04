package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.CompraProducto;

import java.util.List;

public interface CompraProductoDao {
  List<CompraProducto> getAll();
  CompraProducto getById(long id);
  CompraProducto update(CompraProducto entity);
  CompraProducto insert(CompraProducto entity);
  Boolean delete(long id);
}
