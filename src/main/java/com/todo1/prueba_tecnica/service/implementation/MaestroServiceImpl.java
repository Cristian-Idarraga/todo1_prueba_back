package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.MaestroDao;
import com.todo1.prueba_tecnica.dto.Maestro;
import com.todo1.prueba_tecnica.service.MaestroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaestroServiceImpl implements MaestroService {

  private final MaestroDao maestroDao;

  public MaestroServiceImpl(MaestroDao maestroDao){
    this.maestroDao = maestroDao;
  }

  @Override
  public List<Maestro> getAll() {
    return maestroDao.getAll();
  }

  @Override
  public Maestro getById(long id) {
    return maestroDao.getById(id);
  }

  @Override
  public Maestro update(Maestro compra) {
    return maestroDao.update(compra);
  }

  @Override
  public Maestro insert(Maestro compra) {
    return maestroDao.insert(compra);
  }

  @Override
  public Boolean delete(long id) {
    return maestroDao.delete(id);
  }
}
