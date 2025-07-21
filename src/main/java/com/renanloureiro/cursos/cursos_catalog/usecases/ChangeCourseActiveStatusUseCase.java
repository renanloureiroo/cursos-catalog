package com.renanloureiro.cursos.cursos_catalog.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanloureiro.cursos.cursos_catalog.entities.ActiveStatus;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;
import com.renanloureiro.cursos.cursos_catalog.exceptions.CourseNotFoundException;
import com.renanloureiro.cursos.cursos_catalog.repositories.CoursesRepository;

@Service
public class ChangeCourseActiveStatusUseCase {

  @Autowired
  private CoursesRepository coursesRepository;

  public void execute(UUID id) {
    Course course = coursesRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());
    ActiveStatus newActiveStatus = course.getActive() == ActiveStatus.ACTIVE ? ActiveStatus.INACTIVE
        : ActiveStatus.ACTIVE;
    course.setActive(newActiveStatus);
    coursesRepository.save(course);
  }
}
