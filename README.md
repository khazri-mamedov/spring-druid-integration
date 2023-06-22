# Spring Boot & Apache Druid
This is a simple repository to demonstrate integration of Spring Boot with Apache Druid

## Initial setup
1. ``docker-compose up -d`` - runs Apache Druid cluster with environment variables from corresponding file **(testcontainers can be used instead)**
2. https://druid.apache.org/docs/latest/tutorials/tutorial-batch.html - see ``wikipedia_ingestion_spec.json`` for ingest spec task
3. ``./mvnw test``