create type user_type as enum ('STUDENT' , 'MENTOR' , 'ASSISTANT' , 'ADMIN');


create table "user"
(
    id           uuid primary key,
    first_name   varchar(20)  not null,
    last_name    varchar(20)  not null,
    middle_name  varchar(20),
    user_type    user_type    not null,
    phone_number varchar(20)  not null,
    email        varchar(320) not null,
    password     varchar      not null
)