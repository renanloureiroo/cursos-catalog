package com.renanloureiro.cursos.cursos_catalog.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Resposta de erro padronizada")
public class ErrorResponseDTO {
    
    @Schema(description = "Mensagem de erro", example = "Erro interno do servidor")
    private String message;
    
    @Schema(description = "Código do status HTTP", example = "500")
    private Integer status;
    
    @Schema(description = "Timestamp do erro", example = "2024-01-15T10:30:45.123")
    private LocalDateTime timestamp;
    
    @Schema(description = "Tipo do erro", example = "Internal Server Error")
    private String error;
} 