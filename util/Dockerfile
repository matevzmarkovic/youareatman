docker run --name YouAreAtmanPostgres -e POSTGRES_PASSWORD=youareatman -e POSTGRES_USER=atman -d postgres
FROM library/postgres
COPY init.sql /docker-entrypoint-initdb.d/
