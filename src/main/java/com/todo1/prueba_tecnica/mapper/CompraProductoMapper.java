package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.CompraProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraProductoMapper implements RowMapper<CompraProducto> {
  @Override public CompraProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
    CompraProducto compraProducto = new CompraProducto();
    compraProducto.setCdcompra_producto(rs.getLong("cdcompra_producto"));
    compraProducto.setCdProducto(rs.getLong("cdproducto"));
    compraProducto.setCdCompra(rs.getLong("cdcompra"));
    compraProducto.setCantidad(rs.getInt("cantidad"));
    compraProducto.setTotal(rs.getDouble("total"));
    compraProducto.setDataFromRs(rs);
    return compraProducto;
  }
}
