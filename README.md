# gestao_ativos
API Restful para Gestão de Ativos Industriais
Serviço RESTful com um escopo simplificado de gestão de ativos industriais, utilizando JDK8, Maven, PostgreSQL 12, Spring Boot,
Hibernate e Jackson.

A API realiza testes unitários para verificar persistência de dados e o delete deles.

Foi implementado autenticação para acessar a API. Para poder realizar acesso, utilize:
- usuario: admin 
- senha: viridis

A API  foi hospedada no Heroku e pode ser acessada através de: https://gestao-ativos.herokuapp.com/swagger-ui.html#, utilizando o usuario e senha informados acima.

Feito o acesso, é permitido as operações de:
Equipamento:

- Salvar um equipamento
- Deletar um Equipamento
- Atualizar um equipamento
- Retornar uma lista de equipamentos

OrdemManutencao:

- Salvar uma ordem
- Deletar uma ordem
- Atualizar uma ordem
- Retornar a lista de ordem, ordenando por data

As informações são representadas através do formado JSON, que são persistidas e mapeadas pelo JPA usando Hibernate com banco de dados PostgreSQL.
Através do campo anotacoes é possível armazenar quaisquer informações de interesse, utilizando JSONB do Prostgresql.

Exemplo de Equipamento:
  "equipamento": {
    "nome": "Máquina I"
  }


Exemplo de Ordem:
{
 "dataManutencao": "2020-04-04 03:00:00",
  "equipamento": {
    "id": 2,
    "nome": "Máquina I"
  },
  "anotacoes": "{\"local\": \"Predio I\" , \"responsavel\" : \"Wagner\"}"
}




