# timberbase
Go to https://timberbase-shaboo.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs

# Endpoints

`POST /sawmill` create a new sawmill record.

`Put /sawmill/{id}` update a sawmill record.

`GET /sawmill/{id}` get a specific sawmill record.

`GET /sawmill?name=value` get All sawmills and filter by name.

# How to run

- clone the repo
- inside terminal execute `docker-compose --env-file=./.env up --build -d`
- after app done build, in browser go to http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs