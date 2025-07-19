package com.renanloureiro.cursos.cursos_catalog.exceptions;

public class InvalidInputException extends RuntimeException {

  public InvalidInputException() {
    super("Dados de entrada inválidos");
  }

} 