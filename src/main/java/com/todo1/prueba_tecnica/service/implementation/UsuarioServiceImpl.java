package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.UsuarioDao;
import com.todo1.prueba_tecnica.dto.Usuario;
import com.todo1.prueba_tecnica.service.UsuarioService;
import com.todo1.prueba_tecnica.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioDao usuarioDao;
  private final SecurityUtil securityUtil;

  public UsuarioServiceImpl(UsuarioDao usuarioDao, SecurityUtil securityUtil){
    this.usuarioDao = usuarioDao;
    this.securityUtil = securityUtil;
  }

  @Override public List<Usuario> getAll() {
    return usuarioDao.getAll();
  }

  @Override public Usuario getById(long id) {
    return usuarioDao.getById(id);
  }

  @Override public Usuario update(Usuario compra) throws Exception {
    compra.setNombreUsuario(securityUtil.encriptar(compra.getNombreUsuario()));
    return usuarioDao.update(compra);
  }

  @Override public Usuario insert(Usuario compra) throws Exception {
    compra.setContrasena(securityUtil.encriptar(compra.getContrasena()));
    compra.setNombreUsuario(securityUtil.encriptar(compra.getNombreUsuario()));
    return usuarioDao.insert(compra);
  }

  @Override public Boolean delete(long id) {
    return usuarioDao.delete(id);
  }


}
