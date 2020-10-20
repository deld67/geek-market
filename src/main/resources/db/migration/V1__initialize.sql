create table users (
  id                    bigserial,
  username              varchar(30) not null,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('SOMETHING');

insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

insert into users_roles (user_id, role_id) values (1, 1), (1, 2);


create table category (
                 id                      bigserial primary key,
                 title                   varchar(255)
             );
insert into category (id, title) values
(1, 'Rye bread'),
(2, 'Wheat bread'),
(3,'Pone');


create table products (
    id                      bigserial primary key,
    title                   varchar(255),
    price                   int,
    category_id             bigint references category(id)
);

create table orders (
    id                      bigserial primary key,
    user_id                 bigint references users(id),
    price                   int,
    address                 varchar(1000)
);

create table order_items (
    id                      bigserial primary key,
    product_id              bigint references products(id),
    order_id                bigint references orders(id),
    price                   int,
    price_per_product       int,
    quantity                int
);

insert into products (title, price, category_id)
values
('Bread1', 1,1),
('Bread2', 2,2),
('Bread3', 3,1),
('Bread4', 32,2),
('Bread5', 42,1),
('Bread6', 52,2),
('Bread7', 32,1),
('Bread8', 42,2),
('Bread9', 552,1),
('Bread10', 32,2),
('Bread11', 122,1),
('Bread12', 312,2),
('Bread13', 22,1),
('Bread14', 432,2),
('Bread15', 532,1),
('Bread16', 542,2),
('Bread17', 232,1),
('Bread18', 22,2),
('Bread19', 22,1),
('Bread20', 22,2),
('Bread21', 22,1),
('Bread22', 22,2),
('Bread23', 22,1),
('Bread24', 22,2),
('Bread25', 22,1),
('Cake1', 100, 3),
('Cake2', 105, 3),
('Cake3', 150, 3);
