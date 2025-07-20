package com.renanloureiro.cursos.cursos_catalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.renanloureiro.cursos.cursos_catalog.entities.Category;
import com.renanloureiro.cursos.cursos_catalog.repositories.CategoryRepository;

@Configuration
@Profile("dev") // Só executa em desenvolvimento
public class DataLoader {

    @Autowired
    private CategoryRepository categoryRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            System.out.println("🚀 Iniciando carregamento de dados de teste...");
            System.out.println("📊 Categorias existentes: " + categoryRepository.count());
            
            loadCategories();
            
            System.out.println("📊 Categorias após carregamento: " + categoryRepository.count());
            System.out.println("✅ Dados de teste carregados com sucesso!");
        };
    }

    private void loadCategories() {
        System.out.println("📝 Carregando categorias...");
        
        // Verifica se já existem categorias
        if (categoryRepository.count() > 0) {
            System.out.println("⚠️ Categorias já existem, pulando criação...");
            return;
        }
        
        Category programacao = Category.builder()
                .name("Programação")
                .description("Cursos de programação e desenvolvimento")
                .build();
        categoryRepository.save(programacao);
        System.out.println("✅ Categoria 'Programação' criada");

        Category design = Category.builder()
                .name("Design")
                .description("Cursos de design e UX/UI")
                .build();
        categoryRepository.save(design);
        System.out.println("✅ Categoria 'Design' criada");

        Category marketing = Category.builder()
                .name("Marketing")
                .description("Cursos de marketing digital")
                .build();
        categoryRepository.save(marketing);
        System.out.println("✅ Categoria 'Marketing' criada");

        Category negocios = Category.builder()
                .name("Negócios")
                .description("Cursos de empreendedorismo e gestão")
                .build();
        categoryRepository.save(negocios);
        System.out.println("✅ Categoria 'Negócios' criada");
    }
} 