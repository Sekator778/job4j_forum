insert into t_user (id, username, password)
values (1, 'admin', 'admin');
insert into t_user_roles (user_id, roles_id)
VALUES (1, 1),
       (1, 2);