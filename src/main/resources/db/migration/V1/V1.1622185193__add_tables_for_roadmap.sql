CREATE TABLE claim_action_responsible_organ (

        id                     BIGSERIAL NOT NULL PRIMARY KEY,
        created_at             TIMESTAMP,
        updated_at             TIMESTAMP,
        claim_id               BIGINT NOT NULL,
        title                  TEXT,
        type                   VARCHAR(64) NOT NULL
);
