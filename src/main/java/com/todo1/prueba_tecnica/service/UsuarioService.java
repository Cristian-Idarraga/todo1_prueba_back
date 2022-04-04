package com.todo1.prueba_tecnica.service;

import com.todo1.prueba_tecnica.dto.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsuarioService {
  List<Usuario> getAll();
  Usuario getById(long id);
  Usuario update(Usuario compra) throws Exception;
  Usuario insert(Usuario compra) throws Exception;
  Boolean delete(long id);
}
