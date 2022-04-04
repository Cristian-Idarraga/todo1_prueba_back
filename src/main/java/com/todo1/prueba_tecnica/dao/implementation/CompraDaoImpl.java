package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.CompraDao;
import com.todo1.prueba_tecnica.dto.Compra;
import com.todo1.prueba_tecnica.mapper.CompraMapper;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository public class CompraDaoImpl implements CompraDao {

  private static final String SELECTALL = "SELECT * FROM compra";
  private static final String SELECTBYID = SELECTALL  + " WHERE cdcompra = ?";
  private static final String UPDATE = "UPDATE compra SET cdcliente=?,comentario=?,medio_pago=?,estado=?,total=?, fecha_modificacion= NOW() WHERE cdcompra = ?";
  private static final String INSERT = "INSERT INTO compra(cdcliente, comentario, medio_pago, estado, total, fecha_creacion) VALUES(?, ?, ?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM compra WHERE cdcompra = ?";

  JdbcTemplate jdbcTemplate;

  public CompraDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<Compra> getAll() {
    return jdbcTemplate.query(SELECTALL, new CompraMapper());
  }

  @Override
  public Compra getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new CompraMapper(), id);
  }

  @Override
  public Compra update(Compra entity) {
    jdbcTemplate.update(UPDATE, entity.getCdCliente(), entity.getComentario(), entity.getMedioPago(), entity.getEstado(),
        entity.getTotal(), entity.getCdCompra());
    return entity;
  }

  @Override
  public Compra insert(Compra entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cdcompra"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getCdCliente(), entity.getComentario(),
          entity.getMedioPago(), entity.getEstado(), entity.getTotal()
      });
      return ps;
    }, keyHolder);
    entity.setCdCompra(keyHolder.getKey().longValue());
    return entity;
  }

  @Override
  public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }
}
