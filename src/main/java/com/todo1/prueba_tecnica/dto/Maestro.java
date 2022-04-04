package com.todo1.prueba_tecnica.dto;

import com.todo1.prueba_tecnica.util.Auditoria;
import com.todo1.prueba_tecnica.util.MessagesConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Maestro extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdMaestro;
  @NotNull(message = MessagesConstants.MANDATORY_FIELD)
  @Size(max = 20,message = MessagesConstants.MAX_VALIDATION_FIELD+" (15)")
  private String codigo;
  @Size(max = 120,message = MessagesConstants.MAX_VALIDATION_FIELD+" (120)")
  private String descripcion;

  public long getCdMaestro() {
    return cdMaestro;
  }

  public void setCdMaestro(long cdMaestro) {
    this.cdMaestro = cdMaestro;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
