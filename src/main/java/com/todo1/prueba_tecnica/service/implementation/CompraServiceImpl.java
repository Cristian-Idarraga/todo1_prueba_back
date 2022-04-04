package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.CompraDao;
import com.todo1.prueba_tecnica.dto.Compra;
import com.todo1.prueba_tecnica.service.CompraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompraServiceImpl implements CompraService {

  private final CompraDao compraDao;

  public CompraServiceImpl(CompraDao compraDao){
    this.compraDao = compraDao;
  }
  @Override
  public List<Compra> getAll() {
    return compraDao.getAll();
  }

  @Override
  public Compra getById(long id) {
    return compraDao.getById(id);
  }

  @Override
  public Compra update(Compra compra) {
    return compraDao.update(compra);
  }

  @Override
  public Compra insert(Compra compra) {
    return compraDao.insert(compra);
  }

  @Override
  public Boolean delete(long id) {
    return compraDao.delete(id);
  }
}
