# StoreAPI

Olá pessoal! Meu nome é Natália e esse é o repositório do meu projeto do challenge.

Utilizei as seguintes tecnologias no projeto:

- Java 
- Maven
- Flyway
- Spring Data JPA
- JUnit
- Mockito
- Mysql

# Configurações do Banco de Dados

Utilizei o Mysql como banco de dados. As configurações referentes ao banco estão no arquivo application.properties, que se encontra no caminho: StoreApi/src/main/resources/application.properties
É necessário a criação de um DATABASE com o nome store_schema para que a migração funcione de forma correta.

Após a criação do banco de dados, é necessário executar a migration para que a criação das tabelas e a carga de dados seja executada. O arquivo migration se localiza no caminho StoreApi/src/main/resources/db/migration e o nome do arquivo é V1__create_tables.sql

Para executar a migration, basta executar o comando: 

```mvn flyway:migrate```

Caso ocorra erro relacionado a versão do script, execute o comando ```mvn flyway:repair``` e em seguida execute novamente o comando anterior.


# Execução do projeto

Para executar a aplicação, siga os seguintes passos:

- Clone o repositório ```https://github.com/natyiassanori/StoreAPI.git``` para sua máquina.
- Acesse o diretório do repositório pela linha de comando e instale as dependências do projeto com o comando:
```mvn install```
- Feito isso, gere o pacote do projeto executando:
```mvn clean package```
- Gerado o pacote, basta executá-lo com o comando: 
```java -jar .\target\StoreAPI-0.0.1-SNAPSHOT.jar```
- A aplicação está configurada para executar no ```http://localhost:8081```

# Endpoints

A aplicação conta com os seguintes endpoints:

- CRUD Produto:

1. Listar todos: /products/all -> GET
2. Buscar produto por Id: /products/{id do produto} -> GET
3. Criar produto: /products/create -> POST
4. Atualizar produto existente: /products/update/{id do produto} -> PUT
5. Deletar um produto pelo Id: /products/delete/{id do produto} -> DELETE

A criação e atualização dos produtos deve ser feita com a seguinte estrutura de corpo:

```
{   
    "name": "Produto x",
    "description": "exemplo de produto",
    "productCategoryId": 3
}
```
As categorias de produtos disponíveis com seus respectivos Ids são:

1 -> technology;

2 -> sports;

3 -> science;

4 -> health;

5 -> general;

6 -> entertainment;

7 -> business;

A data de criação e o score do produto não podem ser alterados.

- Ranqueamento dos produtos
Existe um endpoint para obter os produtos ranqueados ordenados de forma descrescente pelo seu score. esse endpoint permite a busca por nome e categoria:

```/products/ranking?name={product name}&category={category name}```

A requisição é feita da seguinte forma:

```/products/ranking?name=productName&category=business```


- Serviço para atualizar quantidade de notícias por categoria:

O endpoint ```/news/updateNewsCountByProductCategory``` é requisitado quando se deseja atualizar a dabela de notícias por categoria. Essa tabela armazena a quantidade de notícias relevantes para cada categoria existente. Isso é feito por meio do consumo do endpoint ```https://newsapi.org/docs/endpoints/top-headlines```.
Configurei meu endpoint para buscar as notícias mais relevantes dos EUA.

# Observações
- A carga de dados de produto foi elaborada utilizando alguns produtos vendidos pela Hotmart, outros foram criados. Por isso existem produtos em inglês e português.
- Criei testes unitários apenas para os métodos que julguei serem mais responsáveis pelas regras de nogócio do sistema, mesmo assim faltaram alguns.. :(
- Os serviços não foram auditados. Infelizmente nunca implementei auditoria em serviços e não tive tempo para pesquisar mais sobre.
- Implementei um scheduler com a intenção de executar o Job que atualiza a tabela da quantidade de notícias a cada 8 horas. Mas acabei comentando ele no final pois estava funcionando de forma errada, fazendo muitas requisições de uma vez. portando é possível executar o job apenas manualmente.
- Qualquer dúvida ou problema para executar por favor me acionem!

