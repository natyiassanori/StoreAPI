CREATE DATABASE IF NOT EXISTS store_schema;
USE store_schema;

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE `store_schema`.`seller` (
  `seller_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`seller_id`));
  
  CREATE TABLE `store_schema`.`product_category` (
  `product_category_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`product_category_id`));
  
  CREATE TABLE `store_schema`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `description` VARCHAR(300) NULL,
  `creation_date` DATETIME NULL,
  `score` FLOAT NULL,
  `product_category_id` INT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `product_category_id_idx` (`product_category_id` ASC) VISIBLE,
  CONSTRAINT `product_category_id`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `store_schema`.`product_category` (`product_category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `store_schema`.`sale` (
  `sale_id` INT NOT NULL AUTO_INCREMENT,
  `seller_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `evaluation` FLOAT NULL,
  PRIMARY KEY (`sale_id`, `customer_id`, `product_id`),
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `seller_id`
    FOREIGN KEY (`seller_id`)
    REFERENCES `store_schema`.`seller` (`seller_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `store_schema`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `store_schema`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
#Inserts into product_category table
INSERT INTO product_category (description) VALUE ('technology');
INSERT INTO product_category (description) VALUE ('sports');
INSERT INTO product_category (description) VALUE ('science');
INSERT INTO product_category (description) VALUE ('health');
INSERT INTO product_category (description) VALUE ('general');


#Inserts into customer table

INSERT INTO customer (name) VALUE ('Keanu Reeeves');
INSERT INTO customer (name) VALUE ('Angelina Jolie');
INSERT INTO customer (name) VALUE ('Brad Pitt');
INSERT INTO customer (name) VALUE ('Leonardo DiCaprio ');
INSERT INTO customer (name) VALUE ('Gisele Bündchen');
INSERT INTO customer (name) VALUE ('Xuxa Meneghel');
INSERT INTO customer (name) VALUE ('Bruna Marquezine');
INSERT INTO customer (name) VALUE ('Neymar Júnior');
INSERT INTO customer (name) VALUE ('Johnny Depp');
INSERT INTO customer (name) VALUE ('Carrie Fisher');
INSERT INTO customer (name) VALUE ('George Lucas');
INSERT INTO customer (name) VALUE ('Christopher Nolan');
INSERT INTO customer (name) VALUE ('Kate Winslet');
INSERT INTO customer (name) VALUE ('Marina Ruy Barbosa');
INSERT INTO customer (name) VALUE ('Tom Cruise');
INSERT INTO customer (name) VALUE ('Madonna Ciccone');
INSERT INTO customer (name) VALUE ('Britney Spears');
INSERT INTO customer (name) VALUE ('Taylor Swift');
INSERT INTO customer (name) VALUE ('Donald Trump');
INSERT INTO customer (name) VALUE ('Joe Biden');
INSERT INTO customer (name) VALUE ('Jennifer Aniston');
INSERT INTO customer (name) VALUE ('Oprah Winfrey');
INSERT INTO customer (name) VALUE ('Tom Hanks');
INSERT INTO customer (name) VALUE ('Katy Perry');
INSERT INTO customer (name) VALUE ('Will Smith');
INSERT INTO customer (name) VALUE ('Matt Damon');
INSERT INTO customer (name) VALUE ('Cristiano Ronaldo');
INSERT INTO customer (name) VALUE ('Jennifer Lopez');
INSERT INTO customer (name) VALUE ('Justin Bieber');
INSERT INTO customer (name) VALUE ('George Clooney');
INSERT INTO customer (name) VALUE ('Julia Roberts');
INSERT INTO customer (name) VALUE ('Barack Obama');
INSERT INTO customer (name) VALUE ('Elton John');
INSERT INTO customer (name) VALUE ('Jessica Alba');
INSERT INTO customer (name) VALUE ('Kevin Hart');
INSERT INTO customer (name) VALUE ('Serena Williams');
INSERT INTO customer (name) VALUE ('Steven Spielberg');
INSERT INTO customer (name) VALUE ('Robert Downey Jr');
INSERT INTO customer (name) VALUE ('Emma Wtson');
INSERT INTO customer (name) VALUE ('Celine Dion');
INSERT INTO customer (name) VALUE ('Ariana Grande');
INSERT INTO customer (name) VALUE ('Kim Kardashian');
INSERT INTO customer (name) VALUE ('Antônio Fagundes');
INSERT INTO customer (name) VALUE ('Miguel Falabella');
INSERT INTO customer (name) VALUE ('Vera Fischer');
INSERT INTO customer (name) VALUE ('José de Abreu');
INSERT INTO customer (name) VALUE ('Renato Aragão');
INSERT INTO customer (name) VALUE ('Glória Menezes');
INSERT INTO customer (name) VALUE ('Bruno Gagliasso');
INSERT INTO customer (name) VALUE ('Adriana Esteves');
INSERT INTO customer (name) VALUE ('Fausto Silva');
INSERT INTO customer (name) VALUE ('Taís Araújo');
INSERT INTO customer (name) VALUE ('Susana Vieira');
INSERT INTO customer (name) VALUE ('Bianca Bin');
INSERT INTO customer (name) VALUE ('Zeca Camargo');
INSERT INTO customer (name) VALUE ('Pedro Bial');
INSERT INTO customer (name) VALUE ('Glória Maria');
INSERT INTO customer (name) VALUE ('Aguinaldo Silva');
INSERT INTO customer (name) VALUE ('Elon Musk');
INSERT INTO customer (name) VALUE ('Bill Gates');
INSERT INTO customer (name) VALUE ('Larry Page');
INSERT INTO customer (name) VALUE ('Sergey Brin');
INSERT INTO customer (name) VALUE ('Mark Zuckerberg');
INSERT INTO customer (name) VALUE ('João Pedro Resende');
INSERT INTO customer (name) VALUE ('Courteney Cox');
INSERT INTO customer (name) VALUE ('Matthew Perry');
INSERT INTO customer (name) VALUE ('Lisa Kudrow');
INSERT INTO customer (name) VALUE ('Matt LeBlanc');
INSERT INTO customer (name) VALUE ('Luiz Henrique Mandetta');
INSERT INTO customer (name) VALUE ('Nelson Teich');
INSERT INTO customer (name) VALUE ('Adam Driver');
INSERT INTO customer (name) VALUE ('Harrison Ford');
INSERT INTO customer (name) VALUE ('Mark Hamill');
INSERT INTO customer (name) VALUE ('Daniel Radcliffe');
INSERT INTO customer (name) VALUE ('Rupert Grint');
INSERT INTO customer (name) VALUE ('Michael Gambom');
INSERT INTO customer (name) VALUE ('Elijah Wood');
INSERT INTO customer (name) VALUE ('Ian McKellen');
INSERT INTO customer (name) VALUE ('Orlando Bloom');
INSERT INTO customer (name) VALUE ('Viggo Mortensen');
INSERT INTO customer (name) VALUE ('Sean Astin');
INSERT INTO customer (name) VALUE ('Liv Tyler');
INSERT INTO customer (name) VALUE ('Karl Urban');
INSERT INTO customer (name) VALUE ('Cate Blanchett');
INSERT INTO customer (name) VALUE ('Miranda Otto');
INSERT INTO customer (name) VALUE ('David Wenham');
INSERT INTO customer (name) VALUE ('Sala Baker');
INSERT INTO customer (name) VALUE ('Iam Holm');
INSERT INTO customer (name) VALUE ('Meghan Trainor');
INSERT INTO customer (name) VALUE ('Megan Fox');
INSERT INTO customer (name) VALUE ('Fátima Bernardes');
INSERT INTO customer (name) VALUE ('William Bonner');
INSERT INTO customer (name) VALUE ('Tom Brady');
INSERT INTO customer (name) VALUE ('Adriana Lima');
INSERT INTO customer (name) VALUE ('Alessandra Ambrósio');
INSERT INTO customer (name) VALUE ('Paola Carosella');
INSERT INTO customer (name) VALUE ('Henrique Fogaça');
INSERT INTO customer (name) VALUE ('Erick Jacquin');
INSERT INTO customer (name) VALUE ('Ana Paula Padrão');
INSERT INTO customer (name) VALUE ('Luciano Huck');


#Inserts into seller table

INSERT INTO seller (name) VALUE ('Natália Iassanori');
INSERT INTO seller (name) VALUE ('Diego Xisto');
INSERT INTO seller (name) VALUE ('Marina Blanc');
INSERT INTO seller (name) VALUE ('Vitória Oliveira');
INSERT INTO seller (name) VALUE ('Bruno Volpini');
INSERT INTO seller (name) VALUE ('Carla Fagundes');
INSERT INTO seller (name) VALUE ('Antônio Oswaldo');
INSERT INTO seller (name) VALUE ('Josué Carlos');
INSERT INTO seller (name) VALUE ('João Rios');
INSERT INTO seller (name) VALUE ('Lídia Ribeiro');
INSERT INTO seller (name) VALUE ('Fátima Andrade');
INSERT INTO seller (name) VALUE ('Amora Oliveira');
INSERT INTO seller (name) VALUE ('Amanda Nodari');
INSERT INTO seller (name) VALUE ('Nathalia Oliveira');
INSERT INTO seller (name) VALUE ('Thiago Silva');
INSERT INTO seller (name) VALUE ('Gustavo Torres');
INSERT INTO seller (name) VALUE ('Marcelo Araújo');
INSERT INTO seller (name) VALUE ('Tomaz Andrade');
INSERT INTO seller (name) VALUE ('Capitu Pádua');
INSERT INTO seller (name) VALUE ('Bento Rodrigues');
INSERT INTO seller (name) VALUE ('Antônio Carlos');
INSERT INTO seller (name) VALUE ('Henrique Rocha');
INSERT INTO seller (name) VALUE ('Tayanne Pessoa');
INSERT INTO seller (name) VALUE ('Giovanni Araújo');
INSERT INTO seller (name) VALUE ('Ian Nerole');
INSERT INTO seller (name) VALUE ('Thiago Fausto');
INSERT INTO seller (name) VALUE ('Maria Staples');
INSERT INTO seller (name) VALUE ('Alice Codama');
INSERT INTO seller (name) VALUE ('Akemi Nonato');
INSERT INTO seller (name) VALUE ('Fernanda Taniguchi');
INSERT INTO seller (name) VALUE ('Isabella Andrade');
INSERT INTO seller (name) VALUE ('Pedro Oliveira');
INSERT INTO seller (name) VALUE ('Eduardo Almeida');
INSERT INTO seller (name) VALUE ('Romilda Xisto');
INSERT INTO seller (name) VALUE ('Marinete Almeida');
INSERT INTO seller (name) VALUE ('Marlete Macedo');
INSERT INTO seller (name) VALUE ('Rose Yassunaga');
INSERT INTO seller (name) VALUE ('Sônia Michelle');
INSERT INTO seller (name) VALUE ('Aline Honda');
INSERT INTO seller (name) VALUE ('Camilla Fluciano');
INSERT INTO seller (name) VALUE ('André Gonçalves');
INSERT INTO seller (name) VALUE ('Raphael Chagas');
INSERT INTO seller (name) VALUE ('Milena Ribeiro');
INSERT INTO seller (name) VALUE ('Maria Joaquina');
INSERT INTO seller (name) VALUE ('Pablo Hueda');
INSERT INTO seller (name) VALUE ('Antônio Lisboa');
INSERT INTO seller (name) VALUE ('Eni de Jesus');
INSERT INTO seller (name) VALUE ('Débora Bandeira');
INSERT INTO seller (name) VALUE ('Sandra Bandeira');
INSERT INTO seller (name) VALUE ('Nelson Cardoso');
INSERT INTO seller (name) VALUE ('Geiverson Pedro');
INSERT INTO seller (name) VALUE ('Carmelita de Almeida');
INSERT INTO seller (name) VALUE ('Sarah Kubishek');
INSERT INTO seller (name) VALUE ('Angelina Yamada');
INSERT INTO seller (name) VALUE ('Maria do Carmo Pinheiros');
INSERT INTO seller (name) VALUE ('Cecília Carmela');
INSERT INTO seller (name) VALUE ('Pedro Ladeira');
INSERT INTO seller (name) VALUE ('Aline Assis');
INSERT INTO seller (name) VALUE ('Natália Vaz');
INSERT INTO seller (name) VALUE ('Karen Pinheiros');
INSERT INTO seller (name) VALUE ('Rômulo Figueiredo');
INSERT INTO seller (name) VALUE ('Caio Cradoso');
INSERT INTO seller (name) VALUE ('Ítalo Sena');
INSERT INTO seller (name) VALUE ('Arthur Silva');
INSERT INTO seller (name) VALUE ('Joselina Andrade');
INSERT INTO seller (name) VALUE ('Enzo Ribas');
INSERT INTO seller (name) VALUE ('João Pedro Corrêa');
INSERT INTO seller (name) VALUE ('Matheus Goulart');
INSERT INTO seller (name) VALUE ('Franscisco Oliveira');
INSERT INTO seller (name) VALUE ('Raphael Quirino');
INSERT INTO seller (name) VALUE ('Marcela Natsumy');
INSERT INTO seller (name) VALUE ('Marcela Ceribelli');
INSERT INTO seller (name) VALUE ('João Goulart');
INSERT INTO seller (name) VALUE ('Eustáquio Doril');
INSERT INTO seller (name) VALUE ('Fátima Donichelli');
INSERT INTO seller (name) VALUE ('Michael Fran');
INSERT INTO seller (name) VALUE ('Estella Zollinger');
INSERT INTO seller (name) VALUE ('Marcelo Coeli');
INSERT INTO seller (name) VALUE ('Ricardo Marsellha');
INSERT INTO seller (name) VALUE ('Bruno Oliveira');
INSERT INTO seller (name) VALUE ('Carlos Romeu');
INSERT INTO seller (name) VALUE ('Naira Yassunaga');
INSERT INTO seller (name) VALUE ('Edimarcos Macedo');
INSERT INTO seller (name) VALUE ('Paulo Cascardo');
INSERT INTO seller (name) VALUE ('Daniela Cruz');
INSERT INTO seller (name) VALUE ('Heitor Amaral');
INSERT INTO seller (name) VALUE ('Silvia Pereira');
INSERT INTO seller (name) VALUE ('Maíra Cruz');
INSERT INTO seller (name) VALUE ('Mateus Soares');
INSERT INTO seller (name) VALUE ('Pedro Gordon');
INSERT INTO seller (name) VALUE ('Marco Oliveira');
INSERT INTO seller (name) VALUE ('Magda Lamêr');
INSERT INTO seller (name) VALUE ('Laís Yoshi');
INSERT INTO seller (name) VALUE ('Paulo Santos');
INSERT INTO seller (name) VALUE ('Enzo Ribeiro');
INSERT INTO seller (name) VALUE ('Valentina Camarões');
INSERT INTO seller (name) VALUE ('Josué Kalil');
INSERT INTO seller (name) VALUE ('Luíza Fiúza');
INSERT INTO seller (name) VALUE ('Edmar Costa');
INSERT INTO seller (name) VALUE ('Tainá Cruz');


#Insert into product table

#general
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Liçãozinha', 'O LIÇÃOZINHA foi criado com o objetivo de ajudar crianças em seu aprendizado escolar, aqui além de aprender, brincar e passar um tempo longe da internet, a criança ainda vai compartilhar momentos de aprendizado com você. ', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Curso de Formação de Terapeuta Holístico', 'Formação completa em terapeuta holístico. Curso registrado na Biblioteca Nacional e reconhecido pela Abrath.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-15 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Curso de Depilação Profissional ', 'O curso capacita o estudante em como retirar superficial ou completamente os pelos do corpo através do uso de produtos e equipamentos adequados, o conteúdo é atualizado com as novas tendências da área com frequência.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-10-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Curso de Barbeiro Online', 'O primeiro curso te ensina tudo passo a passo, com certificado incluso e acesso vitalicio.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-15 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Academia do Importador', 'O curso Academia do Importador vai te ensinar todos os passos para comprar produtos de marca e com desconto diretamente dos Estados Unidos. sem sair de casa.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-05-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Design Gráfico para Social Media', 'Já pensou em receber além das vídeo aulas do curso, um Super Pack com mais de 40 artes prontas e inúmeros recursos para criar suas próprias artes?', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-17 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Dieta de 21 dias', 'Agora a Dieta de 21 dias conta com um Aplicativo Exclusivo para facilitar sua perda de peso e queima de gordura.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-15 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Formação em PNL Practitioner', 'Esta Formação em PNL Practitioner oferece um conjunto de ferramentas de aplicação prática, fácil e imediata para uso pessoal e profissional.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-10-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('How To Get Paid as a Virtual Speaker', 'Renowned international speaker and branding expert Brian Rashid welcomes you to his video series', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Custom Birthday Cancles ART & BUSINESS Comprehensive Course', 'In this one-stop training, you will learn how to master the art of doing custom birthday candles and start your delightful and profitable business in no time.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-07 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Online Course Resin Art - 3D Ocean Technique', 'The Flow, Resin Art Company created in Australia brings an exclusive on line course step by step on how to do our stunning 3D ocean technique.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-08 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('START INVEST', 'Um curso online para quem quer aprender do zero, tudo sobre finanças, desde o mindset necessário para se tornar um investidor até investimentos em ações no exterior.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('INVEST ACADEMY 5.0', 'Este curso foi criado para facilitar o entendimento de todos os brasileiros, independente se já sabe alguma coisa ou não sobre finanças.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-10-09 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Bolsa de Valores Paso a Paso', 'Hola amigos inversionistas!! ¿Siempre has querido invertir en bolsa, pero no sabías cómo? ¿También crees que este es el mejor momento para empezar?', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Estratégia MT4', 'MT4 Invest, foi criado com o intuito de levar pessoas comuns, ao primeiro contato com o mercado financeiro. ', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-13 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('MT4 Diretoria', 'MT4 Invest, foi criado com o intuito de levar pessoas comuns, ao primeiro contato com o mercado financeiro. ', (SELECT product_category_id from product_category where product_category_id = 5), '2020-10-06 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Programa Liderança Extraordinária', 'O programa completo do Liderança Extraordinária contém 18 módulos, com o ojetivo de despertar, motivar e formar líderes capazes de enfrentar desafios e mudanças, tornado-os referências em suas áreas de atuação.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-16 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Mestre Investidor', 'Este curso traz segurança para quem quer começar a investir do zero (ou já investe e quer avançar no assunto) e não tem tempo para estudar detalhes técnicos de investimentos nem tempo para acompanhar o mercado.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-14 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Bet Invest VIP', 'Enviaremos vários sinais acertivos durante o dia todos os dias dentro do VIP, aproveite o valor de inauguração que será irrisório perto dos resultados que você vai ter com os nossos sinais diários.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-08 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Value Investing: do básico ao avançado', 'Treinamento completo para se tornar um investidor profissional', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-09 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Value Investing de 0 a 100', 'Taller en directo para aprender a invertir en las mejores compañías del mundo, una formación de altísimo valor a un precio muy reducido con motivo del Black Friday.', (SELECT product_category_id from product_category where product_category_id = 5), '2020-11-07 00:00:00');

#sports
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('30 Days To Unbeliebable Sports Speed', 'Now is the time to take your athletic speed to new heights. Have you dreamed of being the most athletic athlete on your team? Do you need the extra speed to get you a scholarship? Now you will get in 30 days what has taken many athletes years and years to gain.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('KET KiteBoarding Mental Training', 'First mental coaching online in the world for the kiteboarder.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Hiit - VS Sports', '15 aulas intensas para você queimar gordura. Existem diversos tipo de treinamento intenso: TABATA, EMON e outros.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Yoga Contigo, um programa de yoga para mejorar tu equilibrio', 'Un programa de yoga creado con mis conocimientos y experiencia de los últimos 8 años con el que vas a conseguir equilibrarte de forma física, mental y espiritual a través de Prácticas de Kundalini Yoga y Viniyoga.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Metodologia Alliance de Ensino - Módulo Iniciantes', 'An online course on how to teach Jiu Jitsu for beginners. Learn step-by-step how Alliance turned into the most successful school in the history of the sport, with its academies always full of happy students.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Comunidade VS Sports - Treinos em casa', 'Você pode fazer de onde quiser e quantas vezes quiser.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Programa Yoga y Pilates desde casa ', 'El primer programa que combina Yoga y Pilates y que te permite seguir decenas de clases y adquirir un enorme aprendizaje guiado por profesional altamente cualificado', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('LinoYoga', 'Praticar yoga a qualquer hora e em qualquer lugar sempre foi o meu lema! E para te ajudar a praticar cada vez mais, criei um plano de assinatura: você vai ter acesso à uma aula de yoga por semana e uma live por mês, tudo online, pelo Instagram, sem sair da sua casa!', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Yogando com a Dana', 'Praticar Yoga é uma escolha. Nossas escolhas trilham nosso caminho.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Yoga Healing ', 'Esse curso é ideal para você que deseja se conectar com a energia de cura e transformação do Yoga.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Yoga En Casa', 'Muchos piensan que el yoga es un fenómeno nuevo, que no tiene nada que ofrecer a la persona promedio. Nada podría estar más lejos de la verdad!', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Programa de Yoga Detox Cuerpo-Mente', 'AYUDA A TU CUERPO A DEPURARSE PARA RECUPERAR EL EQUILIBRIO', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Escola de Yoga Online - Bee Online', 'Escola de yoga online: pratique de qualquer lugar, a qualquer hora, com aulas guiadas, orientações super detalhadas e adaptações para as diversas necessidades.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Musa Fitness ', 'Pensando na rotina das mulheres e adaptando a metodologia de treino que criei, elaborei o Desafio Musa Fitness para despertar em todas as mulheres o empoderamento que todas tem.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Ybay Fitness ', 'A YBAY Fitness tem como principal foco a qualidade de vida elevada, com treinos de até 30 minutos por dia, utilizando apenas o peso do seu corpo praticando onde e quando quiser. ', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('FITNESS CLUB 21', 'TRANSFORME SEU CORPO EM POUCOS MINUTOS POR DIA.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Reto Primal Fitness', 'Este reto está dirigido para hombres y mujeres que desean iniciar el 2020 con un mejor cuerpo, vitalidad, y armonía en tan sólo 21 días como consecuencia de quemar grasa en tiempo récord, y mantenerse con energía y un cuerpo de playa los 365 días del año…¡sin Photoshop!', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Pacote Corpo Fitness', 'Saiba tudo sobre minha dieta, treino e jejum intermitente. O programa Corpo Fitness tem como fundamento a prática do Jejum Intermitente para a saúde e definição corporal. ', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Curso de Bike Fit - Metodologia Infinity Fit', 'A Infinity Fit apresenta o curso de especialização em Bike Fit para formação de novos Fitters.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('Vida Fitness', '¿Somos conscientes de la importancia que tiene llevar una vida ordenada? Podemos lograrlo con una rutina de hábitos saludables en nuestro día a día. La Organización Mundial de la Salud (OMS) recomienda llevar un estilo de vida saludable para mantener una salud fuerte y estable.', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');
INSERT INTO product (name, description, product_category_id, creation_date) VALUES ('BM Academy', 'O Curso BM Academy é um guia completo de construção muscular. Para todos aqueles que almejam o corpo ideal, que querem treinos práticos e diretos, que querem RESULTADOS!', (SELECT product_category_id from product_category where product_category_id = 4), '2020-11-05 00:00:00');





