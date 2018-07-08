# The You Are Atman project
Purpose of the You Are Atman project is to enable spiritual aspirants on the Yoga path to track their daily spiritual work, as well as to note down any incidents that occurred throughout the course of the day, thus promoting vigilance, introspection and self-analysis.

It is based on the Yoga Sūtras of Patañjali, where it exposes the first two Yoga limbs. It provides the opportunity to the aspirant to note down, whether on a particular day he or she managed to follow all Yamas (moral imperatives) and Niyamas (virtuous habits, behaviors and observances); as well to describe particular obstacles (Antarayah) and possible correlates (Sahabhuva) that have manifested during the course of the day.

## Purpose of this backend

The idea of the whole project is to deploy REST API on a backend server and create multiple frontends for all kinds of devices people come across during the course of their day. Not just modern smartphones and tables, but anything that is capable of doing REST calls - TVs, cars, even a toilet if need be. Spiritual aspirants are ever-vigilant, they pick up ego incidents very quickly and thus need as many possibilities for quickly noting these down as possible.


##Technical details
Backend is implemented using Spring Boot, while the database used is Postgres.

# Getting started
First start the Postgres docker instance using
```
$cd util/
$docker build -t youareatman_postgres .
$docker run -d --name YouAreAtmanPostgres -e POSTGRES_PASSWORD=youareatman -e POSTGRES_USER=atman youareatman_postgres
```

Since the You Are Atman Spring Boot app is behind the veil just a simple standalone Java application, which rides atop the *public static void main* method, you run it by executing
```
$mvn spring-boot:run
```
from the root project directory.

Should you want to deploy the app, grab the jar file from *target/* and run it with the following command
```
$java -jar target/youareatman-1.0-SNAPSHOT.jar
```

# Swagger documentation
Swagger JSON can be accessed through *api/v2/api-docs*, for example
```
https://localhost:8443/YouAreAtman/api/v2/api-docs
```

Should you want to use Swagger UI, access it at *api/swagger-ui.html*, for example
```
https://localhost:8443/YouAreAtman/api/swagger-ui.html#
```

![Swagger screenshot should be here...](https://github.com/matevzmarkovic/youareatman/blob/master/help/swagger.png)

# Implementation details

## Possible future work
1. Introduce proper error handling (https://www.toptal.com/java/spring-boot-rest-api-error-handling).
2. Externalize configuration (https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html).
3. Rework handling and storing of passwords using Spring Security.
4. Use OAuth2. Use tokens.

## PostgreSQL database schema

![Shema should be here...](https://github.com/matevzmarkovic/youareatman/blob/master/help/database_shema.png)
