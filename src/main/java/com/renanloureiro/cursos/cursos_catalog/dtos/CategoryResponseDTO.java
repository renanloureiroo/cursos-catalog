package com.renanloureiro.cursos.cursos_catalog.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.renanloureiro.cursos.cursos_catalog.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Resposta de dados de uma categoria")
public class CategoryResponseDTO {
    
    @Schema(description = "ID único da categoria", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;
    
    @Schema(description = "Nome da categoria", example = "Programação")
    private String name;
    
    @Schema(description = "Descrição da categoria", example = "Cursos de programação e desenvolvimento")
    private String description;
    
    public static CategoryResponseDTO fromEntity(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
} 