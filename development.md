# Development

## Set up Kafka

```sh
docker compose up -d
```

```sh
docker-compose exec kafka kafka-topics.sh --create --topic ORDERS --partitions 1 --replication-factor 1 --bootstrap-server kafka:9092
```

## Kafka UI

- [UI](http://localhost:8090/)