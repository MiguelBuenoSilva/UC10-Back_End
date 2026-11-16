# 📚 API Livraria - Back-End (UC10)

API REST desenvolvida em **Java** com **Spring Boot** para gerenciamento de uma livraria, permitindo o cadastro, consulta, filtragem, atualização e exclusão de **Livros**, **Categorias** e **Editoras**.

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

## 📌 Endpoints da API

### 📖 Livros (`/v1/api/livros`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/v1/api/livros` | Cadastra um novo livro |
| `GET` | `/v1/api/livros` | Lista todos os livros cadastrados |
| `GET` | `/v1/api/livros/{id}` | Busca um livro específico por ID |
| `GET` | `/v1/api/livros/?autor={nome}` | Lista livros cujo autor começa com o parâmetro informado |
| `GET` | `/v1/api/livros/?valorInicial={min}&valorFinal={max}` | Lista livros dentro de uma faixa de preço |
| `GET` | `/v1/api/livros/?anoEdicao={ano}` | Lista livros com ano de edição menor que o valor informado |
| `PUT` | `/v1/api/livros` | Atualiza os dados de um livro (enviando o ID no corpo JSON) |
| `DELETE` | `/v1/api/livros/{id}` | Remove um livro pelo ID |

---

### 🏷️ Categorias (`/v1/api/categorias`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/v1/api/categorias` | Cadastra uma nova categoria |
| `GET` | `/v1/api/categorias` | Lista todas as categorias cadastradas |
| `GET` | `/v1/api/categorias/?nome={letra}` | Lista categorias cujo nome começa com o parâmetro informado |
| `GET` | `/v1/api/categorias/{id}` | Busca uma categoria específica por ID |
| `PUT` | `/v1/api/categorias` | Atualiza os dados de uma categoria |
| `DELETE` | `/v1/api/categorias/{id}` | Remove uma categoria pelo ID |

---

### 🏢 Editoras (`/v1/api/editoras`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/v1/api/editoras` | Cadastra uma nova editora |
| `GET` | `/v1/api/editoras` | Lista todas as editoras cadastradas |
| `GET` | `/v1/api/editoras/?nome={prefixo}` | Lista editoras cujo nome começa com o parâmetro informado |
| `GET` | `/v1/api/editoras/{id}` | Consulta uma editora específica por ID |
| `PUT` | `/v1/api/editoras` | Atualiza os dados de uma editora (enviando o ID no corpo JSON) |
| `DELETE` | `/v1/api/editoras/{id}` | Remove uma editora pelo ID |

---

## 👨‍💻 Autor

Desenvolvido por **Miguel Bueno Silva** durante os estudos de desenvolvimento Back-End (UC10).
