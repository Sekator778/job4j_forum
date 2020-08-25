drop table if exists post cascade;
drop table if exists t_role cascade;
drop table if exists t_user cascade;
drop table if exists t_user_roles cascade;

create table if not exists post
(
    id          int8 generated by default as identity,
    created     timestamp,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);
create table if not exists t_role
(
    id   int8 not null,
    name varchar(255),
    primary key (id)
);
create table if not exists t_user
(
    id       int8 generated by default as identity,
    password varchar(255),
    username varchar(255),
    primary key (id)
);
create table if not exists t_user_roles
(
    user_id  int8 not null,
    roles_id int8 not null,
    primary key (user_id, roles_id)
);
alter table if exists t_user_roles
    add constraint FKj47yp3hhtsoajht9793tbdrp4 foreign key (roles_id) references t_role;
alter table if exists t_user_roles
    add constraint FKpqntgokae5e703qb206xvfdk3 foreign key (user_id) references t_user;


insert into t_role (id, name)
values ('1', 'ROLE_USER');
insert into t_role (id, name)
values ('2', 'ROLE_ADMIN');