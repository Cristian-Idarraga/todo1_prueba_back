package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.CompraProductoDao;
import com.todo1.prueba_tecnica.dto.CompraProducto;
import com.todo1.prueba_tecnica.mapper.CompraProductoMapper;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CompraProductoDaoImpl implements CompraProductoDao {

  private static final String SELECTALL = "SELECT * FROM compra_producto";
  private static final String SELECTBYID = SELECTALL  + " WHERE cdcompra_producto = ?";
  private static final String UPDATE = "UPDATE compra_producto SET cdproducto=?,cdcompra=?,cantidad=?,estado=?,total=?, fecha_modificacion= NOW() WHERE cdcompra_producto = ?";
  private static final String INSERT = "INSERT INTO compra_producto(cdproducto, cdcompra, cantidad, estado, total, fecha_creacion) VALUES(?, ?, ?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM compra_producto WHERE cdcompra_producto = ?";

  JdbcTemplate jdbcTemplate;

  public CompraProductoDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<CompraProducto> getAll() {
    return jdbcTemplate.query(SELECTALL, new CompraProductoMapper());
  }

  @Override
  public CompraProducto getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new CompraProductoMapper(), id);
  }

  @Override
  public CompraProducto update(CompraProducto entity) {
    jdbcTemplate.update(UPDATE, entity.getCdProducto(), entity.getCdCompra(), entity.getCantidad(), entity.getEstado(),
        entity.getTotal(), entity.getCdcompra_producto());
    return entity;
  }

  @Override
  public CompraProducto insert(CompraProducto entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cdcompra_producto"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getCdProducto(), entity.getCdCompra(),
          entity.getCantidad(), entity.getEstado(), entity.getTotal()
      });
      return ps;
    }, keyHolder);
    entity.setCdcompra_producto(keyHolder.getKey().longValue());
    return entity;
  }

  @Override
  public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }
}
