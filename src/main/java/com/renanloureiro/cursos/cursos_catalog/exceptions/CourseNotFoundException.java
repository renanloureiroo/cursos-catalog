package com.renanloureiro.cursos.cursos_catalog.exceptions;

public class CourseNotFoundException extends RuntimeException {

  public CourseNotFoundException() {
    super("Curso não encontrado");
  }

} 