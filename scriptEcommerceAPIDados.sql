INSERT INTO categoria (nome,descricao) VALUES
	 ('Jogos','Joguinhos'),
	 ('Lavanderia','Lavanderiazinhas'),
	 ('Paisagismo','Paisagismozinhos'),
	 ('Automoveis','Automoveizinhos');
	 
	
insert into endereco (cep, rua, bairro, cidade, numero, complemento, estado) values 
('267853-375', 'São Paulo', 'Boa Vista', 'Brasília', '7065', 'Andar 7', 'Distrito Federal' ),
('72884-020', 'da Paz', 'São Cristóvão', 'Teresina', '1409', 'Andar 2', 'Piauí' ), 
('70865-384', 'Doze', 'Industrial', 'Luiânia', '3407', 'Andar 7', 'Goânia' ), 
('29656-292', 'Piauí', 'São Francisco', 'Jaboatão dos Guararapes', '2157', 'Galpao 2', 'Pernambuco'), 
('57875-464', 'Dom Pedro II', 'Santo Antônio', 'Eunápolis', '5765B', 'Lote 2', 'Bahia' );

insert into cliente (email, username, senha, nome, cpf, telefone, datanascimento, id_endereco) values
('Danilo@email.com','Danl','123','Danilo', '12345678910','2222-2222','2003-03-24',1),
('Lucas@email.com','lucf','112','Lucas', '12345678911','3333-3333','1994-09-17',2),
('Ian@email.com','Ina','111','Ian', '12345678912','4444-4444','1998-06-02',3),
('Alan@email.com','Anl','223','Alan', '12345678913','5555-5555','1992-04-06',4);

insert into produto (nome, descricao, preco, qtdestoque, datacadastro, id_categoria, imagem) values
('Playstation', 'consolezinho',5000,55,'2020-11-12',1,'https://wallpapercave.com/wp/wp6967907.png'),
('Maquina de Lavar','maquinazinha',2000,24,'2017-02-23',2,'https://wallpapercave.com/wp/wp2827003.jpg'),
('Bonsai','arvorezinha',120,2,'2000-09-21',3,'https://wallpapercave.com/wp/UaWiDnX.jpg'),
('Pneu','pneuzinho',380,400,'2015-01-21',4,'https://wallpapercave.com/wp/wp2194277.jpg');

insert into pedidos (numeropedido, totalpedido, datapedido, status, id_cliente) values
(1,220,'2021-06-09','aberto',1),
(2,220,'2021-06-09','fechado',1),
(3,220,'2021-06-09','aberto',3),
(4,220,'2021-06-09','aberto',4),
(5,220,'2021-06-09','aberto',4);

insert into produtos_pedidos (id_produto, id_pedidos,preco,quantidade) values 
(1,1,5000,1),
(3,3,240,2);
