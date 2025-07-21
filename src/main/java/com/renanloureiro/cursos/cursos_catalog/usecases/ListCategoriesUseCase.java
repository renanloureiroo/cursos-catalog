package com.renanloureiro.cursos.cursos_catalog.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.renanloureiro.cursos.cursos_catalog.entities.Category;
import com.renanloureiro.cursos.cursos_catalog.repositories.CategoryRepository;

public class ListCategoriesUseCase {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> execute() {
    return categoryRepository.findAll();

  }
}
