package com.renanloureiro.cursos.cursos_catalog.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanloureiro.cursos.cursos_catalog.entities.ActiveStatus;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;
import com.renanloureiro.cursos.cursos_catalog.repositories.CoursesRepository;

@Service
public class ListCoursesUseCase {
  
  @Autowired
  private CoursesRepository coursesRepository;

  public List<Course> execute() {
    return coursesRepository.findAllByActiveStatus(ActiveStatus.ACTIVE);
  }
}
