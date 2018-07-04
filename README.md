# The You are Atman project
Purpose of this project is to enable spiritual aspirants on the Yoga path to track their daily spiritual work, as well as to note down any incidents that occurred throughout the course of the day, thus promoting vigilance, introspection and self-analysis.

It is based on the Yoga Sūtras of Patañjali, where it exposes the first two Yoga limbs. It provides the oportunity to the aspirant to note down, whether on a particular day he or she managed to follow all Yamas (moral imperatives) and Niyamas (virtuous habits, behaviors and observances); as well to describe particular obstacles (Antarayah) and possible correlates (Sahabhuva) that have manifested during the course of the day.

# How to run
First start the PostgreSQL docker instance
```
$cd util/
$docker build -t youareatman_postgres .
$docker run -d --name YouAreAtmanPostgres -e POSTGRES_PASSWORD=youareatman -e POSTGRES_USER=atman youareatman_postgres
```

Since a Spring Boot app is behind the veil just a simple standalone Java application, which uses the *public static void main* method, you run it by executing
```
???
$mvn spring-boot:run
```

## Curently implemented API calls
*Substitute localhost:8443 in examples bellow with the address of your server.*

### Collection: atmanusers
GET a resource:

```
https://localhost:8443/YouAreAtman/atmanusers
https://localhost:8443/YouAreAtman/atmanusers/{userEmail}
```

POST a resource (not idempotent!):

```
https://localhost:8443/YouAreAtman/atmanusers
```

PUT (modify) a resource:

```
https://localhost:8443/YouAreAtman/atmanusers/{userEmail}/password
https://localhost:8443/YouAreAtman/atmanusers/{userEmail}/date
```

DELETE a resource:

```
https://localhost:8443/YouAreAtman/atmanusers
```

### Collection: incidents

GET a resource:

```
https://localhost:8443/YouAreAtman/incidents
https://localhost:8443/YouAreAtman/incidents/{userEmail}
https://localhost:8443/YouAreAtman/incidents/{date}
https://localhost:8443/YouAreAtman/incidents/{incidentId}
```

POST a resource (not idempotent!):

```
https://localhost:8443/YouAreAtman/incidents
```

PUT (modify) a resource:

```
https://localhost:8443/YouAreAtman/incidents/{incidentId}
```

DELETE a resource:

```
https://localhost:8443/YouAreAtman/incidents/{incidentId}
```

# Implementation details

## PostgreSQL database schema

![Shema should be here...](https://github.com/matevzmarkovic/youareatman/blob/master/help/database_shema.png)
