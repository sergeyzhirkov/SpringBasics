BEGIN;

DROP TABLE IF EXISTS simple_products CASCADE;
CREATE TABLE simple_products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);

COMMIT;