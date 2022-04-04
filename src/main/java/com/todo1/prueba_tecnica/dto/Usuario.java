package com.todo1.prueba_tecnica.dto;

import com.todo1.prueba_tecnica.util.Auditoria;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

public class Usuario extends Auditoria implements Serializable {

  private static final long serialVersionUID = 1L;

  private long cdUsuario;
  private String nombres;
  private String apellidos;
  private String celular;
  @Email
  private String correo;
  private String direccion;
  private LocalDate fechaNacimiento;
  private long cdRol;
  private String cdTipo;
  private String documento;
  private String nombreUsuario;
  private String contrasena;

  public long getCdUsuario() {
    return cdUsuario;
  }

  public void setCdUsuario(long cdUsuario) {
    this.cdUsuario = cdUsuario;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public long getCdRol() {
    return cdRol;
  }

  public void setCdRol(long cdRol) {
    this.cdRol = cdRol;
  }

  public String getCdTipo() {
    return cdTipo;
  }

  public void setCdTipo(String cdTipo) {
    this.cdTipo = cdTipo;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }
}
