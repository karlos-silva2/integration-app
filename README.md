# Integration App

Aplicação backend desenvolvida como parte de desafio técnico com foco em integração entre sistemas externos, normalização de dados e exposição de API interna padronizada.

---

## 🚀 Objetivo

Simular um sistema de integração entre múltiplas fontes externas, realizando:

- Consumo de APIs externas
- Normalização de dados heterogêneos
- Persistência de dados processados
- Exposição de API interna consistente
- Autenticação básica de acesso

---

## 🧱 Arquitetura

O projeto segue arquitetura em camadas:

- Controller → expõe endpoints REST
- Service → regras de negócio e orquestração
- Client → comunicação com APIs externas
- Repository → persistência
- Mapper → normalização de dados

Essa estrutura garante separação de responsabilidades e facilidade de manutenção.

---

## 🔗 Integrações externas

Foram utilizadas duas fontes de dados:

- API pública (ex: JSONPlaceholder)
- API simulada (mock interno)

As respostas possuem formatos distintos e são normalizadas para um modelo único.

---

## 📦 Modelo de dados

Entidade principal:

- id
- name
- email
- status (ACTIVE / INACTIVE)
- source (origem da API)

---

## 🔐 Segurança

A aplicação utiliza Basic Auth com Spring Security.

- Endpoints protegidos exigem autenticação
- Swagger liberado para acesso público

---

## 🔐 Fluxo de autenticação (IMPORTANTE)

⚠️ Antes de testar qualquer endpoint protegido, a aplicação deve estar em execução.

A autenticação é inicializada automaticamente pelo Spring Security no startup.

---

### 📌 Passo obrigatório

Inicie a aplicação:

```bash
mvn spring-boot:run

ou via Docker:

docker-compose up --build

📡 Como testar no Postman

Ir em Authorization
Selecionar:
Basic Auth

Preencher:
Username: user
Password: (pegar token gerado no console da aplicacao)

Escolher método HTTP (GET/POST)

Inserir URL:
POST http://localhost:8080/users/sync


📡 Endpoints
🔄 Sincronização

POST /users/sync

Integra dados das APIs externas, normaliza e persiste no banco.

📄 Listagem de usuários

GET /users

Retorna todos os usuários armazenados.

🔍 Filtro por status

GET /users?status=ACTIVE

Filtra usuários pelo status informado.

📘 Swagger

http://localhost:8080/swagger-ui.html
````
### ⚙️ Tecnologias utilizadas:

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database
- Springdoc OpenAPI (Swagger)
- Resilience4j
- Docker


### 🐳 Execução com Docker
Build do projeto

mvn clean package

Subir aplicação

docker-compose up --build

### ### 🧪 Execução local

mvn clean install

mvn spring-boot:run


### ### 📊 Resiliência

Foi utilizado Resilience4j para adicionar tolerância a falhas nas integrações externas, com retry básico.