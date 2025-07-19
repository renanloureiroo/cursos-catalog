package com.renanloureiro.cursos.cursos_catalog.dtos;

import java.util.List;
import java.util.stream.Collectors;

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
@Schema(description = "Resposta com lista de cursos")
public class ListCoursesResponseDTO {
    
    @Schema(description = "Lista de cursos")
    private List<CourseResponseDTO> courses;
    
    public static ListCoursesResponseDTO fromEntity(List<Course> courses) {
        List<CourseResponseDTO> courseDTOs = courses.stream()
                .map(CourseResponseDTO::fromEntity)
                .collect(Collectors.toList());
        
        return ListCoursesResponseDTO.builder()
                .courses(courseDTOs)
                .build();
    }
}
