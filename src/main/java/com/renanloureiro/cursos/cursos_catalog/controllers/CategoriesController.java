package com.renanloureiro.cursos.cursos_catalog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renanloureiro.cursos.cursos_catalog.docs.CategoriesControllerSwaggerDocs;
import com.renanloureiro.cursos.cursos_catalog.dtos.CategoryResponseDTO;
import com.renanloureiro.cursos.cursos_catalog.entities.Category;
import com.renanloureiro.cursos.cursos_catalog.usecases.ListCategoriesUseCase;

@RestController
@RequestMapping("/categorias")
public class CategoriesController implements CategoriesControllerSwaggerDocs {

  @Autowired
  private ListCategoriesUseCase listCategoriesUseCase;

  @GetMapping
  public ResponseEntity<List<CategoryResponseDTO>> listCategories() {
    List<Category> categories = listCategoriesUseCase.execute();
    List<CategoryResponseDTO> response = categories.stream().map(CategoryResponseDTO::fromEntity)
        .collect(Collectors.toList());
    return ResponseEntity.ok(response);
  }
}
