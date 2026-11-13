# 📚 API Livraria - Back-End (UC10)

API REST desenvolvida em **Java** com **Spring Boot** para gerenciamento de uma livraria, permitindo o cadastro, consulta, atualização e exclusão de **Livros**, **Categorias** e **Editoras**.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot** (Spring Web, Spring Data JPA, Bean Validation)
* **SQLite** (Banco de dados relacional)
* **Hibernate** (Mapeamento Objeto-Relacional - ORM)
* **Maven** (Gerenciador de dependências)
* **Bruno** (Cliente HTTP para testes de rotas da API)

---

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com
```

### 2. Abrir e rodar no IntelliJ IDEA
1. Abra a pasta do projeto no **IntelliJ IDEA**.
2. Aguarde o Maven baixar todas as dependências do arquivo `pom.xml`.
3. Execute a classe principal **`LivrariaApplication.java`**.
4. O servidor iniciará localmente na porta padrão: `http://localhost:8080` *(o banco de dados SQLite e as tabelas serão criados automaticamente)*.

---

## 🧪 Como Testar as Rotas no Bruno

Este repositório já inclui todas as requisições prontas para teste dentro da pasta **`Api-Livraria`**.

1. Abra o aplicativo **Bruno**.
2. No menu superior esquerdo, clique em **Open Collection** (Abrir Coleção).
3. Selecione a pasta **`Api-Livraria`** localizada na raiz deste projeto.
4. Execute as requisições organizadas nas pastas **Categorias**, **Editoras** e **Livros**.

---

## 📌 Principais Endpoints da API

### 📖 Livros (`/livros`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/livros` | Lista todos os livros cadastrados |
| `GET` | `/livros/{id}` | Busca um livro específico por ID |
| `POST` | `/livros` | Cadastra um novo livro |
| `PUT` | `/livros/{id}` | Atualiza os dados de um livro |
| `DELETE` | `/livros/{id}` | Remove um livro pelo ID |

### 🏷️ Categorias (`/categorias`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/categorias` | Lista todas as categorias |
| `GET` | `/categorias/{id}` | Busca uma categoria por ID |
| `POST` | `/categorias` | Cadastra uma nova categoria |
| `PUT` | `/categorias/{id}` | Atualiza uma categoria |
| `DELETE` | `/categorias/{id}` | Remove uma categoria |

### 🏢 Editoras (`/editoras`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/editoras` | Lista todas as editoras |
| `GET` | `/editoras/{id}` | Busca uma editora por ID |
| `POST` | `/editoras` | Cadastra uma nova editora |
| `PUT` | `/editoras/{id}` | Atualiza uma editora |
| `DELETE` | `/editoras/{id}` | Remove uma editora |

---

## 👨‍💻 Autor

Desenvolvido por **Miguel Bueno Silva** durante os estudos de desenvolvimento Back-End (UC10).

