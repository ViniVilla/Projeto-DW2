drop table if exists usuarios;
create table usuarios (
	id identity primary key,
	username varchar(10) unique not null,
	password varchar(100) not null,
	nome varchar(40) not null,
	email varchar(40) not null,
	telefone varchar(40) not null
);

drop table if exists papeis;
create table papeis (
	id identity primary key,
	usuario_id bigint,
	papel varchar(20) not null
);
alter table papeis add foreign key (usuario_id) references usuarios(id);


drop table if exists ordem_servico;
create table ordem_servico (
    id identity primary key,
    usuario_id bigint not null,
    endereco_id bigint unique not null,
    instalador_id bigint not null,
    plano varchar(25) not null,
    data_criacao date not null,
    data_atribuicao date,
    data_finalizacao date,
    dentro_prazo boolean
);

drop table if exists endereco;
create table endereco (
    id identity primary key,
    cidade varchar(255) not null,
    bairro varchar(255) not null,
    rua varchar(255) not null
);
alter table ordem_servico add foreign key (endereco_id) references endereco(id);