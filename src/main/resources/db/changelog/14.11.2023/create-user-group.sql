create table "user"
(
    id           uuid primary key,
    first_name   varchar(20)         not null,
    last_name    varchar(20)         not null,
    middle_name  varchar(20),
    phone_number varchar(20) unique  not null,
    email        varchar(320) unique not null,
    password     varchar             not null
);

create table "group"
(
    id         uuid primary key,
    name       varchar(20) not null,
    group_type varchar     not null
)