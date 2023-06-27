# Projeto Java com MySQL e JUnit: Gerenciamento de Usuários e Telefones
Este projeto Java utiliza o banco de dados MySQL e o framework de testes JUnit para criar um sistema de gerenciamento de usuários e telefones. O objetivo é permitir a inserção, listagem, busca, atualização e exclusão de usuários, bem como listar usuários em conjunto com seus respectivos telefones. Além disso, o projeto também inclui a funcionalidade de exclusão em cascata, na qual a exclusão de um usuário resulta na exclusão automática dos telefones associados a ele.

## Recursos Utilizados
### Linguagem de programação: Java
Banco de dados: MySQL
Framework de teste: JUnit
Funcionalidades Implementadas

### 1. Inserir Usuário e Telefone
Permite inserir um novo usuário no sistema, juntamente com um ou mais telefones associados a ele. Os dados do usuário, como nome, sobrenome, e-mail, entre outros, são armazenados no banco de dados MySQL, enquanto os telefones são vinculados ao usuário por meio de uma chave estrangeira.

### 2. Listar Usuários
Recupera e exibe uma lista de todos os usuários cadastrados no sistema. Cada usuário é exibido com seus respectivos dados, como nome, sobrenome, e-mail, e informações de telefone, se disponíveis.

### 3. Buscar Usuário por ID
Permite pesquisar e exibir as informações de um usuário específico com base no seu ID. Essa funcionalidade é útil para obter detalhes precisos de um usuário específico.

### 4. Atualizar Usuário
Permite atualizar as informações de um usuário existente no sistema. É possível modificar os dados do usuário, como nome, sobrenome, e-mail, etc., e essas alterações serão refletidas no banco de dados.

### 5. Deletar Usuário
Remove um usuário específico do sistema com base no seu ID. Ao excluir um usuário, os telefones associados a ele também serão excluídos em cascata, garantindo a consistência dos dados.

### 6. Listar Usuários com Telefones (INNER JOIN)
Recupera e exibe uma lista de todos os usuários cadastrados no sistema, juntamente com as informações de telefone associadas a cada usuário. Essa funcionalidade permite visualizar os dados do usuário em conjunto com os números de telefone relacionados.

### 7. Deletar Usuário em Cascata com Telefone
Quando um usuário é excluído do sistema, essa funcionalidade garante que todos os telefones associados a ele também sejam excluídos automaticamente. Isso evita a existência de telefones órfãos no banco de dados.

### Conclusão
Esse projeto Java com MySQL e JUnit oferece um sistema completo de gerenciamento de usuários e telefones. Com suas funcionalidades de inserção, listagem, busca, atualização e exclusão de usuários, juntamente com a capacidade de listar usuários com telefones e excluir usuários em cascata com telefones, ele fornece uma solução robusta e eficiente para o controle dessas informações.
