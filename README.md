# Example insert into postgress using optional ID

Assumes:

```
$ createdb example
```

Modify the resources/application.conf for your database.
Note that I'm running PG on a non-standard port

Run:

```
$ sbt
sbt> run
[info] running Example 
Running:
DEBUG slick.jdbc.JdbcBackend.statement - Preparing statement: create table "shoppers" ("shopper_name" VARCHAR NOT NULL UNIQUE,"shopper_id" BIGSERIAL NOT NULL PRIMARY KEY)
DEBUG slick.jdbc.JdbcBackend.statement - Preparing statement: insert into "shoppers" ("shopper_name")  values (?)
DEBUG slick.jdbc.JdbcBackend.statement - Preparing statement: select "shopper_name", "shopper_id" from "shoppers"
Vector(Shopper(Alice,Some(1)))
```


