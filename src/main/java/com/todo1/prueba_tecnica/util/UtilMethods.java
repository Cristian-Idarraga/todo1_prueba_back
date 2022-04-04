package com.todo1.prueba_tecnica.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UtilMethods {



  public static String generateUUID(){
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static LocalDateTime getLocalDateTime(Timestamp time){
    return (time == null)? null : time.toLocalDateTime();
  }

  public static LocalDate getLocalDate(Timestamp time){
    return (time == null)? null : time.toLocalDateTime().toLocalDate();
  }

  public static void setPrepareStatement(PreparedStatement ps, Object[] data) throws SQLException {
    if (ps == null) {
      return;
    }
    int i = 1;
    for (var column : data) {
      if (column instanceof Long) {
        ps.setLong(i++, (long) column);
      } else if (column instanceof Integer) {
        ps.setInt(i++, (int) column);
      } else if (column instanceof String) {
        ps.setString(i++, (String) column);
      } else if (column instanceof Double) {
        ps.setDouble(i++, (double) column);
      } else {
        ps.setObject(i++, column);
      }
    }

  }
}
