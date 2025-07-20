package com.renanloureiro.cursos.cursos_catalog.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "courses")
@Schema(description = "Entidade que representa um curso")
public class Course {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Schema(description = "ID único do curso", example = "123e4567-e89b-12d3-a456-426614174000")
  private UUID id;

  @Column(name = "name", nullable = false)
  @Schema(description = "Nome do curso", example = "Java Básico")
  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "category_id", nullable = false)
  @Schema(description = "Categoria do curso")
  private Category category;

  @Enumerated(EnumType.STRING)
  @Column(name = "active", nullable = false)
  @Schema(description = "Status de ativação do curso", example = "ACTIVE")
  private ActiveStatus active;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false)
  @Schema(description = "Data de criação do curso")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  @Schema(description = "Data da última atualização do curso")
  private LocalDateTime updatedAt;
}
