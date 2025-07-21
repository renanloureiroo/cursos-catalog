package com.renanloureiro.cursos.cursos_catalog.docs;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.renanloureiro.cursos.cursos_catalog.dtos.CourseResponseDTO;
import com.renanloureiro.cursos.cursos_catalog.dtos.CreateCourseInputDTO;
import com.renanloureiro.cursos.cursos_catalog.dtos.ErrorResponseDTO;
import com.renanloureiro.cursos.cursos_catalog.dtos.ListCoursesResponseDTO;
import com.renanloureiro.cursos.cursos_catalog.dtos.UpdateCourseInputDTO;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cursos", description = "Endpoints para gerenciamento de cursos")
public interface CoursesControllerSwaggerDocs {

  @Operation(summary = "Criar um novo curso", description = "Cria um novo curso no catálogo com nome e categoria")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Curso criado com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CourseResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Dados inválidos ou categoria não encontrada", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class))),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class)))
  })
  ResponseEntity<CourseResponseDTO> createCourse(CreateCourseInputDTO input);

  @Operation(summary = "Listar todos os cursos", description = "Lista todos os cursos disponíveis no catálogo")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Cursos listados com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ListCoursesResponseDTO.class)))
  })
  ResponseEntity<ListCoursesResponseDTO> listCourses();

  @Operation(summary = "Atualizar um curso", description = "Atualiza um curso existente no catálogo")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CourseResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Dados inválidos ou categoria não encontrada", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class))),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class)))
  })
  ResponseEntity<CourseResponseDTO> updateCourse(UUID id, UpdateCourseInputDTO input);

  @Operation(summary = "Deletar um curso", description = "Deleta um curso existente no catálogo")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Curso deletado com sucesso"),
      @ApiResponse(responseCode = "404", description = "Curso não encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class))),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class)))
  })
  ResponseEntity<Object> deleteCourse(UUID id);

  @Operation(summary = "Alterar o status de atividade de um curso", description = "Altera o status de atividade de um curso existente no catálogo")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Status de atividade alterado com sucesso"),
      @ApiResponse(responseCode = "404", description = "Curso não encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class))),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDTO.class)))
  })
  ResponseEntity<Object> patchCourse(UUID id);

}
