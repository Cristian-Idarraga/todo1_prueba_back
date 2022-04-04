package com.todo1.prueba_tecnica.dto;

import com.todo1.prueba_tecnica.util.Auditoria;

import java.io.Serializable;

public class Compra extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdCompra;
  private long cdCliente;
  private String medioPago;
  private String comentario;
  private Double total;

  public long getCdCompra() {
    return cdCompra;
  }

  public void setCdCompra(long cdCompra) {
    this.cdCompra = cdCompra;
  }

  public long getCdCliente() {
    return cdCliente;
  }

  public void setCdCliente(long cdCliente) {
    this.cdCliente = cdCliente;
  }

  public String getMedioPago() {
    return medioPago;
  }

  public void setMedioPago(String medioPago) {
    this.medioPago = medioPago;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }
}
