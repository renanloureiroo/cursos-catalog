package com.renanloureiro.cursos.cursos_catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renanloureiro.cursos.cursos_catalog.dtos.CreateCourseInputDTO;
import com.renanloureiro.cursos.cursos_catalog.dtos.ListCoursesResponseDTO;
import com.renanloureiro.cursos.cursos_catalog.docs.CoursesControllerSwaggerDocs;
import com.renanloureiro.cursos.cursos_catalog.dtos.CourseResponseDTO;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;
import com.renanloureiro.cursos.cursos_catalog.usecases.CreateCourseUseCase;
import com.renanloureiro.cursos.cursos_catalog.usecases.ListCoursesUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CoursesController implements CoursesControllerSwaggerDocs {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private ListCoursesUseCase listCoursesUseCase;
  
  @PostMapping()
  public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CreateCourseInputDTO input) {
    Course course = createCourseUseCase.execute(input);
    CourseResponseDTO response = CourseResponseDTO.fromEntity(course);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping()
  public ResponseEntity<ListCoursesResponseDTO> listCourses() {
    List<Course> courses = listCoursesUseCase.execute();
    ListCoursesResponseDTO response = ListCoursesResponseDTO.fromEntity(courses);
    return ResponseEntity.ok(response);
  }

}
