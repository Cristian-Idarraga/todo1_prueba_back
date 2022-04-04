package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.Compra;

import java.util.List;

public interface CompraService {
  List<Compra> getAll();
  Compra getById(long id);
  Compra update(Compra compra);
  Compra insert(Compra compra);
  Boolean delete(long id);
}
