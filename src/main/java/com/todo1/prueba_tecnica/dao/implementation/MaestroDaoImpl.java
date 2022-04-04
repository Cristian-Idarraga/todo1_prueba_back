package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.MaestroDao;
import com.todo1.prueba_tecnica.dto.Maestro;
import com.todo1.prueba_tecnica.mapper.MaestroMapper;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MaestroDaoImpl implements MaestroDao {

  private static final String SELECTALL = "SELECT * FROM maestro";
  private static final String SELECTBYID = SELECTALL  + " WHERE cdmaestro = ?";
  private static final String UPDATE = "UPDATE maestro SET codigo=?,descripcion=?,estado=?, fecha_modificacion= NOW() WHERE cdmaestro = ?";
  private static final String INSERT = "INSERT INTO maestro(codigo, descripcion, estado, fecha_creacion) VALUES(?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM maestro WHERE cdmaestro = ?";

  JdbcTemplate jdbcTemplate;

  public MaestroDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<Maestro> getAll() {
    return jdbcTemplate.query(SELECTALL, new MaestroMapper());
  }

  @Override
  public Maestro getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new MaestroMapper(), id);
  }

  @Override
  public Maestro update(Maestro entity) {
    jdbcTemplate.update(UPDATE, entity.getCodigo(), entity.getDescripcion(), entity.getEstado(), entity.getCdMaestro());
    return entity;
  }

  @Override
  public Maestro insert(Maestro entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cdmaestro"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getCodigo(),
          entity.getDescripcion(), entity.getEstado()
      });
      return ps;
    }, keyHolder);
    entity.setCdMaestro(keyHolder.getKey().longValue());
    return entity;
  }

  @Override
  public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }
}
