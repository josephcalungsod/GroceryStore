drop table grocery_store if exists;
drop table grocery_info if exists;

create table if not exists grocery_store
(
    Item varchar(255) not null primary key,
    Price double,
    Quantity int
);

-- produce
insert into grocery_store (Item, Price, Quantity) values ('apple', 1.00, 10);
insert into grocery_store (Item, Price, Quantity) values ('banana', 1.50, 12);
insert into grocery_store (Item, Price, Quantity) values ('milk', 4.00, 20);
insert into grocery_store (Item, Price, Quantity) values ('eggs', 2.30, 30);

-- meat/seafood
insert into grocery_store (Item, Price, Quantity) values ('steak', 3.30, 35);
insert into grocery_store (Item, Price, Quantity) values ('chicken', 2.24, 32);
insert into grocery_store (Item, Price, Quantity) values ('pork', 2.30, 31);
insert into grocery_store (Item, Price, Quantity) values ('fish', 3.00, 20);

-- baby products
insert into grocery_store (Item, Price, Quantity) values ('diapers', 25.00, 15);
insert into grocery_store (Item, Price, Quantity) values ('baby bottle', 3.00, 10);
insert into grocery_store (Item, Price, Quantity) values ('formula', 5.00, 12);

-- international
insert into grocery_store (Item, Price, Quantity) values ('rice', 6.00, 8);
insert into grocery_store (Item, Price, Quantity) values ('taco shells', 2.40, 7);
insert into grocery_store (Item, Price, Quantity) values ('spaghetti', 1.30, 14);
insert into grocery_store (Item, Price, Quantity) values ('fettuccine', 1.20, 16);

-- candy
insert into grocery_store (Item, Price, Quantity) values ('lollipop', 2.30, 30);
insert into grocery_store (Item, Price, Quantity) values ('kit kat', 2.30, 30);
insert into grocery_store (Item, Price, Quantity) values ('jolly ranchers', 1.25, 5);

-- animal food
insert into grocery_store (Item, Price, Quantity) values ('dog food', 20.00, 5);
insert into grocery_store (Item, Price, Quantity) values ('cat food', 18.00, 7);

-- hygiene items
insert into grocery_store (Item, Price, Quantity) values ('soap', 0.55, 55);
insert into grocery_store (Item, Price, Quantity) values ('toothpaste', 3.50, 40);
insert into grocery_store (Item, Price, Quantity) values ('shampoo', 4.00, 35);

-- paper products
insert into grocery_store (Item, Price, Quantity) values ('paper towels', 2.00, 44);
insert into grocery_store (Item, Price, Quantity) values ('toilet paper', 2.00, 28);
insert into grocery_store (Item, Price, Quantity) values ('paper plates', 2.00, 22);
insert into grocery_store (Item, Price, Quantity) values ('napkins', 0.80, 50);


CREATE TABLE IF NOT EXISTS grocery_info (
    item_id INT unique ,
    Item VARCHAR(255) NOT NULL primary key,
    farm_name VARCHAR(255),
    brand VARCHAR(255),
    contact VARCHAR(255)
);

insert into grocery_info(item_id, Item, farm_name, brand, contact)values (1, 'APPLE','farm_1','new','111-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, contact)values (2, 'BANANA','farm_2','new','222-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, contact)values (3, 'ORANGE','farm_3','new','333-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, contact)values (4, 'TOMATO','farm_4','new','555-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, contact)values (5, 'CARROT','farm_5','new','');