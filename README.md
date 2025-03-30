

# Vendas Online

Este projeto é uma aplicação Java para gerenciar dados de clientes em um sistema de vendas online. Ele utiliza PostgreSQL como banco de dados e Maven para o gerenciamento de dependências.

## 🚀 Estrutura do Projeto
- `src/br/com/feRufato/dao/generic/jdbc/ConnectionFactory.java`: Gerencia conexões com o banco de dados.
- `src/br/com/feRufato/dao/generic/jdbc/dao/ClienteDAO.java`: Contém operações CRUD para a entidade `Cliente`.
- `src/Test/ClienteTest.java`: Testes JUnit para a classe `ClienteDAO`.
- `src/Test/TestConnectionFactory.java`: Testa a conexão com o banco de dados.

## 🛠️ Pré-requisitos
- Java 8 ou superior
- Maven
- PostgreSQL

## 📝 Configuração
1. Clone o repositório:
   ```bash
   git clone https://github.com/FerRufato/vendas_online.git
   cd vendas_online
   ```

2. Configure o banco de dados PostgreSQL:
   - Crie um banco de dados chamado `vendas_online`
   - Ajuste o arquivo `ConnectionFactory.java` com suas credenciais:
     ```java
     private static final String URL = "jdbc:postgresql://localhost:5432/vendas_online";
     private static final String USER = "seu_usuario";
     private static final String PASSWORD = "sua_senha";
     ```

3. Compile o projeto com Maven:
   ```bash
   mvn clean install
   ```

4. Execute os testes:
   ```bash
   mvn test
   ```

## 📜 Funcionalidades
- Cadastro de clientes
- Atualização de clientes
- Exclusão de clientes
- Consulta de clientes

## 🤝 Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir um issue ou enviar um pull request.

## 📝 Licença
Este projeto é licenciado sob a Licença MIT - consulte o arquivo LICENSE para mais detalhes.

---
Feito com 💻 por Fer Rufato

