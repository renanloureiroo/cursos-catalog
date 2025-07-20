package com.renanloureiro.cursos.cursos_catalog.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.renanloureiro.cursos.cursos_catalog.entities.ActiveStatus;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;

@Repository
public interface CoursesRepository extends JpaRepository<Course, UUID> {

  @Query("SELECT c FROM Course c WHERE c.active = :activeStatus")
  List<Course> findAllByActiveStatus(@Param("activeStatus") ActiveStatus activeStatus);
}
