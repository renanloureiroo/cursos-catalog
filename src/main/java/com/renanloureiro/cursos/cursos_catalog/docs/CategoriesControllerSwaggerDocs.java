package com.renanloureiro.cursos.cursos_catalog.docs;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.renanloureiro.cursos.cursos_catalog.dtos.CategoryResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Categories", description = "Endpoints para gerenciamento de categorias")
public interface CategoriesControllerSwaggerDocs {

  @Operation(summary = "List all categories")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Categories listed successfully", content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CategoryResponseDTO.class))
      })
  })
  ResponseEntity<List<CategoryResponseDTO>> listCategories();

}
