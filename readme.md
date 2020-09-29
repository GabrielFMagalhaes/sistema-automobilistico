## :rocket: Sobre o desafio

Disponibilizar uma API para cadastro e compra de automóveis, utilizando conceitos e tecnologias para criação de microsserviços.

### Diagrama de classes

- **`Microsserviço Automóvel`**: [Diagrama de Classes Automóvel](docs/diagrama_classes_automovel.png)
- **`Microsserviço Boleto`**: [Diagrama de Classes Boleto](docs/diagrama_classes_boleto.png)
- **`Microsserviço Autenticação`**: [Diagrama de Classes Autenticação](docs/diagrama_classes_autenticacao.png)


### Arquitetura

- **`Arquitetura`**: [Desenho da Arquitetura](docs/arquitetura_sistema_automobilistico.png)

### URLs e Swagger/Postman

| Microsserviço | Swagger Localhost | Swagger - Servidor Online |
| ------------- | ------------- | ------------- |
| Automóvel     | http://localhost:5555/automovel-api/swagger-ui.html#/ | http://142.93.4.1:5555/automovel-api/swagger-ui.html |
| Boleto     | http://localhost:5555/boleto-api/swagger-ui.html#/ | http://142.93.4.1:5555/boleto-api/swagger-ui.html |
| Autenticação     | http://localhost:5555/oauth/swagger-ui.html#/ | http://142.93.4.1:5555/oauth/swagger-ui.html |

| Postman |
| ------------- |
| [Servidor Online](servidor_online.json) | 
| [Localhost ](localhost_postman.json) | 


### Funcionalidades da aplicação
> Não se esqueça de instalar o Lombok

> Para testar todos as APIs, lembre-se de realizar a autenticação e armazenar o access_token retornado
> Todos os microsserviços também estão habilitados para funcionar no servidor online disponibilizado para testes

[](https://media.giphy.com/media/s4JYMX6k8mk1G3ZGdj/giphy.gif)


### Microsserviço Autenticação OAuth

**`Autenticar usuário`**: Deve ser capaz de autenticar-se pela API.

&nbsp;&nbsp;&nbsp;**Request:**
```json
POST: http://localhost:5555/oauth/token?grant_type=password&username=admin&password=admin
Accept: application/json
Content-Type: application/json
Content-Length: xy
Authorization: Basic Auth
    Username: client
    Password: secret
```

&nbsp;&nbsp;&nbsp;**Response:**
```json
Status: 200 Ok
{
    "access_token": "8743f56f-dc4e-4bc3-8a42-aa4a11caa77d",
    "token_type": "bearer",
    "refresh_token": "4085cda6-61c8-4519-8348-5f1251bd89c2",
    "expires_in": 43199,
    "scope": "webclient mobileclient"
}
```


#### Microsserviço Automóvel


**`Listar os automóveis`**: Deve ser capaz de retornar uma lista de todos os automóveis registrados na aplicação Também deve retornar o status 200 se em caso de sucesso, ou 500 para erros.

&nbsp;&nbsp;&nbsp;**Request:**
```json
GET: http://localhost:5555/automovel-api/automoveis
Accept: application/json
Content-Type: application/json
Content-Length: xy
Authorization: Bearer Token
```

&nbsp;&nbsp;&nbsp;**Response:**
```json
Status: 200 Ok
[
    {
        "id": 1,
        "marca": "Volkswagen",
        "modelo": "Golf",
        "valor": 40000.5,
        "dataCriado": "2020-09-29T22:09:48.449+00:00"
    },
]
```

**`Adicionar um automovel`**: Deve ser capaz de adicionar um novo automóvel. Também deve retornar o status 201 em caso de sucesso, ou 500 para erros.

&nbsp;&nbsp;&nbsp;**Request:**
```json
POST: http://localhost:5555/automovel-api/cadastroAutomoveis
Accept: application/json
Content-Type: application/json
Content-Length: xy
Authorization: Bearer Token
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
Authorization: Bearer Token
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

