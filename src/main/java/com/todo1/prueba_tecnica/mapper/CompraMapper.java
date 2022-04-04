package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.Compra;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraMapper implements RowMapper<Compra> {

  @Override public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
    Compra compra = new Compra();
    compra.setCdCompra(rs.getLong("cdcompra"));
    compra.setCdCliente(rs.getLong("cdcliente"));
    compra.setComentario(rs.getString("comentario"));
    compra.setMedioPago(rs.getString("medio_pago"));
    compra.setTotal(rs.getDouble("total"));
    compra.setDataFromRs(rs);
    return compra;
  }
}
