package com.todo1.prueba_tecnica.dao.implementation;

import com.todo1.prueba_tecnica.dao.ProductoDao;
import com.todo1.prueba_tecnica.dto.Producto;
import com.todo1.prueba_tecnica.mapper.ProductoMapper;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ProductoDaoImpl implements ProductoDao {

  private static final String SELECTALL = "SELECT * FROM producto";
  private static final String SELECTBYID = SELECTALL  + " WHERE cdproducto = ?";
  private static final String UPDATE = "UPDATE producto SET nombre=?,cdcategoria=?,estado=?,precio=?,cantidad_stock=?,fecha_modificacion=NOW() WHERE cdproducto=?";
  private static final String INSERT = "INSERT INTO producto(nombre, cdcategoria, estado, precio, cantidad_stock, fecha_creacion) VALUES(?, ?, ?, ?, ?, NOW())";
  private static final String DELETE = "DELETE FROM producto WHERE cdproducto = ?";

  JdbcTemplate jdbcTemplate;

  public ProductoDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<Producto> getAll() {
    return jdbcTemplate.query(SELECTALL, new ProductoMapper());
  }

  @Override
  public Producto getById(long id) {
    return jdbcTemplate.queryForObject(SELECTBYID, new ProductoMapper(), id);
  }

  @Override
  public Producto update(Producto entity) {
    jdbcTemplate.update(UPDATE, entity.getNombreProducto(), entity.getCdCategoria(), entity.getEstado(), entity.getPrecio(),
        entity.getCantidadStock(), entity.getCdProducto());
    return entity;
  }

  @Override
  public Producto insert(Producto entity) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection
          .prepareStatement(INSERT, new String[]{"cdproducto"});
      UtilMethods.setPrepareStatement(ps, new Object[] { entity.getNombreProducto(), entity.getCdCategoria(),
          entity.getEstado(), entity.getPrecio(), entity.getCantidadStock()
      });
      return ps;
    }, keyHolder);
    entity.setCdProducto(keyHolder.getKey().longValue());
    return entity;
  }

  @Override
  public Boolean delete(long id) {
    return jdbcTemplate.update(DELETE, id) > 0;
  }
}
