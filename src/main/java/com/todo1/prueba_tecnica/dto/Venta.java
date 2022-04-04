package com.todo1.prueba_tecnica.dto;

import java.util.List;

public class Venta {
  private List<Producto> producto;
  private Compra compra;

  public List<Producto> getProducto() {
    return producto;
  }

  public void setProducto(List<Producto> producto) {
    this.producto = producto;
  }

  public Compra getCompra() {
    return compra;
  }

  public void setCompra(Compra compra) {
    this.compra = compra;
  }
}
