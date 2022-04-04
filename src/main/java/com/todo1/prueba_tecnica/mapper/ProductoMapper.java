package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.Producto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoMapper implements RowMapper<Producto> {

  @Override public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
    Producto producto = new Producto();
    producto.setCdProducto(rs.getLong("cdproducto"));
    producto.setNombreProducto(rs.getString("nombre"));
    producto.setCdCategoria(rs.getString("cdcategoria"));
    producto.setPrecio(rs.getDouble("precio"));
    producto.setCantidadStock(rs.getInt("cantidad_stock"));
    producto.setDataFromRs(rs);
    return producto;
  }
}
