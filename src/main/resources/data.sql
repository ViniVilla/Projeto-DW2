delete from usuarios;
insert into usuarios (id, username, password, nome, email) values (1, 'vini', '$2a$10$2Le2P9CME2CqApkJ9kIsbuN48OEFwVeZ7oYraGPf0w5vxNaE7Htbq', 'Vinicius Villa', 'vinicius.villa@ifsp.com', '16 123456789');

delete from papeis;
insert into papeis (usuario_id, papel) values (1, 'ROLE_USER');