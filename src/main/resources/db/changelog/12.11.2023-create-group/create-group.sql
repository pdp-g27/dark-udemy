create type group_type as enum ('BOOTCAMP' , 'FOUNDATION' );
create type group_status as enum ('CANCELED' , 'IN_PROGRESS','FINISHED','PAUSED');


create table "group"
(
    id           uuid primary key,
    name         varchar(30)  not null,
    mentor_id    uuid         not null,
    start_date   timestamp    not null,
    group_type   group_type   not null,
    group_status group_status not null
);