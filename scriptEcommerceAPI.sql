CREATE TABLE Categoria (
	id_categoria serial PRIMARY key NOT NULL,
	nome varchar(100) NOT NULL,
	descricao varchar(100) NULL	
);

--ALTER TABLE public.categoria RENAME COLUMN id TO id_categoria;

create table Endereco (
	id_endereco serial primary key not null,
	cep varchar(100) not null,
	rua varchar(100),
	bairro varchar(100),
	cidade varchar(100),
	numero varchar(100),
	complemento varchar(100),
	estado varchar(100)
);


create  table Cliente (
	id_cliente serial primary key not null,
	email varchar(50) not null,
	username varchar(50) unique not null,
	senha varchar(50) not null,
	nome varchar(100) not null,
	cpf varchar(11) not null,
	telefone varchar (50) not null,
	datanascimento date not null,
	id_endereco int not null REFERENCES endereco (id_endereco)
);

create table Produto ( 
	id_produto serial primary key not null,
	nome varchar(100) not null,
	descricao varchar(100) not null,
	preco decimal not null,
	qtdestoque int4 not null,
	datacadastro date not null,
	imagem varchar(100),
	id_categoria int not null references categoria (id_categoria)
);


create table Pedidos ( 
	id_pedidos serial primary key not null,
	numeropedido int4 not null,
	totalpedido decimal not null,
	datapedido date not null,
	status varchar(50) not null,
	id_cliente int not null references cliente (id_cliente)
);

create table produtos_pedidos ( 
	id_produto_pedidos serial primary key not null,
	id_produto int not null references produto (id_produto),
	id_pedidos int not null references pedidos (id_pedidos),
	quantidade Integer not null,
	preco decimal not null
);



