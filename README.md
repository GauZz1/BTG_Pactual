

<h1 align="center">
    💱 <a href="#"> BTG Pactual - Conta Digital </a>
</h1>

<h3 align="center">
    API de Sistema de Conta Digitais
</h3>

<h4 align="center">
	Finalizado 🚀
</h4>

Tabela de conteúdos
=================
<!--ts-->
* [Sobre o projeto](#-sobre-o-projeto)
* [Modelagem da Entidades e Relacionamentos](#-modelagem-de-entidades-e-relacionamentos)
	* [Modelo Entidade Relacionamento](#-modelo-entidade-relacionamento)
	* [Diagrama Entidade Relacionamento](#-diagrama-entidade-relacionamento)
 	* [Script DDL](#-script-ddl)
  	* [Script DML](#-script-dml)
* [Funcionalidades](#-funcionalidades)
* [Documentação](#-documentacao)
* [Tecnologias](#-tecnologias)
* [Contribuidores](#-contribuidores)
<!--te-->


# 💻 Sobre o projeto

💱 O projeto é um desafio técnico para a empresa BTG Pactual que consiste na criação de um sistema de contas digitais contendo entidades básicas como cliente, conta e movimentações e os métodos de cada entidade. 
No projeto foi utilizado framework Spring Boot e o banco de dados utilizado foi o PostgreSQL

## Modelagem da Entidades e Relacionamentos

## Modelo Entidade Relacionamento
- O Modelo Entidade Relacionamento (MER) é usado para representar as entidades, seus atributos e relacionamentos 

![Alt text](src/main/assets/DER_Digital_Account.jpg)

## Diagrama Entidade Relacionamento
- O Diagrama Entidade Relacionamento (DER) é a representação gráfica das entidades e seus relacionamentos

![Alt text](src/main/assets/MER_Digital_Account.jpg)

## Script DDL

	CREATE TABLE accounts (balance float(53) NOT NULL, client_id bigint NOT NULL UNIQUE, id BIGSERIAL NOT NULL, number varchar(255) NOT NULL, PRIMARY KEY (id));
	
	
	CREATE TABLE clients (id BIGSERIAL NOT NULL, address varchar(255) NOT NULL, cellphone varchar(255) NOT NULL, cpf varchar(255) NOT NULL, email varchar(255) NOT NULL, name varchar(255) NOT NULL, PRIMARY KEY (id));
	
	
	CREATE TABLE transactions (amount float(53) NOT NULL, account_id bigint NOT NULL, id BIGSERIAL NOT NULL, transaction_date timestamp(6) WITH TIME ZONE NOT NULL, description varchar(255) NOT NULL, TYPE varchar(255) NOT NULL CHECK (TYPE in ('DEPOSIT', 'WITHDRAW')), PRIMARY KEY (id));
	
	
	ALTER TABLE IF EXISTS accounts ADD CONSTRAINT FKgymog7firrf8bnoiig61666ob
	FOREIGN KEY (client_id) REFERENCES clients;
	
	
	ALTER TABLE IF EXISTS transactions ADD CONSTRAINT FK20w7wsg13u9srbq3bd7chfxdh
	FOREIGN KEY (account_id) REFERENCES accounts;


## Script DML

### Clients
	
	INSERT INTO clients (name, email, cpf, address, cellphone)
	VALUES ('Gerarda Pereira', 'gerarda.pereira@example.com', '12345678911', 'Rua Aparecida 123', '86966743491');
	
	INSERT INTO clients (name, email, cpf, address, cellphone)
	VALUES ('Gleverton Campos', 'gleverton.campos@example.com', '987654321', 'Rua Sêneca 123', '47968811334');
	
	INSERT INTO clients (name, email, cpf, address, cellphone)
	VALUES ('Rosenildo Alves', 'rosenildo.alves@example.com', '456123789', 'Rua Gênova 123', '21961659486');
	
### Acounts
	
	INSERT INTO accounts (client_id, number, balance)
	VALUES (1, 'ACC123456789', 1000.50);
	
	INSERT INTO accounts (client_id, number, balance)
	VALUES (2, 'ACC987654321', 500.75);
	
	INSERT INTO accounts (client_id, number, balance)
	VALUES (3, 'ACC456789123', 2500.30);
	
 ### Transactions
	
	INSERT INTO transactions (account_id, type, amount, description)
	VALUES (1, 'DEPOSIT', 500.00, 'Depositei dinheiro');
	
	INSERT INTO transactions (account_id, type, amount, description)
	VALUES (1, 'WITHDRAW', 100.00, 'Retirei dinheiro');
	
	INSERT INTO transactions (account_id, type, amount, description)
	VALUES (2, 'DEPOSIT', 1000.00, 'Depositei dinheiro');
	
	INSERT INTO transactions (account_id, type, amount, description)
	VALUES (2, 'WITHDRAW', 200.00, 'Retirei dinheiro');
	
	INSERT INTO transactions (account_id, type, amount, description)
	VALUES (3, 'DEPOSIT', 1500.00, 'Depositei dinheiro');
	
	INSERT INTO transactions (account_id, type, amount, description)
	VALUES (3, 'WITHDRAW', 300.00, 'Retirei dinheiro');
---

# ⚙️ Funcionalidades

- Cadastro e atualização de clientes
- Cadastro e atualização de contas
- Consulta de contas e clientes
- Consulta de contas de clientes
- Consulta por movimentações de uma conta
- Adição de saldo à conta (Depósito)
- Remoção de saldo da conta (Saque)

---

# Documentação

Documentação da API com as operações de CRUD para as entidades Cliente, Conta e Transação seguindo o padrão REST

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
