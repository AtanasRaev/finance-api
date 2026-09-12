# Finance API

Kotlin / Spring Boot API using Java 21 and PostgreSQL.

## Deploy to Fly.io

Run commands from the repository root, where `Dockerfile` and `fly.toml` live.
If deploying through a Git integration, commit and push these files first.

Create the Fly app if the failed launch has not already created it:

```sh
flyctl launch --no-deploy --name finance-api-tjepw --org atanaspraev-gmail-com --region ams
```

Keep the existing `fly.toml` when prompted. If the app already exists, skip
launch and set its secrets directly:

```sh
flyctl secrets set DATABASE_URL="jdbc:postgresql://HOST:5432/DATABASE?sslmode=require" DATABASE_USERNAME="USERNAME" DATABASE_PASSWORD="PASSWORD" --app finance-api-tjepw
flyctl deploy --app finance-api-tjepw
```

Replace placeholders with the actual PostgreSQL connection details. `DATABASE_URL`
must be a JDBC URL starting with `jdbc:postgresql://`. Local `.env` files are
excluded from the Docker build and are not uploaded as Fly secrets automatically.

The Dockerfile builds the executable JAR with the project's Gradle wrapper and
runs it with Java 21. Fly routes traffic to port 8080. The VM can stop when idle
and start on a request, so the first request after inactivity can take longer.

To check the container build locally with Docker running:

```sh
docker build -t finance-api .
```
