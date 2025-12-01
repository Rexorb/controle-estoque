# 🍇 Grapium — Sistema de Controle de Estoque

Sistema **robusto e moderno** para gestão de estoque e movimentações, desenvolvido com **Java Spring Boot** e **Thymeleaf**.

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Tecnologias](https://img.shields.io/badge/Tecnologias-Spring%20Boot%20|%20Thymeleaf%20|%20PostgreSQL-4D78B2)
![Licença](https://img.shields.io/badge/Licença-MIT-green)

---

## 👤 Desenvolvedores

| Nome | Função |
| :--- | :--- |
| **Roberto Henrique dos Santos** | Desenvolvedor Front-end |
| **Ruan Santos** | Desenvolvedor Back-end |

---

## 💻 Tecnologias Envolvidas

O **Grapium** utiliza as seguintes tecnologias em sua arquitetura:

- **Backend:** Java 17+  
- **Framework:** Spring Boot 3  
- **ORM:** Spring Data JPA (Hibernate)  
- **Template Engine:** Thymeleaf  
- **Banco de Dados:** PostgreSQL  
- **Build Tool:** Maven (`mvnw`)

---

## 🚀 Como Executar (Quickstart)

### 🧩 Pré-requisitos

Certifique-se de ter instalado:

1. **Java JDK 17** (ou superior, compatível com Spring Boot 3)  
2. **PostgreSQL** em execução e acessível  

---

### ⚙️ Configuração do Banco de Dados

1. Crie um banco de dados com o nome:  
   ```sql
   CREATE DATABASE grapium_db;
   ```
2. Configure as credenciais no arquivo:  
   ```
   src/main/resources/application.properties
   ```
   ou, se preferir:
   ```
   src/main/resources/application.yml
   ```

---

### ▶️ Executando a Aplicação

Clone o repositório e execute via **Maven Wrapper**:

```bash
git clone https://github.com/Rexorb/controle-estoque.git
cd controle-estoque
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
👉 **http://localhost:8080**

---

## 🌐 Mapeamento de Rotas (Endpoints)

### 🏠 Páginas Gerais e Dashboard

| Método | Rota | Descrição | Status | Acesso |
| :---: | :--- | :--- | :---: | :---: |
| GET | `/` | Redirecionamento para a dashboard principal. | ✅ OK | 🔐 Autenticado |
| GET | `/dashboard` | Página de visão geral do sistema. | ⏳ A fazer | 🔐 Autenticado |
| GET | `/sobre` | Informações sobre o sistema. | ⏳ A fazer | 🌍 Público |

---

### 📦 Módulo de Produtos (CRUD)

Reflete a estrutura em desenvolvimento no **ProdutoController**.

| Método | Rota | Descrição | Status | Acesso |
| :---: | :--- | :--- | :---: | :---: |
| GET | `/produtos` | Lista todos os produtos cadastrados. | ✅ OK | 🔐 Autenticado |
| GET | `/produtos/novo` | Exibe o formulário de cadastro. | ✅ OK | 🔐 Autenticado |
| POST | `/produtos/salvar` | Processa e cadastra um novo produto. | ✅ OK | 🔐 Autenticado |
| GET | `/produtos/editar/{id}` | Exibe o formulário de edição de produto. | ⏳ A fazer | 🔐 Autenticado |
| POST | `/produtos/atualizar/{id}` | Atualiza um produto existente. *(Melhor prática: POST/PUT)* | ⏳ A fazer | 🔐 Autenticado |
| GET | `/produtos/excluir/{id}` | Remove um produto. *(Melhor prática: POST/DELETE)* | ⏳ A fazer | 🔐 Autenticado |

---

### 🔒 Autenticação

| Método | Rota | Descrição | Status | Acesso |
| :---: | :--- | :--- | :---: | :---: |
| GET | `/login` | Página de login padrão. | ⏳ A fazer | 🌍 Público |
| POST | `/login` | Processa as credenciais de login. | ⏳ A fazer | 🌍 Público |
| POST | `/logout` | Encerra a sessão do usuário atual. | ⏳ A fazer | 🔐 Autenticado |

---

### 🛠️ API de Serviços Externos

| Método | Rota | Descrição | Status | Acesso |
| :---: | :--- | :--- | :---: | :---: |
| GET | `/api/cep/{cep}` | Consulta endereço usando a API **ViaCEP**. | ⏳ A fazer | 🔐 Autenticado |

---

## 📜 Licença

Este projeto é licenciado sob a **MIT License** — consulte o arquivo `LICENSE` para mais detalhes.

---

💡 *Grapium é um projeto em evolução contínua, com foco em simplicidade, escalabilidade e produtividade no controle de estoque.*
