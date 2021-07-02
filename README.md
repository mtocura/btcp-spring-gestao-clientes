# Aula 2 - Estender métodos web e JSON - TT

## Prática Complementar - Exercício 2 - Gestão de Clientes

Respositório que contém a solução para o exercício 2 da aula 2 TT.

- POST ```` /aula2/tt/clientes ````
    - cria um cliente no sistema
    - body request: 
    ```` 
    {
        "nome": "Usuário Mock",
        "cpf": "99864598007",
        "email": "mock@teste.com.br",
        "telefone": "11912345678",
        "pedidos": [
            {
                "produtos": [
                    {
                        "descricao": "PS5",
                        "cor": "branco",
                        "quantidade": 1,
                        "preco": 4999.99
                    },
                    {
                        "descricao": "Nintendo Switch",
                        "cor": "cinza",
                        "quantidade": 1,
                        "preco": 2999.99
                    }
                ]
            },
            {
                "produtos": [
                    {
                        "descricao": "Mouse Logitech G403",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 239.99
                    },
                    {
                        "descricao": "Teclado Mecânico Redragon Surara Pro",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 259.99
                    }
                ]
            }
        ]
    }
    ````
  - retorno de onde foi criado no header
    

- GET ```` /aula2/tt/clientes ````
    - retorna uma lista com todos os clientes e seus pedidos
    - body response:
    `````
    [
        {
            "nome": "99864598007",
            "cpf": "Usuário Mock",
            "email": "mock@teste.com.br",
            "telefone": "11912345678",
            "pedidos": [
                {
                    "produtos": [
                        {
                            "descricao": "PS5",
                            "cor": "branco",
                            "quantidade": 1,
                            "preco": 4999.99
                        },
                        {
                            "descricao": "Nintendo Switch",
                            "cor": "cinza",
                            "quantidade": 1,
                            "preco": 2999.99
                        }
                    ],
                    "total": 7999.98
                },
                {
                    "produtos": [
                        {
                            "descricao": "Mouse Logitech G403",
                            "cor": "preto",
                            "quantidade": 1,
                            "preco": 239.99
                        },
                        {
                            "descricao": "Teclado Mecânico Redragon Surara Pro",
                            "cor": "preto",
                            "quantidade": 1,
                            "preco": 259.99
                        }
                    ],
                    "total": 499.98
                }
            ]
        }
    ]
    `````
  
- GET ```` /aula2/tt/clientes/{cpf} ````
    - retorna todos os pedidos de um cliente através de seu cpf
    - body response:
    ````
    {
        "nome": "99864598007",
        "cpf": "Usuário Mock",
        "email": "mock@teste.com.br",
        "telefone": "11912345678",
        "pedidos": [
            {
                "produtos": [
                    {
                        "descricao": "PS5",
                        "cor": "branco",
                        "quantidade": 1,
                        "preco": 4999.99
                    },
                    {
                        "descricao": "Nintendo Switch",
                        "cor": "cinza",
                        "quantidade": 1,
                        "preco": 2999.99
                    }
                ],
                "total": 7999.98
            },
            {
                "produtos": [
                    {
                        "descricao": "Mouse Logitech G403",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 239.99
                    },
                    {
                        "descricao": "Teclado Mecânico Redragon Surara Pro",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 259.99
                    }
                ],
                "total": 499.98
            }
        ]
    }
    ````