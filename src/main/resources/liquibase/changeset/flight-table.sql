-- liquibase formatted sql

-- changeset weare4saken:3
CREATE TABLE flight (
    id                      BIGSERIAL PRIMARY KEY,
    flight_number           VARCHAR(50) NOT NULL,
    departure_airport_id    BIGINT NOT NULL REFERENCES airport(id),
    arrival_airport_id      BIGINT NOT NULL REFERENCES airport(id),
    airline_id              BIGINT NOT NULL REFERENCES airline(id),
    departure_date          TIMESTAMP NOT NULL,
    arrival_date            TIMESTAMP NULL
);