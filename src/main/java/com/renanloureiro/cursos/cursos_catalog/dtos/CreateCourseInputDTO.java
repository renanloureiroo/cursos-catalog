package com.renanloureiro.cursos.cursos_catalog.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Dados para criação de um novo curso")
public class CreateCourseInputDTO {
  
  @NotBlank
  @Schema(description = "Nome do curso", example = "Java Básico")
  private String name;

  @NotBlank
  @Schema(description = "ID da categoria do curso", example = "123e4567-e89b-12d3-a456-426614174000")
  private String categoryId;
}
