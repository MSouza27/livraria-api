# Livraria de Livros - API REST

Este é um projeto de uma API RESTful desenvolvida em **Spring Boot** para gerenciamento de livros em uma livraria. A API permite realizar operações CRUD (criar, ler, atualizar e deletar) sobre livros, com funcionalidades de paginação para listagem.

## Funcionalidades

- **Cadastrar Livro**: Permite adicionar novos livros ao sistema.
- **Listar Livros**: Exibe os livros cadastrados com paginação.
- **Atualizar Livro**: Permite a atualização de informações de um livro existente.
- **Deletar Livro**: Permite a remoção de um livro do sistema.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento da API REST.
- **Spring Data JPA**: Para interação com o banco de dados, utilizando o ORM (Object Relational Mapping).
- **MySQL**: Banco de dados utilizado para armazenar as informações dos livros.
- **Hibernate**: Utilizado para gerenciar as transações JPA.
- **Jakarta Validation**: Para validação dos dados recebidos nas requisições.

## Estrutura do Projeto

O projeto é dividido em três camadas principais:

- **Model**: Representa os dados da aplicação.
- **Repository**: Realiza a interação com o banco de dados.
- **Service**: Contém a lógica de negócios.
- **Controller**: Expõe as APIs para interagir com o sistema.

## Requisitos

Antes de rodar a aplicação, você precisa ter os seguintes componentes instalados:

- **Java 17+**
- **Maven 3.8+**
- **MySQL 5.7+**

## Configuração do Banco de Dados

Configure o banco de dados no arquivo `application.properties`:

```properties
# Configurações do banco de dados MySQL
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_livros
spring.datasource.username=*****
spring.datasource.password=*****
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configurações de JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Desabilitar o Flyway
spring.flyway.enabled=false
