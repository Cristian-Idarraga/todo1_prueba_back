package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.Maestro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaestroMapper implements RowMapper<Maestro> {
  @Override public Maestro mapRow(ResultSet rs, int rowNum) throws SQLException {
    Maestro maestro = new Maestro();
    maestro.setCdMaestro(rs.getLong("cdmaestro"));
    maestro.setCodigo(rs.getString("codigo"));
    maestro.setDescripcion(rs.getString("descripcion"));
    maestro.setDataFromRs(rs);
    return maestro;
  }
}
