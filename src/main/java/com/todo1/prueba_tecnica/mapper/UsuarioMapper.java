package com.todo1.prueba_tecnica.mapper;

import com.todo1.prueba_tecnica.dto.Usuario;
import com.todo1.prueba_tecnica.util.SecurityUtil;
import com.todo1.prueba_tecnica.util.UtilMethods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {

  private final SecurityUtil securityUtil;

  public UsuarioMapper(SecurityUtil securityUtil){
    this.securityUtil = securityUtil;
  }

  @Override public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
    Usuario usuario = new Usuario();
    usuario.setCdUsuario(rs.getLong("cdusuario"));
    usuario.setNombres(rs.getString("nombres"));
    usuario.setApellidos(rs.getString("apellidos"));
    usuario.setCelular(rs.getString("celular"));
    usuario.setCorreo(rs.getString("correo"));
    usuario.setDireccion(rs.getString("direccion"));
    usuario.setFechaNacimiento(UtilMethods.getLocalDate(rs.getTimestamp("fecha_nacimiento")));
    usuario.setCdRol(rs.getLong("cdrol"));
    usuario.setCdTipo(rs.getString("cdtipo"));
    try {
      usuario.setNombreUsuario(securityUtil.desencriptar(rs.getString("nombre_usuario")));
    } catch (Exception e) {
      e.printStackTrace();
    }
    usuario.setContrasena(rs.getString("contrasena"));
    usuario.setDataFromRs(rs);
    return usuario;
  }
}
