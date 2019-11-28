delete from usuarios;
--Senha do admin = 123123
insert into usuarios (id, username, password, nome, email, telefone) values (1, 'vini', '$2y$10$UTKb.mhBCyBlg/P3vAAOv.zXy2OJngp0HZd5EuHIJs4gLzRVrqdRm', 'Vinicius Villa', 'vinicius.villa@ifsp.com', '16 123456789');

--ordem de servico para testes
--insert into endereco(id, cidade, bairro, rua) values (1, 'cidade', 'bairro', 'rua');
--insert into ordem_servico(id, usuario_id, endereco_id, plano, data_criacao, data_atribuicao) values (1, 1, 1, 'MONO', '2019-11-10', '2019-11-15');

delete from papeis;
insert into papeis (usuario_id, papel) values (1, 'ROLE_USER');
insert into papeis (usuario_id, papel) values (1, 'ROLE_ADMIN');