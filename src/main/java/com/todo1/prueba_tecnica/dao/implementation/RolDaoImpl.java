package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.RolDao;
import com.todo1.prueba_tecnica.dto.Rol;
import com.todo1.prueba_tecnica.mapper.ProductoMapper;
import com.todo1.prueba_tecnica.mapper.RolMapper;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RolDaoImpl implements RolDao {

  private static final String SELECTALL = "SELECT * FROM rol";
  private static final String SELECTBYID = SELECTALL  + " WHERE cdrol = ?";
  private static final String UPDATE = "UPDATE rol SET nombre=?,descripcion=?,estado=?,fecha_modificacion=NOW() WHERE cdrol=?";
  private static final String INSERT = "INSERT INTO rol(nombre, descripcion, estado, fecha_creacion) VALUES(?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM rol WHERE cdrol = ?";

  JdbcTemplate jdbcTemplate;

  public RolDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }


  @Override public List<Rol> getAll() {
    return jdbcTemplate.query(SELECTALL, new RolMapper());
  }

  @Override public Rol getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new RolMapper(), id);
  }

  @Override public Rol update(Rol entity) {
    jdbcTemplate.update(UPDATE, entity.getNombre(), entity.getDescripcion(), entity.getEstado(), entity.getCdRol());
    return entity;
  }

  @Override public Rol insert(Rol entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cdrol"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getNombre(), entity.getDescripcion(),
          entity.getEstado()
      });
      return ps;
    }, keyHolder);
    entity.setCdRol(keyHolder.getKey().longValue());
    return entity;
  }

  @Override public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }
}
