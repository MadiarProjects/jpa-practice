create table task
(
    id          bigserial primary key,
    tittle      varchar(100)  not null,
    descreption varchar(5000) not null,
    status      varchar(20)   not null,
    priority    varchar(20)   not null check ( priority in ('LOW', 'NORMAL', 'HIGH', 'SPECIAL')),
    created_at  timestamp     not null
);

create table users
(
    id bigserial primary key ,
    role INTEGER check ( role in (1,2,3) ),
    login VARCHAR(100) UNIQUE NOT NULL ,
    password VARCHAR(20) NOT NULL ,
    registration_date TIMESTAMP NOT NULL
);
create table orders
(
    id bigserial primary key ,
    user_id bigint references users(id),
    status INTEGER not null  ,
    delivery_address varchar(200)  not null ,
    registration_date timestamp not null
);
create table order_products
(
    id bigserial primary key ,
    product_id bigint references products(id),
    count int8 not null ,
    order_id bigint references orders(id)
);
create table feed_back
(
    id bigserial primary key ,
    user_id bigserial references users(id),
    product_id bigserial references products(id),
    is_published boolean not null ,
    rate int2 not null check ( rate between 1 and 5),
    text varchar(500) not null ,
    publish_date timestamp
);
