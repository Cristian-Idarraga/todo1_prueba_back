package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.UsuarioDao;
import com.todo1.prueba_tecnica.dto.Usuario;
import com.todo1.prueba_tecnica.mapper.UsuarioMapper;
import com.todo1.prueba_tecnica.util.SecurityUtil;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

  private static final String SELECTALL = "SELECT * FROM usuario";
  private static final String SELECTBYID = SELECTALL  + " WHERE cdusuario = ?";
  private static final String UPDATE = "UPDATE usuario SET nombres=?,apellidos=?,celular=?,correo=?,direccion=?,fecha_nacimiento=?,cdrol=?,cdtipo=?,documento=?,estado=?,fecha_modificacion=NOW() WHERE cdusuario=?";
  private static final String INSERT = "INSERT INTO usuario(nombres, apellidos, celular, correo, direccion, fecha_nacimiento, cdrol, cdtipo, documento, nombre_usuario, contrasena, estado, fecha_creacion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM usuario WHERE cdusuario = ?";
  private static final String SELECTBYUSERNAME = SELECTALL + " WHERE nombre_usuario = ?";
  private final SecurityUtil securityUtil;
  JdbcTemplate jdbcTemplate;

  public UsuarioDaoImpl(DataSource dataSource, SecurityUtil securityUtil){
    jdbcTemplate = new JdbcTemplate(dataSource);
    this.securityUtil = securityUtil;
  }

  @Override public List<Usuario> getAll() {
    return jdbcTemplate.query(SELECTALL, new UsuarioMapper(securityUtil));
  }

  @Override public Usuario getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new UsuarioMapper(securityUtil), id);
  }

  @Override public Usuario update(Usuario entity) {
    jdbcTemplate.update(UPDATE, entity.getNombres(), entity.getApellidos(), entity.getCelular(), entity.getCorreo(),
        entity.getDireccion(), entity.getFechaNacimiento(), entity.getCdRol(), entity.getCdTipo(), entity.getDocumento(), entity.getEstado(), entity.getCdUsuario());
    return entity;
  }

  @Override public Usuario insert(Usuario entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cdusuario"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getNombres(), entity.getApellidos(), entity.getCelular(), entity.getCorreo(),
          entity.getDireccion(), entity.getFechaNacimiento(), entity.getCdRol(), entity.getCdTipo(), entity.getDocumento(),
          entity.getNombreUsuario(), entity.getContrasena(), entity.getEstado()
      });
      return ps;
    }, keyHolder);
    entity.setCdUsuario(keyHolder.getKey().longValue());
    return entity;
  }

  @Override public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }

  @Override public Usuario getByUsername(String username) {
    return jdbcTemplate.queryForObject(SELECTBYUSERNAME, new UsuarioMapper(securityUtil), username);
  }
}
