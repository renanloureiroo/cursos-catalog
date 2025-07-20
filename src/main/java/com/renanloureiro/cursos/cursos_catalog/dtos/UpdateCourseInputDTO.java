package com.renanloureiro.cursos.cursos_catalog.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseInputDTO {
  @NotBlank
  private String name;

  @NotBlank
  private UUID categoryId;
}
