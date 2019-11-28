delete from usuarios;
--Senha do admin = 123123
insert into usuarios (id, username, password, nome, email, telefone) values (1, 'vini', '$2y$10$UTKb.mhBCyBlg/P3vAAOv.zXy2OJngp0HZd5EuHIJs4gLzRVrqdRm', 'Vinicius Villa', 'vinicius.villa@ifsp.com', '16 123456789');

delete from papeis;
insert into papeis (usuario_id, papel) values (1, 'ROLE_USER');
insert into papeis (usuario_id, papel) values (1, 'ROLE_ADMIN');