package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.CompraProductoDao;
import com.todo1.prueba_tecnica.dto.CompraProducto;
import com.todo1.prueba_tecnica.service.CompraProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompraProductoServiceImpl implements CompraProductoService {

  private final CompraProductoDao compraProductoDao;

  public CompraProductoServiceImpl(CompraProductoDao compraProductoDao){
    this.compraProductoDao = compraProductoDao;
  }

  @Override
  public List<CompraProducto> getAll() {
    return compraProductoDao.getAll();
  }

  @Override
  public CompraProducto getById(long id) {
    return compraProductoDao.getById(id);
  }

  @Override
  public CompraProducto update(CompraProducto compra) {
    return compraProductoDao.update(compra);
  }

  @Override
  public CompraProducto insert(CompraProducto compra) {
    return compraProductoDao.insert(compra);
  }

  @Override
  public Boolean delete(long id) {
    return compraProductoDao.delete(id);
  }
}
