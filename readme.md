## :rocket: Sobre o desafio

Disponibilizar uma API para cadastro e compra de automóveis, utilizando conceitos e tecnologias para criação de microsserviços.

### Diagrama de classes

1. Microsserviço Automóvel

2. Microsserviço Boleto


### Arquitetura


### Funcionalidades da aplicação

1. Microsserviço Automóvel
- **`Listar os automóveis`**: Deve ser capaz de retornar uma lista de todos os automóveis registrados na aplicação, com os seguintes campos: **id**, **marca**, **modelo**, **valor**, **dataCriado**. Também deve retornar o status 200 se em caso de sucesso, ou 500 para erros.

**Request:**
```json
GET: http://localhost:5555/automovel-api/automoveis
Accept: application/json
Content-Type: application/json
Content-Length: xy
```


- **`Adicionar um automovel`**: Deve ser capaz de adicionar um novo automóvel passando os seguintes campos pela API: **id**, **marca**, **modelo**, **valor**, **dataCriado**. Deve retornar o status 201 em caso de sucesso, ou 500 para erros.

**Request:**
```json
POST: http://localhost:5555/automovel-api/cadastroAutomoveis
Accept: application/json
Content-Type: application/json
Content-Length: xy

{
    "marca": "Volkswagen",
    "modelo": "Golf",
    "valor": 50000.00,
    "dataCriado": "28-09-2020"
}
```

2. Microsserviço Boleto
- **`Gerar um novo boleto`**: Deve ser capaz de adicionar um novo boleto passando os seguintes campos pela API: **codigoBoleto**, **marca**, **modelo**, **valor**, **dataCriado**. Deve retornar o status 201 em caso de sucesso, ou 500 para erros. Também retornar os seguintes dados: **codigoBoleto**, **dataVencimento**, **valor**.

**Request:**
```json
POST: http://localhost:5555/boleto-api/boleto
Accept: application/json
Content-Type: application/json
Content-Length: xy

{
    "marca": "Volkswagen",
    "modelo": "Golf",
    "valor": 50000.00,
    "dataVencimento": "26-09-2020"
}
```

### Específicação dos testes 

#### Microsserviço Automóvel

1. Controller
- **`gerarBoletoSucesso`**: Para que esse teste passe, a aplicação deve permitir que um boleto seja adicionado ao backend e listado no backend com status 201.


1. Service
- **`saveBoleto`**: Para que esse teste passe, a aplicação deve permitir que um boleto seja adicionado ao backend e contabilizado pelo repositório H2.

#### Microsserviço Automóvel

1. Controller
- **`getAllAutomoveis`**: Para que esse teste passe, a aplicação deve retornar todos os automóveis registrados, diretamente para a API.

- **`cadastrarNovoAutomovelSucesso`**: Para que esse teste passe, a aplicação deve permitir que um boleto seja adicionado ao backend e listado no backend com status 201.


2. Service

- **`getAllAutomoveis`**: Para que esse teste passe, a aplicação deve listar todos os automóveis registrados no repositório H2 do backend.

- **`saveAutomovel`**: Para que esse teste passe, a aplicação deve permitir que um automóvel seja adicionado ao backend e contabilizado pelo repositório H2.

