# AulaMobile_CRUD
Aplicativo Mobile CRUD com Firebase

1. Objetivo do Projeto:

O projeto consiste em desenvolver um aplicativo Android que permite realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) em uma coleção de produtos utilizando o Firebase Firestore como banco de dados. O aplicativo tem como foco facilitar a gestão de produtos, permitindo que os usuários adicionem, busquem, atualizem e removam produtos por meio de uma interface simples.

2. Tecnologias Utilizadas:

• Android SDK: Para o desenvolvimento do aplicativo.

• Firebase Firestore: Para armazenamento e gerenciamento de dados.

• Java: Linguagem de programação utilizada para implementar a lógica do aplicativo.

• Android Studio: Ambiente de desenvolvimento integrado (IDE) usado para construir o aplicativo.

3. Funcionalidades Implementadas

O aplicativo possui as seguintes funcionalidades:

• Adicionar Produto: Permite ao usuário inserir um código e um valor para um novo produto. Os dados são salvos no Firestore.

• Buscar Produto: O usuário pode buscar um produto pelo código. Se encontrado, o valor é exibido e pode ser editado.

• Atualizar Produto: O usuário pode atualizar o valor de um produto existente, identificando-o pelo código.

• Deletar Produto: Permite a exclusão de um produto a partir do código fornecido.

4. Estrutura do Código

O código está organizado da seguinte maneira:

• Classe MainActivity: Contém a lógica principal do aplicativo, gerenciando a interface do usuário e interações com o Firestore.

Métodos:

• addProduct(): Adiciona um novo produto ao Firestore.
  
• searchProduct(): Busca um produto específico pelo código.
  
• updateProduct(): Atualiza as informações de um produto.
  
• deleteProduct(): Remove um produto do Firestore.
  
• showMessage(String message): Exibe mensagens de feedback para o usuário.

5. Tratamento de Erros

O aplicativo inclui tratamento de erros com mensagens claras para o usuário, tanto em casos de sucesso quanto de falha. O uso de Log permite que os desenvolvedores depurem problemas durante o desenvolvimento e testes.

6. Interface do Usuário

A interface é composta por:

• Campos de entrada (EditText) para código e valor do produto.

• Botões (Button) para cada operação (Adicionar, Atualizar, Deletar, Buscar).

• Um TextView para mostrar resultados ou mensagens.

7. Considerações Finais

O aplicativo fornece uma solução prática para gerenciar produtos de forma eficiente. A utilização do Firebase Firestore garante que as operações sejam realizadas de forma rápida e segura. Sugestões para futuras melhorias incluem:

• Implementar autenticação de usuários para segurança dos dados.

• Adicionar funcionalidades de listagem e filtragem de produtos.

• Melhorar a interface com um design mais intuitivo.

• Este projeto representa uma base sólida para um sistema de gerenciamento de produtos e pode ser expandido conforme necessário.
