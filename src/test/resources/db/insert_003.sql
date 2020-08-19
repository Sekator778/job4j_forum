CREATE EXTENSION IF NOT EXISTS pgcrypto;
update t_user set password = crypt(password, gen_salt('bf', 8));