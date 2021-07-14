ALTER TABLE admin
    ADD COLUMN region_id BIGINT REFERENCES ref_region (id);