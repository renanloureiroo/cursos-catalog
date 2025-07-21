# 📚 Catálogo de Cursos

Uma API REST completa para gerenciamento de catálogo de cursos, desenvolvida com Spring Boot 3.5.3 e Java 21. Este projeto foi criado como parte do desafio da trilha de Java da Rocketseat.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.3** - Framework para desenvolvimento de aplicações Java
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL 16** - Banco de dados relacional
- **Flyway** - Migração de banco de dados
- **Lombok** - Redução de código boilerplate
- **SpringDoc OpenAPI** - Documentação da API
- **Docker Compose** - Containerização do banco de dados
- **Maven** - Gerenciamento de dependências

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- Docker e Docker Compose
- PostgreSQL 16 (opcional, se não usar Docker)

## 🛠️ Configuração do Ambiente

### 1. Clone o repositório

```bash
git clone https://github.com/renanloureiroo/cursos-catalog.git
cd cursos-catalog
```

### 2. Inicie o banco de dados com Docker

```bash
docker-compose up -d
```

### 3. Execute as migrações do Flyway

```bash
mvn flyway:migrate
```

### 4. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📖 Documentação da API

### Swagger UI

Acesse a documentação interativa da API em:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

### Endpoints Disponíveis

#### Cursos (`/cursos`)

| Método   | Endpoint       | Descrição                             |
| -------- | -------------- | ------------------------------------- |
| `POST`   | `/cursos`      | Criar um novo curso                   |
| `GET`    | `/cursos`      | Listar todos os cursos                |
| `PUT`    | `/cursos/{id}` | Atualizar um curso específico         |
| `DELETE` | `/cursos/{id}` | Deletar um curso específico           |
| `PATCH`  | `/cursos/{id}` | Alterar status ativo/inativo do curso |

#### Categorias (`/categorias`)

| Método | Endpoint      | Descrição                  |
| ------ | ------------- | -------------------------- |
| `GET`  | `/categorias` | Listar todas as categorias |

### Exemplos de Uso

#### Criar um curso

```bash
curl -X POST http://localhost:8080/cursos \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Java Básico",
    "categoryId": "123e4567-e89b-12d3-a456-426614174000"
  }'
```

#### Listar cursos

```bash
curl -X GET http://localhost:8080/cursos
```

#### Atualizar um curso

```bash
curl -X PUT http://localhost:8080/cursos/123e4567-e89b-12d3-a456-426614174000 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Java Avançado",
    "categoryId": "123e4567-e89b-12d3-a456-426614174000"
  }'
```

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas com padrão MVC e separação de responsabilidades:

```
src/main/java/com/renanloureiro/cursos/cursos_catalog/
├── config/           # Configurações da aplicação
├── controllers/      # Controladores REST (camada de apresentação)
├── dtos/            # Data Transfer Objects (objetos de transferência)
├── entities/         # Entidades JPA (modelo de domínio)
├── exceptions/       # Tratamento de exceções
├── repositories/     # Repositórios de dados (camada de acesso a dados)
├── usecases/        # Casos de uso (camada de negócio)
└── docs/            # Documentação Swagger
```

### Fluxo da Aplicação

1. **Controllers** - Recebem requisições HTTP e delegam para UseCases
2. **UseCases** - Contêm a lógica de negócio e orquestram as operações
3. **Repositories** - Acesso aos dados através do Spring Data JPA
4. **Entities** - Modelo de domínio com anotações JPA
5. **DTOs** - Objetos para transferência de dados entre camadas

### Estrutura de Dados

#### Entidade Course

- `id` (UUID): Identificador único
- `name` (String): Nome do curso
- `category` (Category): Categoria do curso
- `active` (ActiveStatus): Status ativo/inativo
- `createdAt` (LocalDateTime): Data de criação
- `updatedAt` (LocalDateTime): Data de atualização

#### Entidade Category

- `id` (UUID): Identificador único
- `name` (String): Nome da categoria
- `description` (String): Descrição da categoria
- `createdAt` (LocalDateTime): Data de criação
- `updatedAt` (LocalDateTime): Data de atualização

## 🧪 Testes

Para executar os testes:

```bash
mvn test
```

## 🐳 Docker

### Executar apenas o banco de dados

```bash
docker-compose up -d
```

### Parar o banco de dados

```bash
docker-compose down
```

### Remover volumes (apaga todos os dados)

```bash
docker-compose down -v
```

## 📝 Migrações

O projeto utiliza Flyway para gerenciar migrações do banco de dados. As migrações estão localizadas em `src/main/resources/db/migration/`.

### Executar migrações

```bash
mvn flyway:migrate
```

### Verificar status das migrações

```bash
mvn flyway:info
```

## 📄 Licença

Este projeto foi desenvolvido como parte do desafio da trilha de Java da Rocketseat.

## 👨‍💻 Autor

**Renan Loureiro**

- GitHub: [@renanloureiro](https://github.com/renanloureiro)
