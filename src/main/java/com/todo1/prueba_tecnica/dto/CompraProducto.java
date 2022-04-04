package com.todo1.prueba_tecnica.dto;

import com.todo1.prueba_tecnica.util.Auditoria;

import java.io.Serializable;

public class CompraProducto extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdcompra_producto;
  private long cdCompra;
  private long cdProducto;
  private Integer cantidad;
  private Double total;

  public long getCdcompra_producto() {
    return cdcompra_producto;
  }

  public void setCdcompra_producto(long cdcompra_producto) {
    this.cdcompra_producto = cdcompra_producto;
  }

  public long getCdCompra() {
    return cdCompra;
  }

  public void setCdCompra(long cdCompra) {
    this.cdCompra = cdCompra;
  }

  public long getCdProducto() {
    return cdProducto;
  }

  public void setCdProducto(long cdProducto) {
    this.cdProducto = cdProducto;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }
}
