# Microsserviços com Quarkus, PostgreSQL e Keycloak

Este projeto simples implementa uma arquitetura de microsserviços utilizando **Quarkus**, **PostgreSQL** e **Keycloak**. A aplicação é dividida em três microsserviços: **Customer**, **Product** e **Order**. Cada microsserviço é estruturado em camadas típicas de uma arquitetura de software: `Entity`, `DTO`, `Repository`, `Service` e `Controller`.

## Estrutura do Projeto

- **Customer Service**: Microsserviço que gerencia os clientes.
- **Product Service**: Microsserviço que gerencia os produtos.
- **Order Service**: Microsserviço que gerencia os pedidos e faz a comunicação com os microsserviços de cliente e produto.

### Funcionalidades

- **Customer Service**: 
  - Criar, consultar, alterar e listar clientes.
  
- **Product Service**:
  - Criar, consultar, alterar e listar produtos.
  
- **Order Service**:
  - Criar pedidos, associando clientes e produtos.
  - Permite consultar pedidos existentes.

### Camadas

- **Entity**: Representa os modelos de dados no banco de dados (ex: `Customer`, `Product`, `Order`).
- **DTO**: Objetos de transferência de dados usados para comunicação entre microsserviços e APIs externas.
- **Repository**: Camada responsável pela interação com o banco de dados utilizando Quarkus e JPA.
- **Service**: Camada de lógica de negócios.
- **Controller**: Camada que define os endpoints REST para interação com os microsserviços.

## Requisitos

- **Java 17+**
- **Quarkus**
- **PostgreSQL**
- **Keycloak** para autenticação e autorização.

## Endpoints

**Customer Service**
- GET /customers: Lista todos os clientes.
- GET /customers/{id}: Consulta um cliente por ID.
- POST /customers: Cria um novo cliente.
- PUT /customers/{id}: Atualiza os dados de um cliente.
- DELETE /customers/{id}: Exclui um cliente.
  
**Product Service**
- GET /products: Lista todos os produtos.
- GET /products/{id}: Consulta um produto por ID.
- POST /products: Cria um novo produto.
- PUT /products/{id}: Atualiza os dados de um produto.
- DELETE /products/{id}: Exclui um produto.
  
**Order Service**
- GET /orders: Lista todos os pedidos.
- POST /orders: Cria um novo pedido (necessita de um customerId e productId).
