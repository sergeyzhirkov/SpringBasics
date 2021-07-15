BEGIN;

DROP TABLE IF EXISTS consumers CASCADE;
CREATE TABLE consumers (id bigserial PRIMARY KEY, name varchar(255));
INSERT INTO consumers (name) VALUES ('cons1'), ('cons2'), ('cons3');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES ('prod1', 1), ('prod2', 2);

DROP TABLE IF EXISTS market CASCADE;
CREATE TABLE market (product_id bigint, consumer_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (consumer_id) REFERENCES consumers (id));
INSERT INTO market (product_id, consumer_id) VALUES (1, 1), (1, 2), (2, 1), (1, 3), (2, 3);

COMMIT;