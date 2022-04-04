package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.Rol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolMapper implements RowMapper<Rol> {
  @Override public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
    Rol rol = new Rol();
    rol.setCdRol(rs.getLong("cdrol"));
    rol.setNombre(rs.getString("nombre"));
    rol.setDescripcion(rs.getString("descripcion"));
    rol.setDataFromRs(rs);
    return rol;
  }
}
