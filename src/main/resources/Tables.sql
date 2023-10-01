drop table if exists grocery_info ;
drop table if exists grocery_store ;
drop table if exists customer ;
drop table if exists orders ;

create table if not exists grocery_store
(
    Item varchar(255) not null primary key,
    Type varchar(255),
    Price double,
    Quantity int
);

-- produce
insert into grocery_store (Item, Type, Price, Quantity) values ('apple', 'produce', 1.00, 10);
insert into grocery_store (Item, Type, Price, Quantity) values ('banana', 'produce', 1.50, 12);
insert into grocery_store (Item, Type, Price, Quantity) values ('milk', 'produce', 4.00, 20);
insert into grocery_store (Item, Type, Price, Quantity) values ('eggs', 'produce', 2.30, 30);

-- meat
insert into grocery_store (Item, Type, Price, Quantity) values ('steak', 'meat', 3.30, 35);
insert into grocery_store (Item, Type, Price, Quantity) values ('chicken', 'meat', 2.24, 32);
insert into grocery_store (Item, Type, Price, Quantity) values ('pork', 'meat', 2.30, 31);


-- baby_products
insert into grocery_store (Item, Type, Price, Quantity) values ('diapers', 'baby_products', 25.00, 15);
insert into grocery_store (Item, Type, Price, Quantity) values ('baby_bottle', 'baby_products', 3.00, 10);
insert into grocery_store (Item, Type, Price, Quantity) values ('formula', 'baby_products', 5.00, 12);

-- international
insert into grocery_store (Item, Type, Price, Quantity) values ('rice', 'international', 6.00, 8);
insert into grocery_store (Item, Type, Price, Quantity) values ('taco_shells', 'international', 2.40, 7);
insert into grocery_store (Item, Type, Price, Quantity) values ('spaghetti', 'international', 1.30, 14);
insert into grocery_store (Item, Type, Price, Quantity) values ('fettuccine', 'international', 1.20, 16);

-- candy
insert into grocery_store (Item, Type, Price, Quantity) values ('lollipop', 'candy', 2.30, 30);
insert into grocery_store (Item, Type, Price, Quantity) values ('kit_kat', 'candy', 2.30, 30);
insert into grocery_store (Item, Type, Price, Quantity) values ('jolly_ranchers', 'candy', 1.25, 5);

-- animal_products
insert into grocery_store (Item, Type, Price, Quantity) values ('dog_food', 'animal_products', 20.00, 5);
insert into grocery_store (Item, Type, Price, Quantity) values ('cat_food', 'animal_products', 18.00, 7);
insert into grocery_store (Item, Type, Price, Quantity) values ('cat_litter', 'animal_products', 16.00, 6);

-- hygiene_items
insert into grocery_store (Item, Type, Price, Quantity) values ('soap', 'hygiene', 0.55, 55);
insert into grocery_store (Item, Type, Price, Quantity) values ('toothpaste', 'hygiene', 3.50, 40);
insert into grocery_store (Item, Type, Price, Quantity) values ('shampoo', 'hygiene', 4.00, 35);

-- paper_products
insert into grocery_store (Item, Type, Price, Quantity) values ('paper_towels', 'paper_products', 2.00, 44);
insert into grocery_store (Item, Type, Price, Quantity) values ('toilet_paper', 'paper_products', 2.00, 28);
insert into grocery_store (Item, Type, Price, Quantity) values ('paper_plates', 'paper_products', 2.00, 22);
insert into grocery_store (Item, Type, Price, Quantity) values ('napkins', 'paper_products', 0.80, 50);


CREATE TABLE IF NOT EXISTS grocery_info (
    item_id INT primary key auto_increment(100,1),
    Item VARCHAR(255) NOT NULL UNIQUE,
    farm_name VARCHAR(255),
    brand VARCHAR(255),
    contact VARCHAR(255),
    FOREIGN KEY (Item) REFERENCES grocery_store(Item)
);

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('apple', 'naboo_fruit_garden', 'Apple Brand', '111-111-1111');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('banana', 'naboo_fruit_garden', 'Banana Brand', '222-222-2222');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('milk', 'mos_eisley_cow_farm', 'Milk Brand', '333-333-3333');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('eggs', 'skywalker_ranch', 'Eggs Brand', '444-444-4444');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('steak', 'skywalker_ranch', 'Steak Brand', '555-555-5555');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('chicken', 'skywalker_ranch', 'Chicken Brand', '666-666-6666');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('pork', 'dantooine_swine', 'Pork Brand', '777-777-7777');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('diapers', '', '', '888-888-8888');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('baby_bottle', '', 'Baby Bottle Brand', '999-999-9999');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('formula', 'kessel', 'Formula Brand', '000-000-0000');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('rice', '', 'Rice Brand', '111-111-1111');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('taco_shells', '', 'Taco Shells Brand', '222-222-2222');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('spaghetti', '', 'Spaghetti Brand', '333-333-3333');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('fettuccine', '', 'Fettuccine Brand', '444-444-4444');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('lollipop', '', 'Lollipop Brand', '555-555-5555');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('kit_kat', '', 'Kit Kat Brand', '666-666-6666');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('jolly_ranchers', '', 'Jolly Ranchers Brand', '777-777-7777');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('dog_food', 'lothal_feed', 'Dog Food Brand', '888-888-8888');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('cat_food', 'lothal_feed', 'Cat Food Brand', '999-999-9999');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('cat_litter', '', 'Cat Litter Brand', '000-000-0000');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('soap', '', 'Soap Brand', '111-111-1111');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('toothpaste', '', 'Toothpaste Brand', '222-222-2222');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('shampoo', '', 'Shampoo Brand', '333-333-3333');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('paper_towels', 'kashyyyk_forests', 'Paper Towels Brand', '444-444-4444');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('toilet_paper', 'kashyyyk_forests', 'Toilet Paper Brand', '555-555-5555');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('paper_plates', 'kashyyyk_forests', 'Paper Plates Brand', '666-666-6666');

INSERT INTO grocery_info (Item, Farm_name, Brand, Contact)
VALUES ('napkins', 'kashyyyk_forests', 'Napkins Brand', '777-777-7777');


create table if not exists customer (
    customer_id int unique not null primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    city varchar(255),
    zip_code int
);

insert into customer(first_name, last_name, city, zip_code) values ('han', 'solo', 'corellia', 00000);
insert into customer(first_name, last_name, city, zip_code) values ('leia', 'organa', 'alderaan', 11111);
insert into customer(first_name, last_name, city, zip_code) values ('luke', 'skywalker', 'tatooine', 22222);

CREATE TABLE orders (
                        orderId INT PRIMARY KEY auto_increment,
                        orderDate DATE,
                        orderContent TEXT,
                        customerId INT
);

