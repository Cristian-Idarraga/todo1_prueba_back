package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.DatoMaestroDao;
import com.todo1.prueba_tecnica.dto.DatoMaestro;
import com.todo1.prueba_tecnica.service.DatoMaestroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DatoMaestroServiceImpl implements DatoMaestroService {

  private final DatoMaestroDao datoMaestroDao;

  public DatoMaestroServiceImpl(DatoMaestroDao datoMaestroDao){
    this.datoMaestroDao = datoMaestroDao;
  }

  @Override
  public List<DatoMaestro> getAll() {
    return datoMaestroDao.getAll();
  }

  @Override
  public DatoMaestro getById(long id) {
    return datoMaestroDao.getById(id);
  }

  @Override
  public DatoMaestro update(DatoMaestro compra) {
    return datoMaestroDao.update(compra);
  }

  @Override
  public DatoMaestro insert(DatoMaestro compra) {
    return datoMaestroDao.insert(compra);
  }

  @Override
  public Boolean delete(long id) {
    return datoMaestroDao.delete(id);
  }
}
