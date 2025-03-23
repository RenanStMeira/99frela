package contracts

Contract.make {
    description "should create a new usuario"
    request {
        method 'POST'
        url '/usuario/cadastrar'
        body([
                nome    : "John Doe",
                email   : "john.doe@example.com",
                senha   : "password123",
                telefone: "1234567890",
                endereco: "123 Main St"
        ])
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 201
        body([
                id      : $(regex('[0-9]+')),
                nome    : "John Doe",
                email   : "john.doe@example.com",
                senha   : "password123",
                telefone: "1234567890",
                endereco: "123 Main St"
        ])
        headers {
            contentType(applicationJson())
        }
    }
}