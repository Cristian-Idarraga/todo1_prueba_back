package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.DatoMaestroDao;
import com.todo1.prueba_tecnica.dto.DatoMaestro;
import com.todo1.prueba_tecnica.mapper.DatoMaestroMapper;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class DatoMaestroDaoImpl implements DatoMaestroDao {

  private static final String SELECTALL = "SELECT * FROM datomaestro";
  private static final String SELECTBYID = SELECTALL  + " WHERE cddato = ?";
  private static final String UPDATE = "UPDATE datomaestro SET cdmaestro=?,codigo=?,descripcion=?,estado=?, fecha_modificacion= NOW() WHERE cddato = ?";
  private static final String INSERT = "INSERT INTO datomaestro(cdmaestro, codigo, descripcion, estado, fecha_creacion) VALUES(?, ?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM datomaestro WHERE cddato = ?";

  JdbcTemplate jdbcTemplate;

  public DatoMaestroDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<DatoMaestro> getAll() {
    return jdbcTemplate.query(SELECTALL, new DatoMaestroMapper());
  }

  @Override
  public DatoMaestro getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new DatoMaestroMapper(), id);
  }

  @Override
  public DatoMaestro update(DatoMaestro entity) {
    jdbcTemplate.update(UPDATE, entity.getCdMaestro(), entity.getCodigo(), entity.getDescripcion(), entity.getEstado(), entity.getCdDato());
    return entity;
  }

  @Override
  public DatoMaestro insert(DatoMaestro entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cddato"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getCdMaestro(), entity.getCodigo(),
          entity.getDescripcion(), entity.getEstado()
      });
      return ps;
    }, keyHolder);
    entity.setCdDato(keyHolder.getKey().longValue());
    return entity;
  }

  @Override
  public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }
}
