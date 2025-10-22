# 🍇 Grapium: Sistema de Controle de Estoque
Sistema robusto e moderno para gestão de estoque e movimentações, desenvolvido com a stack Java Spring Boot e Thymeleaf.

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Tecnologias](https://img.shields.io/badge/Tecnologias-Spring%20Boot%20|%20Thymeleaf%20|%20PostgreSQL-4D78B2)
![Licença](https://img.shields.io/badge/Licença-MIT-green)

## 👤 Desenvolvedores
| Nome | Função |
| :--- | :--- |
| **Roberto Henrique dos Santos** | Desenvolvedor Front-end |
| **Ruan Santos** | Desenvolvedor Back-end |

---

## 💻 Tecnologias Envolvidas
O Grapium utiliza as seguintes tecnologias em sua arquitetura:

* **Backend:** Java 17+ (ou superior)
* **Framework:** Spring Boot 3
* **ORM:** Spring Data JPA (Hibernate)
* **Template Engine:** Thymeleaf
* **Banco de Dados:** PostgreSQL
* **Build Tool:** Maven (`.mvnw`)

## 🚀 Como Executar (Quickstart)

### Pré-requisitos
Certifique-se de ter instalado:
1.  **Java JDK 17** (ou versão compatível com Spring Boot 3).
2.  **PostgreSQL** rodando e acessível.

### Configuração do Banco de Dados
1.  Crie um banco de dados com o nome `grapium_db`.
2.  Configure as credenciais de acesso no arquivo `src/main/resources/application.properties` (ou `application.yml`).

### Execução da Aplicação
Clone o repositório e execute a aplicação via Maven Wrapper:

```bash
git clone [https://github.com/Rexorb/controle-estoque.git](https://github.com/Rexorb/controle-estoque.git) 
cd controle-estoque
./mvnw spring-boot:run
