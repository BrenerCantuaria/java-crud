# Projeto Java CRUD com Interface JavaFX e Integração com PostgreSQL

Este é um projeto Java que implementa um sistema CRUD (Create, Read, Update, Delete) com uma interface gráfica desenvolvida em JavaFX. O projeto utiliza o PostgreSQL como banco de dados para armazenar os dados e adota o padrão de projeto Singleton para a conexão com o banco de dados.

## Funcionalidades
O projeto possui as seguintes funcionalidades:

* Criação de registros de pessoas: permite criar novos registros de pessoas no banco de dados.
* Criação de registros de empresas: permite criar novos registros de empresas no banco de dados.
* Leitura de registros: exibe os registros existentes no banco de dados.
* Atualização de registros: **ATUALMENTE COM PROBLEMAS, EM BREVE SERÁ RESOLVIDO**. Permite editar os registros existentes no banco de dados.
* Exclusão de registros: permite excluir registros do banco de dados.
## Requisitos
Antes de executar o projeto, certifique-se de ter os seguintes requisitos instalados em seu ambiente de desenvolvimento:

* Java Development Kit (JDK) 20 ou superior
* PostgreSQL
As seguintes tabelas foram criadas dentro do banco de dados PostgreSQL para armazenar os registros:

**Tabela empresa:**
```sql
CREATE TABLE empresa (
    id SERIAL,
    nome VARCHAR(50) NOT NULL,
    cnpj VARCHAR(50) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL
);
``` 
**Tabela pessoa:**
```sql
CREATE TABLE pessoa (
    id SERIAL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL
);
``` 
## Configuração do Banco de Dados
Crie um banco de dados no PostgreSQL para ser utilizado pelo projeto.
Abra o arquivo src/main/java/JDBC/ConnectionSingleton.java e atualize as configurações de conexão com o banco de dados de acordo com suas informações.






## Executando o Projeto
### Para rodar o projeto, siga os seguintes passos:

* Abra o projeto em sua IDE preferida (por exemplo, IntelliJ IDEA).
* Configure a conexão com o banco de dados PostgreSQL no arquivo src/main/java/JDBC/ConnectionSingleton.java, informando as credenciais do seu banco de dados.
* Localize o arquivo src/main/java/com/seu_pacote/Main.java e execute-o, geralmente clicando com o botão direito e selecionando "Run" (Executar).
* A interface gráfica será exibida e você poderá utilizar as funcionalidades CRUD fornecidas, incluindo a adição de pessoas e empresas.
