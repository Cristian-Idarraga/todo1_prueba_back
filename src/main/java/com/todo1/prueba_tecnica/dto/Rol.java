package com.todo1.prueba_tecnica.dto;

import com.todo1.prueba_tecnica.util.Auditoria;
import com.todo1.prueba_tecnica.util.MessagesConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Rol extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdRol;
  @NotNull(message = MessagesConstants.MANDATORY_FIELD)
  @Size(max = 150, message = MessagesConstants.MAX_VALIDATION_FIELD + " (150)")
  private String nombre;
  @Size(max = 150, message = MessagesConstants.MAX_VALIDATION_FIELD + " (150)")
  private String descripcion;

  public long getCdRol() {
    return cdRol;
  }

  public void setCdRol(long cdRol) {
    this.cdRol = cdRol;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
