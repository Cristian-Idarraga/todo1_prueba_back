package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.Compra;

import java.util.List;

public interface CompraDao {
  List<Compra> getAll();
  Compra getById(long id);
  Compra update(Compra entity);
  Compra insert(Compra entity);
  Boolean delete(long id);
}
