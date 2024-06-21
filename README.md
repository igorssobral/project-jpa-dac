# CRUD Curso e Instituição Back-end

Projeto desenvolvido na disciplina de Desenvolvimento de Aplicações Corporativas utilizando JPA e SpringBoot com o padrão MVC (Model, View, Controller).

## Descrição do Projeto

Este projeto consiste em um desafio onde escolhemos duas entidades, as mapeamos utilizando Hibernate e desenvolvemos um CRUD para elas tanto no Back-end quanto no Front-end. O objetivo é cadastrar cursos em uma instituição. Este desafio faz parte da disciplina de DAC (Desenvolvimento de Aplicações Corporativas), onde deveríamos escolher duas entidades relacionadas e criar um CRUD para ambas.

### Entidades Escolhidas

- **Curso**
- **Instituição**

## 🔨 Tecnologias Utilizadas

![Spring](https://skillicons.dev/icons?i=spring)
![Java](https://skillicons.dev/icons?i=java)
![Hibernate](https://skillicons.dev/icons?i=hibernate)

## 📊 Banco de Dados Utilizado

![PostgreSQL](https://skillicons.dev/icons?i=postgres)

## Como Executar o Projeto

1. **Clone o repositório:**

   ```sh
   git clone https://github.com/igorssobral/project-jpa-dac.git
   cd project-jpa-dac
   
2. **Configure o banco de dados:**

 - Certifique-se de ter o PostgreSQL instalado e rodando.
 - Crie um banco de dados para o projeto.
 - Atualize o application.properties com as configurações do seu banco de dados:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

3. **Compile e execute o projeto:**

   ```sh
   ./mvnw spring-boot:run

## Endpoints da API

### Curso

- **GET /cursos**: Lista todos os cursos.
- **GET /cursos/{id}**: Busca um curso pelo ID.
- **POST /cursos**: Cria um novo curso.
- **PUT /cursos/{id}**: Atualiza um curso existente.
- **DELETE /cursos/{id}**: Deleta um curso.

### Instituição

- **GET /instituicoes**: Lista todas as instituições.
- **GET /instituicoes/{id}**: Busca uma instituição pelo ID.
- **POST /instituicoes**: Cria uma nova instituição.
- **PUT /instituicoes/{id}**: Atualiza uma instituição existente.
- **DELETE /instituicoes/{id}**: Deleta uma instituição.

