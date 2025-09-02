# CRUD em Java com JDBC e MySQL

![Java](https://img.shields.io/badge/Language-Java-blue)
![Database](https://img.shields.io/badge/Database-MySQL-orange)

## Descrição do Projeto

Este projeto é uma aplicação de console desenvolvida em Java que demonstra a implementação das quatro operações fundamentais de persistência de dados: **Create (Criar)**, **Read (Ler)**, **Update (Atualizar)** e **Delete (Deletar)**, conhecidas como CRUD.

A aplicação gerencia uma agenda de contatos simples, conectando-se a um banco de dados MySQL através de JDBC puro. O projeto foi estruturado utilizando o padrão de projeto **DAO (Data Access Object)**, que separa as regras de negócio da lógica de acesso a dados, tornando o código mais organizado, modular e de fácil manutenção.

## Funcionalidades

A aplicação permite realizar as seguintes operações em um cadastro de contatos:

-   **Create:** Inserir um novo contato no banco de dados.
-   **Read:** Listar todos os contatos cadastrados.
-   **Update:** Atualizar as informações de um contato existente.
-   **Delete:** Remover um contato do banco de dados pelo seu ID.

## Tecnologias Utilizadas

-   **Linguagem:** Java (JDK 11 ou superior)
-   **Banco de Dados:** MySQL Server 8.0
-   **Conectividade:** JDBC (Java Database Connectivity)
-   **Driver:** MySQL Connector/J
-   **Padrão de Projeto:** DAO (Data Access Object) e Factory (para a conexão com o banco de dados).

## Pré-requisitos

Antes de começar, você precisará ter os seguintes softwares instalados em sua máquina:

-   Java Development Kit (JDK)
-   MySQL Server
-   Uma IDE Java, como Eclipse ou IntelliJ IDEA.

## Como Configurar e Executar o Projeto

Siga os passos abaixo para executar a aplicação localmente.

### 1. Clone o Repositório
```bash
git clone [https://github.com/Diego-deBrito/CRUD-Java.git](https://github.com/Diego-deBrito/CRUD-Java.git)
cd CRUD-Java
```

### 2. Configure o Banco de Dados

1.  **Acesse o seu MySQL Server** através de um cliente de sua preferência (MySQL Workbench, DBeaver, etc.).

2.  **Execute o script SQL** para criar o banco de dados e a tabela necessários. O script está localizado em:
    ```
    /script/agenda.sql
    ```
    Ele criará o banco de dados `agenda` e a tabela `contatos`.

### 3. Configure a Conexão no Código

1.  Abra o arquivo `ConnectionFactory.java` localizado em:
    ```java
    /src/br/com/agenda/factory/ConnectionFactory.java
    ```
2.  **Altere as credenciais de acesso** ao banco de dados para corresponder à sua configuração local. Modifique as constantes `DB_USER` e `DB_PASSWORD`:
    ```java
    // Usuário do banco
    private static final String USERNAME = "seu_usuario_mysql";

    // Senha do banco
    private static final String PASSWORD = "sua_senha_mysql";
    ```

### 4. Configure o Projeto na IDE (Exemplo com Eclipse)

1.  Abra o Eclipse e importe o projeto: `File -> Import -> General -> Existing Projects into Workspace`.
2.  Selecione o diretório onde você clonou o repositório.
3.  **Adicione o Driver JDBC ao Build Path:**
    -   Faça o download do [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
    -   No Eclipse, clique com o botão direito no projeto e vá em `Build Path -> Configure Build Path`.
    -   Na aba `Libraries`, clique em `Classpath` e depois em `Add External JARs...`.
    -   Navegue até o local onde você salvou o arquivo `.jar` do conector e adicione-o ao projeto.

### 5. Execute a Aplicação

1.  Encontre a classe `Main.java` em:
    ```java
    /src/br/com/agenda/aplicacao/Main.java
    ```
2.  Clique com o botão direito no arquivo e selecione `Run As -> Java Application`.
3.  O console da IDE exibirá os resultados das operações CRUD que estão codificadas na classe `Main`.

## Estrutura do Projeto

O código-fonte está organizado da seguinte forma:

-   **`br.com.agenda.aplicacao.Main`**: Classe principal que contém o método `main`. Ela serve como ponto de entrada da aplicação e orquestra as chamadas para as operações de CRUD.

-   **`br.com.agenda.model.Contato`**: A classe de modelo (ou *POJO*) que representa a entidade `Contato`. Ela contém os atributos `id`, `nome`, `idade` e `dataCadastro`.

-   **`br.com.agenda.factory.ConnectionFactory`**: Uma classe que implementa o padrão Factory. Sua única responsabilidade é criar e retornar uma conexão com o banco de dados MySQL, centralizando a configuração.

-   **`br.com.agenda.dao.ContatoDAO`**: A classe que implementa o padrão Data Access Object. Ela contém todos os métodos responsáveis por interagir diretamente com o banco de dados (salvar, ler, atualizar e deletar contatos), abstraindo a lógica SQL do resto da aplicação.
