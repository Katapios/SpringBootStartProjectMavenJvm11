# PostgreSQL init scripts

Put optional `.sql`, `.sql.gz`, or executable `.sh` files here.

The official PostgreSQL image runs these files only when the database volume is
created for the first time. To re-run init scripts in local development, remove
the database volume with:

```sh
docker compose down -v
docker compose up -d
```
