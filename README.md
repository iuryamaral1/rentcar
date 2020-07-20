# rent-cars-api
API Restful para Sistema de usuários de carros.

## Estórias de Usuários

### 01: Usuário deve ser capaz de se cadastrar no sistema com os seguintes atributos:
  
  * Primeiro Nome;
  * Último Nome;
  * Email;
  * Data de Nascimento;
  * Login;
  * Senha;
  * Telefone;
  
### 02: Usuário deve ser capaz de fazer login no sistema utilizando os parâmetros:
  * Login;
  * Senha;
 
### 03: Usuário deve ser capaz de pesquisar por seu login e por outros usuários utilizando os parâmetros:
  
  * Id;

### 04: Sistema deve permitir remoção de usuário utilizando os parâmetros:
  
  * Id;

### 05: Usuário deve ser capaz de atualizar suas informações cadastrais.

### 06: Sistema deve permitir a busca de informações sobre o usuário logado no sistema, retornando o seguinte:

  * Primeiro Nome;
  * Último Nome;
  * Email;
  * Data de Nascimento;
  * Login;
  * Telefone;
  * Lista de Carros;
  * Data de Criação;
  * Data de Último Login;
  
### 07: Sistema deve ser capaz de cadastrar um carro para determinado usuário, utilizando os seguintes atributos:
  
  * Ano;
  * Placa;
  * Modelo;
  * Cor;
  
### 08: Sistema deve ser capaz de listar os carros de um usuário.

### 09: Sistema deve ser capaz de buscar um carro de um usuário logado pelo id.

### 10: Sistema deve permitir remover um carro da listagem de um usuário logado pelo id.

### 11: Sistema deve permitir a atualização dos dados de um carro.

# Solução

## Spring Boot

O Spring Boot possui a maior flexibilidade para o desenvolvimento do projeto devido à sua configuração simples e possuir o servidor embutido na aplicação como solicitado.

## Mapstruct

O mapstruct foi escolhido como a ferramenta de mapeamento para 
transformar diferentes modelos de objetos por ter uma implementação rápida e ser bastante aceita no mercado.

## Github Actions

A escolha dessa ferramenta para automatizar processos de software se deve ao fato de ela já estar integrada à plataforma do Github.

## Heroku

A aplicação foi integrada com a plataforma do Heroku, onde a API está acessível por meio do link: https://rentcar-project.herokuapp.com/api.

# Passos para rodar a aplicação

#### mvn clean install
#### mvn spring-boot:run


