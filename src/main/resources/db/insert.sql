drop table if exists t_role cascade;
create table t_role
(
    id   int8 not null,
    name varchar(255),
    primary key (id)
);
insert into t_role (id, name)
values ('1', 'ROLE_USER');
insert into t_role (id, name)
values ('2', 'ROLE_ADMIN');