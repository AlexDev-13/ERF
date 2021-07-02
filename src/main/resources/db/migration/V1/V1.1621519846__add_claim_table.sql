CREATE TABLE IF NOT EXISTS movement_points
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    title
    VARCHAR
(
    255
) NOT NULL
    );

CREATE TABLE IF NOT EXISTS status
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    title
    VARCHAR
(
    255
) NOT NULL
    );



CREATE TABLE IF NOT EXISTS movement_actions
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    title
    VARCHAR
(
    255
) NOT NULL
    );

CREATE TABLE IF NOT EXISTS movement_roadmaps
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    source_point_id
    BIGINT
    REFERENCES
    movement_points
(
    id
),
    target_point_id BIGINT NOT NULL REFERENCES movement_points
(
    id
),
    action_id BIGINT NOT NULL REFERENCES movement_actions
(
    id
)
    );


INSERT INTO movement_points (id, title)
VALUES (100, 'Поступление'),
       (101, 'Принятие'),
       (102, 'Отказ'),
       (103, 'Решение');

INSERT INTO status (id, title)
VALUES (10, 'В обработке'),
       (11, 'Одобрено'),
       (12, 'Отказ');



INSERT INTO movement_actions (id, title)
VALUES (1000, 'Регистрация заявки'),
       (1001, 'Отказ заявки ( ответственный орган )'),
       (1002, 'Принятие заявки ( ответственный орган )'),
       (1003, 'Отказ заявки ( оператор )'),
       (1004, 'Принятие заявки ( оператор )'),
       (1005, 'Отказ заявки ( комиссия ) '),
       (1006, 'Принятие заявки ( комиссия )'),
       (1007, 'На рассмотрении комиссией'),
       (1008, 'Решение комиссии');

INSERT INTO movement_roadmaps (source_point_id, action_id, target_point_id)
VALUES (NULL, 1000, 100),
       (101, 1001, 102),
       (101, 1002, 103),
       (103, 1003, 101),
       (103, 1004, 102),
       (101, 1005, 102),
       (101, 1006, 103),
       (101, 1007, 103),
       (103, 1008, 103);


CREATE TABLE ref_economic_activity
(
    id    BIGSERIAL   NOT NULL PRIMARY KEY,
    title VARCHAR(64) NOT NULL
);

INSERT INTO ref_economic_activity (title)
VALUES ('Строительство'),
       ('Сельское хозяйство, лесное хозяйство, рыболовство'),
       ('Информационные технологии'),
       ('Грузовые, пассажирские перевозки'),
       ('Авиаперевозки'),
       ('Услуги'),
       ('Недропользование'),
       ('Промышленность');

CREATE TABLE ref_organ_addressed
(
    id    BIGSERIAL   NOT NULL PRIMARY KEY,
    title VARCHAR(64) NOT NULL
);

INSERT INTO ref_organ_addressed (title)
VALUES ('Налоговая служба'),
       ('Таможенная служба'),
       ('Бизнес омбудсмен');

CREATE TABLE ref_region
(
    id    BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(64)
);

INSERT INTO ref_region (title)
VALUES ('Чуйская область'),
       ('Ошская область'),
       ('Баткенская область'),
       ('Таласская область'),
       ('Нарынская область'),
       ('Иссык-Кульская область'),
       ('Джалал-Абадская область');

CREATE TABLE files
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    path       TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE applicant
(

    id    BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(64)
);

INSERT INTO applicant (title)
VALUES ('PHYSICAL_DATA'),
       ('JURIDICAL_DATA');

CREATE TABLE inn
(
    id   BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(64),
    inn  VARCHAR(64)
);


CREATE TABLE claims
(
    id                     BIGSERIAL NOT NULL PRIMARY KEY,
    created_at             TIMESTAMP,
    updated_at             TIMESTAMP,
    fullname               VARCHAR(128),
    inn                    VARCHAR(64),
    telephone              VARCHAR(64),
    email                  VARCHAR(64),
    company_name           VARCHAR(64),
    applicant_id           BIGINT REFERENCES applicant (id),
    economic_activity_id   BIGINT    NOT NULL REFERENCES ref_economic_activity (id),
    organ_addressed_id     BIGINT    NOT NULL REFERENCES ref_organ_addressed (id),
    cause_of_factor        TEXT,
    problem_of_description TEXT,
    identification_factor  TEXT,
    file_id                BIGINT REFERENCES files (id),
    region_id              BIGINT    NOT NULL REFERENCES ref_region (id),
    empowerment            TEXT,
    agreement              BOOLEAN
);

