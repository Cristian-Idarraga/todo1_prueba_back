package com.todo1.prueba_tecnica.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import com.todo1.prueba_tecnica.util.Auditoria;
import com.todo1.prueba_tecnica.util.MessagesConstants;

public class Producto extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdProducto;
  private String cdCategoria;
  @NotNull(message = MessagesConstants.MANDATORY_FIELD)
  @Size(max = 100, message = MessagesConstants.MAX_VALIDATION_FIELD + " (100)")
  private String nombreProducto;
  private Double precio;
  private Integer cantidadStock;

  public long getCdProducto() {
    return cdProducto;
  }

  public void setCdProducto(long cdProducto) {
    this.cdProducto = cdProducto;
  }

  public String getCdCategoria() {
    return cdCategoria;
  }

  public void setCdCategoria(String cdCategoria) {
    this.cdCategoria = cdCategoria;
  }

  public String getNombreProducto() {
    return nombreProducto;
  }

  public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public Integer getCantidadStock() {
    return cantidadStock;
  }

  public void setCantidadStock(Integer cantidadStock) {
    this.cantidadStock = cantidadStock;
  }
}
