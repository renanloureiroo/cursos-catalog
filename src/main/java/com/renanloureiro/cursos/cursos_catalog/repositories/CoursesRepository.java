package com.renanloureiro.cursos.cursos_catalog.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renanloureiro.cursos.cursos_catalog.entities.ActiveStatus;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;

@Repository
public interface CoursesRepository extends JpaRepository<Course, UUID> {

  List<Course> findAllByActiveStatus(ActiveStatus activeStatus);
}
