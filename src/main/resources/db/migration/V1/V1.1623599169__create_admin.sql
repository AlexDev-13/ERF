CREATE TABLE admin
(
    id         BIGSERIAL   NOT NULL PRIMARY KEY,
    name       VARCHAR(64) NOT NULL,
    surname    VARCHAR(64) NOT NULL,
    patronymic VARCHAR(64),
    username   VARCHAR(64),
    email      VARCHAR(128),
    password   VARCHAR,
    role_id    BIGINT,
    organ_id   BIGINT,
    locked     BOOLEAN     NOT NULL DEFAULT TRUE,
    enabled    BOOLEAN     NOT NULL DEFAULT FALSE
);

CREATE TABLE confirm_token
(
    id           BIGSERIAL   NOT NULL PRIMARY KEY,
    token        VARCHAR(64) NOT NULL,
    admin_id     BIGINT      NOT NULL REFERENCES admin (id),
    created_at   TIMESTAMP,
    expired_at   TIMESTAMP,
    confirmed_at TIMESTAMP
);

CREATE TABLE roles
(
    id    BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(64)
);

INSERT INTO roles (title)
VALUES ('GLOBAL_ADMIN'),
       ('REGIONAL_ADMIN'),
       ('USER'),
       ('OMBUDSMEN');