package com.todo1.prueba_tecnica.dao;

import com.todo1.prueba_tecnica.dto.Usuario;

import java.util.List;

public interface UsuarioDao {
  List<Usuario> getAll();
  Usuario getById(long id);
  Usuario update(Usuario entity);
  Usuario insert(Usuario entity);
  Boolean delete(long id);
  Usuario getByUsername(String username);
}
