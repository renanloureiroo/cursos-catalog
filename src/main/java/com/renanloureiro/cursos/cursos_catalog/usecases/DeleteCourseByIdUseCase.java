package com.renanloureiro.cursos.cursos_catalog.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanloureiro.cursos.cursos_catalog.repositories.CoursesRepository;

@Service
public class DeleteCourseByIdUseCase {

  @Autowired
  private CoursesRepository coursesRepository;

  public void execute(UUID id) {
    coursesRepository.deleteById(id);
  }
}
