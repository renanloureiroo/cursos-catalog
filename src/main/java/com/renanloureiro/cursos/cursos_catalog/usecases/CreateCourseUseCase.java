package com.renanloureiro.cursos.cursos_catalog.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanloureiro.cursos.cursos_catalog.dtos.CreateCourseInputDTO;
import com.renanloureiro.cursos.cursos_catalog.entities.ActiveStatus;
import com.renanloureiro.cursos.cursos_catalog.entities.Category;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;
import com.renanloureiro.cursos.cursos_catalog.exceptions.CategoryNotFoundException;
import com.renanloureiro.cursos.cursos_catalog.repositories.CategoryRepository;
import com.renanloureiro.cursos.cursos_catalog.repositories.CoursesRepository;

@Service
public class CreateCourseUseCase {
  @Autowired
  private CoursesRepository coursesRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public Course execute(CreateCourseInputDTO input) {

    Category category = categoryRepository.findById(UUID.fromString(input.getCategoryId()))
      .orElseThrow(CategoryNotFoundException::new);

    Course course = Course.builder()
      .name(input.getName())
      .category(category)
      .active(ActiveStatus.ACTIVE)
      .build();

    return coursesRepository.save(course);
  }

}
