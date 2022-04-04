package com.todo1.prueba_tecnica.service.implementation;

import com.todo1.prueba_tecnica.dao.CompraDao;
import com.todo1.prueba_tecnica.dao.CompraProductoDao;
import com.todo1.prueba_tecnica.dao.ProductoDao;
import com.todo1.prueba_tecnica.dao.UsuarioDao;
import com.todo1.prueba_tecnica.dto.Compra;
import com.todo1.prueba_tecnica.dto.CompraProducto;
import com.todo1.prueba_tecnica.dto.Venta;
import com.todo1.prueba_tecnica.service.VentaService;
import com.todo1.prueba_tecnica.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VentaServiceImpl implements VentaService {
  private final ProductoDao productoDao;
  private final CompraDao compraDao;
  private final CompraProductoDao compraProductoDao;
  private final UsuarioDao usuarioDao;
  private final SecurityUtil securityUtil;

  public VentaServiceImpl(ProductoDao productoDao, CompraDao compraDao, CompraProductoDao compraProductoDao, UsuarioDao usuarioDao,
      SecurityUtil securityUtil) {
    this.productoDao = productoDao;
    this.compraDao = compraDao;
    this.compraProductoDao = compraProductoDao;
    this.usuarioDao = usuarioDao;
    this.securityUtil = securityUtil;
  }

  @Override public void vender(Venta venta) throws Exception {
    Compra compra = new Compra();
    Double valorTotal = 0.0;
    for(var producto : venta.getProducto()){
      var findPrecio = productoDao.getById(producto.getCdProducto());
      valorTotal += findPrecio.getPrecio();
      findPrecio.setCantidadStock(findPrecio.getCantidadStock() - 1);
      if(findPrecio.getCantidadStock() < 0){
        throw new Exception(String.format("El producto %s producto ya no está disponible", producto.getNombreProducto()));
      }
      productoDao.update(findPrecio);
    }
    var usuario = usuarioDao.getByUsername(securityUtil.encriptar(SecurityUtil.getUser()));
    compra.setCdCliente(usuario.getCdUsuario());
    compra.setTotal(valorTotal);
    compraDao.insert(compra);
    for(var producto : venta.getProducto()){
      CompraProducto compraProducto = new CompraProducto();
      compraProducto.setCdCompra(compra.getCdCompra());
      compraProducto.setCantidad(1);
      compraProducto.setCdProducto(producto.getCdProducto());
      compraProductoDao.insert(compraProducto);
    }

  }
}
