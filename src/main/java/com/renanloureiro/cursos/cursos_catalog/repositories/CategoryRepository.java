package com.renanloureiro.cursos.cursos_catalog.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renanloureiro.cursos.cursos_catalog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Optional<Category> findByName(String name);
}
