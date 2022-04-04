package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.DatoMaestro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatoMaestroMapper implements RowMapper<DatoMaestro> {
  @Override public DatoMaestro mapRow(ResultSet rs, int rowNum) throws SQLException {
    DatoMaestro datoMaestro = new DatoMaestro();
    datoMaestro.setCdDato(rs.getLong("cddato"));
    datoMaestro.setCdMaestro(rs.getLong("cdmaestro"));
    datoMaestro.setCodigo(rs.getString("codigo"));
    datoMaestro.setDescripcion(rs.getString("descripcion"));
    datoMaestro.setDataFromRs(rs);
    return datoMaestro;
  }
}
