-- liquibase formatted sql

-- changeset weare4saken:2
CREATE TABLE airline
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(50) NOT NULL
);