package com.todo1.prueba_tecnica.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Auditoria {

  private String estado;
  private LocalDateTime fechaCreacion;
  private LocalDateTime fechaModificacion;

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public LocalDateTime getFechaModificacion() {
    return fechaModificacion;
  }

  public void setFechaModificacion(LocalDateTime fechaModificacion) {
    this.fechaModificacion = fechaModificacion;
  }

  @JsonIgnore
  public void setDataFromRs(ResultSet rs) throws SQLException {
    estado = rs.getString("estado");
    fechaCreacion = UtilMethods.getLocalDateTime(rs.getTimestamp("fecha_creacion"));
    fechaModificacion = UtilMethods.getLocalDateTime(rs.getTimestamp("fecha_modificacion"));
  }
}
