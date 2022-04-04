package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.ProductoDao;
import com.todo1.prueba_tecnica.dto.Producto;
import com.todo1.prueba_tecnica.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

  private final ProductoDao productoDao;

  public ProductoServiceImpl(ProductoDao productoDao){
    this.productoDao = productoDao;
  }

  @Override
  public List<Producto> getAll() {
    return productoDao.getAll();
  }

  @Override
  public Producto getById(long id) {
    return productoDao.getById(id);
  }

  @Override
  public Producto update(Producto compra) {
    return productoDao.update(compra);
  }

  @Override
  public Producto insert(Producto compra) {
    return productoDao.insert(compra);
  }

  @Override
  public Boolean delete(long id) {
    return productoDao.delete(id);
  }
}
