CREATE TABLE responsible_body_claims
(
    id       BIGSERIAL NOT NULL PRIMARY KEY,
    claim_id BIGINT    NOT NULL REFERENCES claims (id),
    cause    TEXT,
    decision VARCHAR(64)
);

CREATE TABLE authorized_body_claims
(
    id       BIGSERIAL NOT NULL PRIMARY KEY,
    claim_id BIGINT    NOT NULL REFERENCES claims (id),
    cause    TEXT,
    decision VARCHAR(64)
);

CREATE TABLE commission_claims
(
    id       BIGSERIAL NOT NULL PRIMARY KEY,
    claim_id BIGINT    NOT NULL REFERENCES claims (id),
    cause    TEXT,
    decision VARCHAR(64)
)