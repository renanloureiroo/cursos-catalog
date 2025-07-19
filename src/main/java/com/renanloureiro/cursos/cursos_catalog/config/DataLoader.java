package com.renanloureiro.cursos.cursos_catalog.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.renanloureiro.cursos.cursos_catalog.entities.ActiveStatus;
import com.renanloureiro.cursos.cursos_catalog.entities.Category;
import com.renanloureiro.cursos.cursos_catalog.entities.Course;
import com.renanloureiro.cursos.cursos_catalog.repositories.CategoryRepository;
import com.renanloureiro.cursos.cursos_catalog.repositories.CoursesRepository;

@Configuration
@Profile("dev") // Só executa em desenvolvimento
public class DataLoader {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // Só carrega dados se não existirem
            if (categoryRepository.count() == 0) {
                loadCategories();
                loadCourses();
                System.out.println("✅ Dados de teste carregados com sucesso!");
            }
        };
    }

    private void loadCategories() {
        Category programacao = Category.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"))
                .name("Programação")
                .description("Cursos de programação e desenvolvimento")
                .build();

        Category design = Category.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440002"))
                .name("Design")
                .description("Cursos de design e UX/UI")
                .build();

        Category marketing = Category.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440003"))
                .name("Marketing")
                .description("Cursos de marketing digital")
                .build();

        Category negocios = Category.builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440004"))
                .name("Negócios")
                .description("Cursos de empreendedorismo e gestão")
                .build();

        categoryRepository.save(programacao);
        categoryRepository.save(design);
        categoryRepository.save(marketing);
        categoryRepository.save(negocios);
    }

    private void loadCourses() {
        Course javaBasico = Course.builder()
                .id(UUID.fromString("660e8400-e29b-41d4-a716-446655440001"))
                .name("Java Básico")
                .category(categoryRepository.findById(UUID.fromString("550e8400-e29b-41d4-a716-446655440001")).get())
                .active(ActiveStatus.ACTIVE)
                .build();

        Course springBoot = Course.builder()
                .id(UUID.fromString("660e8400-e29b-41d4-a716-446655440002"))
                .name("Spring Boot")
                .category(categoryRepository.findById(UUID.fromString("550e8400-e29b-41d4-a716-446655440001")).get())
                .active(ActiveStatus.ACTIVE)
                .build();

        Course designInterfaces = Course.builder()
                .id(UUID.fromString("660e8400-e29b-41d4-a716-446655440003"))
                .name("Design de Interfaces")
                .category(categoryRepository.findById(UUID.fromString("550e8400-e29b-41d4-a716-446655440002")).get())
                .active(ActiveStatus.ACTIVE)
                .build();

        coursesRepository.save(javaBasico);
        coursesRepository.save(springBoot);
        coursesRepository.save(designInterfaces);
    }
} 