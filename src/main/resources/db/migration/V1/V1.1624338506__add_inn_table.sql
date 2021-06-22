INSERT INTO inn(name, inn)
VALUES ('Microsoft', '01010101010101'),
       ('Apple', '02020202020202');

ALTER TABLE claims
    ADD COLUMN admin_id BIGINT REFERENCES admin (id);

ALTER TABLE admin
    ADD COLUMN phone VARCHAR(64);