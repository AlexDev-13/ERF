ALTER TABLE movement_points
    ADD COLUMN type VARCHAR(128);
ALTER TABLE movement_actions
    ADD COLUMN type VARCHAR(128);


UPDATE movement_actions
SET type = 'REGISTER'
WHERE id = 1000;
UPDATE movement_actions
SET type = 'ORGAN_REJECT'
WHERE id = 1001;
UPDATE movement_actions
SET type = 'ORGAN_ACCEPT'
WHERE id = 1002;
UPDATE movement_actions
SET type = 'OPERATOR_REJECT'
WHERE id = 1003;
UPDATE movement_actions
SET type = 'OPERATOR_ACCEPT'
WHERE id = 1004;
UPDATE movement_actions
SET type = 'COMMISSION_REJECT'
WHERE id = 1005;
UPDATE movement_actions
SET type = 'COMMISSION_ACCEPT'
WHERE id = 1006;
UPDATE movement_actions
SET type = 'CONSIDERATION_BY_COMMISSION'
WHERE id = 1007;
UPDATE movement_actions
SET type = 'RESOLUTION_BY_COMMISSION'
WHERE id = 1008;

ALTER TABLE movement_actions
    ALTER COLUMN type SET NOT NULL;

UPDATE movement_points
SET type = 'ADMISSION'
WHERE id = 100;
UPDATE movement_points
SET type = 'ACCEPT'
WHERE id = 101;
UPDATE movement_points
SET type = 'REJECT'
WHERE id = 102;
UPDATE movement_points
SET type = 'RESOLUTION'
WHERE id = 103;

ALTER TABLE movement_points
    ALTER COLUMN type SET NOT NULL;


ALTER TABLE movement_points
    ALTER COLUMN type SET NOT NULL;

ALTER TABLE claims
    ADD COLUMN point_id
        BIGINT NOT NULL REFERENCES movement_points (id);

ALTER TABLE claims
    ADD COLUMN action_id
        BIGINT NOT NULL REFERENCES movement_actions (id);


ALTER TABLE claims
    ADD COLUMN status_id
        BIGINT NOT NULL REFERENCES status (id);

