package com.renanloureiro.cursos.cursos_catalog.exceptions;

public class CategoryNotFoundException extends RuntimeException {

  public CategoryNotFoundException() {
    super("Categoria não encontrada");
  }

}
