

<h1 align="center">
    💱 <a href="#"> BTG Pactual - Conta Digital </a>
</h1>

<h3 align="center">
    API de Sistema de Conta Digitais
</h3>

<h4 align="center">
	Em andamento 🚀
</h4>

Tabela de conteúdos
=================
<!--ts-->
* [Sobre o projeto](#-sobre-o-projeto)
* [Funcionalidades](#-funcionalidades)
* [Modelagem da Entidades e Relacionamentos](#-modelagem-de-entidades-e-relacionamentos)
	* [Modelo Entidade Relacionamento](#-modelo-entidade-relacionamento)
	* [Diagrama Entidade Relacionamento](#-diagrama-entidade-relacionamento)
* [Tecnologias](#-tecnologias)
* [Contribuidores](#-contribuidores)
<!--te-->


## 💻 Sobre o projeto

💱 O projeto é um desafio técnico para a empresa BTG Pactual que consiste na criação de um sistema de contas digitais contendo entidades básicas como cliente, conta e movimentações e os métodos de cada entidade. 
No projeto foi utilizado framework Spring Boot e o banco de dados utilizado foi o PostgreSQL

## Modelagem da Entidades e Relacionamentos

## Modelo Entidade Relacionamento
- O Modelo Entidade Relacionamento (MER) é usado para representar as entidades, seus atributos e relacionamentos 

![Alt text](src/main/assets/DER_Digital_Account.jpg)

## Diagrama Entidade Relacionamento
- O Diagrama Entidade Relacionamento (DER) é a representação gráfica das entidades e seus relacionamentos

![Alt text](src/main/assets/MER_Digital_Account.jpg)

---

## ⚙️ Funcionalidades #funcionalidades

- Cadastro e atualização de clientes
- Cadastro e atualização de contas
- Consulta de contas e clientes
- Consulta de contas de clientes
- Consulta por movimentações de uma conta
- Adição de saldo à conta (Depósito)
- Remoção de saldo da conta (Saque)

---

# REST API

The REST API to the example app is described below.

## Client

### POST

`POST /clients` - Create Client

    http://localhost:8080/clients
    JSON body
    {
    	"name": "Teste2",
    	"cpf": "3342423",
    	"cellphone": "576567567",
    	"address": "Rua teste 12356",
    	"email": "teste2@gmail.com"
	}

cURL

    curl --location 'http://localhost:8080/clients' \
	--header 'Content-Type: application/json' \
	--data-raw '{
    	"name": "Teste2",
    	"cpf": "3342423",
    	"cellphone": "576567567",
    	"address": "Rua teste 12356",
    	"email": "teste2@gmail.com"
	}'

 ### PUT

`PUT /clients/{id}` - Update Client

    http://localhost:8080/clients/{id}
    JSON body
    {
    	"name": "Teste2",
    	"cpf": "3342423",
    	"cellphone": "576567567",
    	"address": "Rua teste 12356",
    	"email": "teste2@gmail.com"
	}

cURL

    curl --location --request PUT 'http://localhost:8080/clients' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "name": "Teste2",
	    "cpf": "3342423",
	    "cellphone": "576567567",
	    "address": "Rua teste 12356",
	    "email": "teste2@gmail.com"
	}'

 ### GET

`GET /clients` - Get All Clients

    http://localhost:8080/clients

cURL

    curl --location 'http://localhost:8080/clients' \
	--data ''

  ### GET

`GET /clients/{id}` - Get Client

    http://localhost:8080/clients/{id}

cURL

    curl --location 'http://localhost:8080/clients/2' \
	--data ''

   ### GET

`GET /clients/{id}/account` - Get Client Account

    http://localhost:8080/clients/{id}/account

cURL

    curl --location 'http://localhost:8080/clients/1/account' \
	--data ''

  ### DELETE

`DELETE /clients/{id}` - Delete Client

    http://localhost:8080/clients/{id}

cURL

    curl --location 'http://localhost:8080/clients' \
	--data ''

 ## Account

### POST

`POST /accounts` - Create Account

    http://localhost:8080/accounts
    JSON body
    {
    "number": "123",
    "balance": 100.00,
    "clientId": 3
	}

cURL

    curl --location 'http://localhost:8080/accounts' \
	--header 'Content-Type: application/json' \
	--data '{
	    "number": "123",
	    "balance": 100.00,
	    "clientId": 3
	}'

 ### PUT

`PUT /accounts/{id}` - Update Account

    http://localhost:8080/accounts/{id}
    JSON body
    {
    "number": "12354",
    "balance": 100.00,
    "clientId": 3
	}

cURL

    curl --location --request PUT 'http://localhost:8080/accounts/3' \
	--header 'Content-Type: application/json' \
	--data '{
	    "number": "12354",
	    "balance": 100.00,
	    "clientId": 3
	}'

 ### GET

`GET /accounts` - Get All Accounts

    http://localhost:8080/accounts

cURL

    curl --location 'http://localhost:8080/accounts' \
--data ''

  ### GET

`GET /accounts/{id}` - Get Account

    http://localhost:8080/accounts/{id}

cURL

    curl --location 'http://localhost:8080/accounts/3' \
	--data ''

   ### GET

`GET /accounts/{id}/transactions` - Get Account Transactions

    http://localhost:8080/accounts/{id}/transactions

cURL

    curl --location 'http://localhost:8080/accounts/1/transactions' \
	--data ''

  ### DELETE

`DELETE /accounts/{id}` - Delete Account

    http://localhost:8080/accounts/{id}

cURL

    curl --location 'http://localhost:8080/accounts' \
	--data ''


## Transaction

### POST

`POST /transactions` - Create Transaction

    http://localhost:8080/transactions
    JSON body
    {
    "accountId": 1,
    "type": "WITHDRAW",
    "amount": 15.00,
    "description": "Removi saldo da conta"
	}

cURL

    curl --location 'http://localhost:8080/transactions' \
	--header 'Content-Type: application/json' \
	--data '{
	    
	    "accountId": 1,
	    "type": "WITHDRAW",
	    "amount": 15.00,
	    "description": "Removi saldo da conta"
	}'

 ### GET

`GET /transactions` - Get All Transactions

    http://localhost:8080/transactions

cURL

    curl --location 'http://localhost:8080/transactions' \
--data ''

  ### GET

`GET /transactions/{id}` - Get Transaction

    http://localhost:8080/transactions/{id}

cURL

    curl --location 'http://localhost:8080/transactions/8' \
	--data ''
 
---

 - As opções de DELETE e UPDATE da entidade transactions não foram implementadas pois na regra de negócio de contas digitais eu acredito não fazer sentido poder deleter ou atualizar uma transação
 
---

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

#### **Website**  ([Java](https://www.oracle.com/br/java/technologies/downloads/)  +  [Postgres](https://www.postgresql.org/))

---

## 👨‍💻 Contribuidores

    wyan
---
