drop table grocery_store if exists;
drop table grocery_info if exists;

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


-- baby products
insert into grocery_store (Item, Type, Price, Quantity) values ('diapers', 'baby products', 25.00, 15);
insert into grocery_store (Item, Type, Price, Quantity) values ('baby bottle', 'baby products', 3.00, 10);
insert into grocery_store (Item, Type, Price, Quantity) values ('formula', 'baby products', 5.00, 12);

-- international
insert into grocery_store (Item, Type, Price, Quantity) values ('rice', 'international', 6.00, 8);
insert into grocery_store (Item, Type, Price, Quantity) values ('taco shells', 'international', 2.40, 7);
insert into grocery_store (Item, Type, Price, Quantity) values ('spaghetti', 'international', 1.30, 14);
insert into grocery_store (Item, Type, Price, Quantity) values ('fettuccine', 'international', 1.20, 16);

-- candy
insert into grocery_store (Item, Type, Price, Quantity) values ('lollipop', 'candy', 2.30, 30);
insert into grocery_store (Item, Type, Price, Quantity) values ('kit kat', 'candy', 2.30, 30);
insert into grocery_store (Item, Type, Price, Quantity) values ('jolly ranchers', 'candy', 1.25, 5);

-- animal products
insert into grocery_store (Item, Type, Price, Quantity) values ('dog food', 'animal products', 20.00, 5);
insert into grocery_store (Item, Type, Price, Quantity) values ('cat food', 'animal products', 18.00, 7);
insert into grocery_store (Item, Type, Price, Quantity) values ('cat litter', 'animal products', 16.00, 6);

-- hygiene items
insert into grocery_store (Item, Type, Price, Quantity) values ('soap', 'hygiene', 0.55, 55);
insert into grocery_store (Item, Type, Price, Quantity) values ('toothpaste', 'hygiene', 3.50, 40);
insert into grocery_store (Item, Type, Price, Quantity) values ('shampoo', 'hygiene', 4.00, 35);

-- paper products
insert into grocery_store (Item, Type, Price, Quantity) values ('paper towels', 'paper products', 2.00, 44);
insert into grocery_store (Item, Type, Price, Quantity) values ('toilet paper', 'paper products', 2.00, 28);
insert into grocery_store (Item, Type, Price, Quantity) values ('paper plates', 'paper products', 2.00, 22);
insert into grocery_store (Item, Type, Price, Quantity) values ('napkins', 'paper products', 0.80, 50);


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