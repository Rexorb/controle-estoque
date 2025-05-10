# controle-estoque
Sistema de controle de estoque feito com Java Springboot e Thymeleaf.
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)


## 🚀 Quickstart
git clone https://github.com/Rexorb/controle-estoque.git
cd controle-estoque
Terminal: Bash -> ./mvnw spring-boot:run

Documentação de Rotas:
## 🌐 Rotas da Aplicação

### 🔒 Autenticação
| Método | Rota       | Descrição                          | Acesso       |
|--------|------------|------------------------------------|--------------|
| `GET`  | `/login`   | Página de login                   | Público      |
| `POST` | `/login`   | Processa o login                  | Público      |
| `POST` | `/logout`  | Realiza logout                    | Autenticado  |

### 📦 Produtos
| Método | Rota              | Descrição                          | Acesso       |
|--------|-------------------|------------------------------------|--------------|
| `GET`  | `/produtos`       | Lista todos os produtos           | Autenticado  |
| `GET`  | `/produtos/novo`  | Formulário de novo produto        | Autenticado  |
| `POST` | `/produtos`       | Cadastra novo produto             | Autenticado  |
| `GET`  | `/produtos/{id}`  | Detalhes de um produto específico | Autenticado  |
| `GET`  | `/produtos/editar/{id}` | Formulário de edição        | Autenticado  |
| `PUT`  | `/produtos/{id}`  | Atualiza um produto               | Autenticado  |
| `DELETE`| `/produtos/{id}`  | Remove um produto                 | Autenticado  |

### 📊 Relatórios
| Método | Rota                     | Descrição                          | Acesso       |
|--------|--------------------------|------------------------------------|--------------|
| `GET`  | `/relatorios/estoque`    | Relatório de níveis de estoque    | Autenticado  |
| `GET`  | `/relatorios/movimentacoes` | Histórico de movimentações     | Autenticado  |

### 🛠️ API Externa (ViaCEP)
| Método | Rota                   | Descrição                          | Acesso       |
|--------|------------------------|------------------------------------|--------------|
| `GET`  | `/api/cep/{cep}`       | Consulta endereço por CEP         | Autenticado  |

### 🏠 Páginas Gerais
| Método | Rota       | Descrição                          | Acesso       |
|--------|------------|------------------------------------|--------------|
| `GET`  | `/`        | Dashboard inicial                 | Autenticado  |
| `GET`  | `/sobre`   | Informações sobre o sistema       | Público      |
