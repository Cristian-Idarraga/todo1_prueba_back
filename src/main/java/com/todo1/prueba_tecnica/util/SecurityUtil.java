package com.todo1.prueba_tecnica.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@Component
public class SecurityUtil {

  @Value("${spring.key}")
  private String clave;

  private SecretKeySpec crearClave() throws UnsupportedEncodingException, NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchAlgorithmException {
    byte[] claveEncriptacion = clave.getBytes(StandardCharsets.UTF_8);
    MessageDigest sha = MessageDigest.getInstance("SHA-1");
    claveEncriptacion = sha.digest(claveEncriptacion);
    claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
    return new SecretKeySpec(claveEncriptacion, "AES");
  }

  public String encriptar(String datos) throws Exception {
    try {
      SecretKeySpec secretKey = this.crearClave();

      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);

      byte[] datosEncriptar = datos.getBytes(StandardCharsets.UTF_8);
      byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
      return Base64.getEncoder().encodeToString(bytesEncriptados);
    }catch (Exception e){
      throw new Exception("Error al encriptar");
    }
  }

  public String desencriptar(String datosEncriptados) throws Exception {
      SecretKeySpec secretKey = this.crearClave();

      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);

      byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
      byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
      return new String(datosDesencriptados);
  }

  public static String getUser() {
    if (SecurityContextHolder.getContext().getAuthentication() != null) {
      User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      return currentUser.getUsername();
    }
    return "";
  }
}
