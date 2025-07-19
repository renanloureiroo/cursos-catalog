package com.renanloureiro.cursos.cursos_catalog.dtos;

import java.util.UUID;

import com.renanloureiro.cursos.cursos_catalog.entities.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Resposta de dados de um curso")
public class CourseResponseDTO {
    
    @Schema(description = "ID único do curso", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;
    
    @Schema(description = "Nome do curso", example = "Java Básico")
    private String name;
    
    @Schema(description = "Categoria do curso", example = "Programação")
    private String category;
  
    public static CourseResponseDTO fromEntity(Course course) {
        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .category(course.getCategory().getName())
                .build();
    }
} 