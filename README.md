# 🚀 Desafio Técnico Itaú

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Swagger](https://img.shields.io/badge/OpenAPI-Swagger-green)
![Status](https://img.shields.io/badge/Status-Concluído-success)

Uma implementação da API proposta no desafio técnico do Itaú, desenvolvida com foco em boas práticas de desenvolvimento, código limpo, documentação e arquitetura simples e eficiente.

## 📋 Sobre o desafio

O objetivo é construir uma API REST capaz de:

- Receber transações financeiras
- Armazenar os dados em memória
- Remover todas as transações cadastradas
- Calcular estatísticas das transações realizadas nos últimos 60 segundos

A solução segue as especificações definidas pelo desafio original do Itaú, incluindo regras de validação, contratos da API e armazenamento em memória.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Validation
- SpringDoc OpenAPI (Swagger)
- Maven
- SLF4J / Logback

---

## 📌 Endpoints

### Criar Transação

```http
POST /transacao
```

#### Request

```json
{
  "valor": 100.50,
  "dataHora": "2026-05-31T12:00:00Z"
}
```

#### Respostas

| Status | Descrição |
|----------|------------|
| 201 | Transação criada com sucesso |
| 422 | Dados inválidos |

---

### Remover Transações

```http
DELETE /transacao
```

#### Respostas

| Status | Descrição |
|----------|------------|
| 200 | Todas as transações removidas |

---

### Consultar Estatísticas

```http
GET /estatistica
```

#### Response

```json
{
  "count": 3,
  "sum": 350.0,
  "avg": 116.66,
  "min": 50.0,
  "max": 200.0
}
```

---

## ✅ Regras Implementadas

- Validação de campos obrigatórios
- Não permite valores negativos
- Validação de datas futuras
- Armazenamento exclusivamente em memória
- Cálculo das estatísticas considerando apenas os últimos 60 segundos
- Documentação automática da API
- Tratamento centralizado de exceções
- Logging para rastreabilidade das operações

---

## 📖 Documentação da API

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui/index.html
```

A documentação é gerada automaticamente através do OpenAPI/Swagger.

---

## ▶️ Executando o Projeto

### Clone o repositório

```bash
git clone https://github.com/DevLuizEduardo/Desafio-Tecnico-Itau.git
```

### Entre na pasta

```bash
cd Desafio-Tecnico-Itau
```

### Execute a aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

## 🧪 Qualidades da Implementação

- Código orientado a boas práticas
- Uso de Records para DTOs
- Separação clara de responsabilidades
- Validação declarativa com Bean Validation
- Documentação OpenAPI
- Estrutura preparada para evolução futura
- Legibilidade e manutenção como prioridade

---

## 👨‍💻 Autor

**Luiz Eduardo**

Desenvolvedor Back-end Java focado em construção de APIs REST, Spring Boot, arquitetura de software e boas práticas de desenvolvimento.

- GitHub: https://github.com/DevLuizEduardo
