## :rocket: Sobre o desafio

Disponibilizar uma API para cadastro e compra de automóveis, utilizando conceitos e tecnologias para criação de microsserviços.

### Diagrama de classes

- **`Microsserviço Automóvel`**: [Diagrama de Classe Automóvel](modelagem/diagrama_classes_automovel.png)
- **`Microsserviço Boleto`**: [Diagrama de Classe Boleto](modelagem/diagrama_classes_boleto.png)


### Arquitetura

- **`Arquitetura`**: [Desenho da Arquitetura](modelagem/arquitetura_sistema_automobilistico.png)


### Funcionalidades da aplicação

#### Microsserviço Automóvel
**`Listar os automóveis`**: Deve ser capaz de retornar uma lista de todos os automóveis registrados na aplicação Também deve retornar o status 200 se em caso de sucesso, ou 500 para erros.

&nbsp;&nbsp;&nbsp;**Request:**
```json
GET: http://localhost:5555/automovel-api/automoveis
Accept: application/json
Content-Type: application/json
Content-Length: xy
```

&nbsp;&nbsp;&nbsp;**Response:**
```json
Status: 200 Ok
```

**`Adicionar um automovel`**: Deve ser capaz de adicionar um novo automóvel. Também deve retornar o status 201 em caso de sucesso, ou 500 para erros.

&nbsp;&nbsp;&nbsp;**Request:**
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

&nbsp;&nbsp;&nbsp;**Response:**
```json
Status: 201 Created
```

#### Microsserviço Boleto
**`Gerar um novo boleto`**: Deve ser capaz de adicionar um novo boleto. Também deve retornar o status 201 em caso de sucesso, ou 500 para erros.

&nbsp;&nbsp;&nbsp;**Request:**
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

&nbsp;&nbsp;&nbsp;**Response:**
```json
Status: 201 Created

{
    "id": 1,
    "valor": 50000.0,
    "dataVencimento": "2020-09-26T00:00:00.000+00:00"
}
```

### Específicação dos testes 

#### Microsserviço Automóvel

##### Controller
- **`gerarBoletoSucesso`**: Para que esse teste passe, a aplicação deve permitir que um boleto seja adicionado ao backend e listado no backend com status 201.


##### Service
- **`saveBoleto`**: Para que esse teste passe, a aplicação deve permitir que um boleto seja adicionado ao backend e contabilizado pelo repositório H2.

#### Microsserviço Automóvel

##### Controller
- **`getAllAutomoveis`**: Para que esse teste passe, a aplicação deve retornar todos os automóveis registrados, diretamente para a API.

- **`cadastrarNovoAutomovelSucesso`**: Para que esse teste passe, a aplicação deve permitir que um boleto seja adicionado ao backend e listado no backend com status 201.


##### Service

- **`getAllAutomoveis`**: Para que esse teste passe, a aplicação deve listar todos os automóveis registrados no repositório H2 do backend.

- **`saveAutomovel`**: Para que esse teste passe, a aplicação deve permitir que um automóvel seja adicionado ao backend e contabilizado pelo repositório H2.

