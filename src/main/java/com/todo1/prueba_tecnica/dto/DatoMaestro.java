package com.todo1.prueba_tecnica.dto;

import com.todo1.prueba_tecnica.util.Auditoria;
import com.todo1.prueba_tecnica.util.MessagesConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DatoMaestro extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdDato;
  private long cdMaestro;
  @NotNull(message = MessagesConstants.MANDATORY_FIELD)
  @Size(max = 20,message = MessagesConstants.MAX_VALIDATION_FIELD+" (20)")
  private String codigo;
  @Size(max = 200,message = MessagesConstants.MAX_VALIDATION_FIELD+" (200)")
  private String descripcion;

  public long getCdDato() {
    return cdDato;
  }

  public void setCdDato(long cdDato) {
    this.cdDato = cdDato;
  }

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
