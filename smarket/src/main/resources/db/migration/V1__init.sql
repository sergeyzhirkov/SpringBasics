create table categories
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title) values ('Germany'), ('USA'), ('Japan'), ('Korea'), ('Russia');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
insert into products (title, price, category_id)
values
('Mercedes', 85, 1),
('BMW', 75, 1),
('Audi', 80, 1),
('Vaz', 15, 5),
('Porshe', 86, 1),
('Hyundai', 24, 4),
('Kia', 26, 4),
('Subaru', 53, 3),
('Ford', 48, 2),
('Lexus', 60, 3),
('Mazda', 44, 3),
('Toyota', 52, 3);

