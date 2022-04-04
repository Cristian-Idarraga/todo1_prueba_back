package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.UsuarioDao;
import com.todo1.prueba_tecnica.dto.Usuario;
import com.todo1.prueba_tecnica.util.SecurityUtil;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

  private final UsuarioDao usuarioDao;
  private final SecurityUtil securityUtil;

  public UserDetailService(UsuarioDao usuarioDao, SecurityUtil securityUtil){
    this.usuarioDao = usuarioDao;
    this.securityUtil = securityUtil;
  }

  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = null;
    try {
      usuario = usuarioDao.getByUsername(securityUtil.encriptar(username));
      return new User(usuario.getNombreUsuario(), usuario.getContrasena(), new ArrayList<>());
    } catch (Exception e) {
      return null;
    }
  }
}
