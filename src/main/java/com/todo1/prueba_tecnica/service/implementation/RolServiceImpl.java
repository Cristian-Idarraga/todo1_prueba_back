package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.ProductoDao;
import com.todo1.prueba_tecnica.dao.RolDao;
import com.todo1.prueba_tecnica.dto.Rol;
import com.todo1.prueba_tecnica.service.RolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RolServiceImpl implements RolService {

  private final RolDao rolDao;

  public RolServiceImpl(RolDao rolDao){
    this.rolDao = rolDao;
  }

  @Override public List<Rol> getAll() {
    return rolDao.getAll();
  }

  @Override public Rol getById(long id) {
    return rolDao.getById(id);
  }

  @Override public Rol update(Rol compra) {
    return rolDao.update(compra);
  }

  @Override public Rol insert(Rol compra) {
    return rolDao.insert(compra);
  }

  @Override public Boolean delete(long id) {
    return rolDao.delete(id);
  }
}
