# Products Manager

## Web Scrapping (Python)

### Regras Funcionais

- [x] Deve ser possível extrair produtos de web-commerces 
- [] Deve ser possível enviar produtos extraidos para outra aplicação

### Regras Não Funcionais

- [] Cada site de web-commerce será uma thread para extrair seus dados
- [] O scrapping será realizado a cada 1h, após a extração os dados serão enviados à outra aplicação
- [] Os dados serão armazenados na memória e excluídos após ser enviado para outra aplicação
- [] Caso o produto já exista na outra aplicação, realizará uma regra para ver o melhor e buscar outros produtos de acordo com a quantidade de retorno, sendo possível ver qual produto foi retornado

## Aplicação Web (Front-end; Backend)


### Regras Funcionais

- [] Deve ser possível cadastrar produtos vindo de outro serviço web-scrapping
- [] Deve ser possível visualizar os produtos
- [] Deve ser possível pegar produto pelo ID
- [] Deve ser possível cadastrar usuário
- [] Deve ser possível autenticar usuário
- [] Deve ser possível indentificar o usuário entre as requisições
- [] Deve ser possível o usuário CRUD seu próprio produto
- [] Deve ser possível criar ambientes para cadastrar produtos
- [] Deve ser possível comprar um plano
- [] Deve ser possível visualizar valor de cada produto e valo total dos produtos selecionados no ambiente
- [] Deve ser possível ir ao site do web-commerce ao clicar no produto
- [] Deve ser possível sugerir produtos ao usuário, conforme susas características pessoais

### Regras Não Funcionais

- [] Os dados devem estar persistidos em um banco de dados racional (PostgresSQL)
- [] Para indentificar os usuários entre requests deve utiliar JWT
- [] Os planos serão: Básico, Plus, Premium (pode mudar)
- [] Para cadastrar produto o usuário deverá ter um plano ou pagar um valor fixo que será aumentado conforme a compra de quantidades de produtos próprios
- [] As senhas dos usuários deveram estar criptografados
- [] Para comprar um plano deverá ser usado a Api do MercadoPago (Pix e Cartão)


            Opcional
- [] Pode ter Kafka -> mensageria
- [] Pode ter Redis -> cache

## Linguagens

### Web Scrapping
- Python (FastApi)

### Web - Frontend - Backend
Typescript (Angular)<br>
Java (Spring Boot)
