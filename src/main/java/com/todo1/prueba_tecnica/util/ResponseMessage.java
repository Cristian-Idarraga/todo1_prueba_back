package com.todo1.prueba_tecnica.util;

public class ResponseMessage<T> {
  private int code;
  private String message;
  private T data;

  public ResponseMessage(){
    //Default constructor
  }

  public ResponseMessage(int code, String message, T data){
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public int getCode() {
    return code;
  }
  public void setCodigo(int code) {
    this.code = code;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
}
