# Local PostgreSQL development

This project includes a Docker Compose setup for PostgreSQL and pgAdmin.

## Start

```sh
cp .env.example .env
docker compose up -d
```

PostgreSQL:

- Host from your host machine: `localhost`
- Host from another Compose service: `postgres`
- Port: `5432`
- Database: `tacocloud`
- User: `taco`

pgAdmin:

- URL: `http://localhost:5050`
- Email: `admin@example.com`
- Password: `admin_dev_password`

When registering the PostgreSQL server in pgAdmin, use `postgres` as the host
name, not `localhost`, because pgAdmin runs inside the Compose network.

## Useful commands

```sh
docker compose ps
docker compose logs -f postgres
docker compose logs -f pgadmin
docker compose down
```

To remove persisted development data:

```sh
docker compose down -v
```

## Later Spring configuration

When the application gets PostgreSQL support, these values will map naturally to
Spring properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tacocloud
spring.datasource.username=taco
spring.datasource.password=taco_dev_password
```

If the application later runs inside the same Compose network, use
`jdbc:postgresql://postgres:5432/tacocloud` instead.

