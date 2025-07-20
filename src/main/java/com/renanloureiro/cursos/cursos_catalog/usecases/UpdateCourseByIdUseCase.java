package com.renanloureiro.cursos.cursos_catalog.usecases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanloureiro.cursos.cursos_catalog.dtos.UpdateCourseInputDTO;
import com.renanloureiro.cursos.cursos_catalog.entities.Category;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;
import com.renanloureiro.cursos.cursos_catalog.exceptions.CategoryNotFoundException;
import com.renanloureiro.cursos.cursos_catalog.exceptions.CourseNotFoundException;
import com.renanloureiro.cursos.cursos_catalog.repositories.CategoryRepository;
import com.renanloureiro.cursos.cursos_catalog.repositories.CoursesRepository;

@Service
public class UpdateCourseByIdUseCase {

  @Autowired
  private CoursesRepository coursesRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public Course execute(UpdateCourseInputDTO input, UUID id) {
    Course course = coursesRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

    Category category = validateCategoryExists(input.getCategoryId());

    course.setName(input.getName());
    course.setCategory(category);
    return coursesRepository.save(course);

  }

  private Category validateCategoryExists(UUID categoryId) {
    Optional<Category> category = categoryRepository.findById(categoryId);
    if (category.isEmpty()) {
      throw new CategoryNotFoundException();
    }
    return category.get();
  }
}
