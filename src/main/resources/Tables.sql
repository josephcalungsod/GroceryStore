drop table grocery_store if exists;
create table if not exists grocery_store(Item varchar(255) not null primary key , Price double, Quantity int);
--insert into grocery_store (Item, Price, Quantity) values ('apple', 1.00, 10);
--insert into grocery_store (Item, Price, Quantity) values ('banana', 1.50, 12);
----insert into grocery_store (Item, Price, Quantity) values ('milk', 4.00, 20);
CREATE TABLE IF NOT EXISTS grocery_info (
    item_id INT unique ,
    Item VARCHAR(255) NOT NULL primary key,
    farm_name VARCHAR(255),
    brand VARCHAR(255),
    organized BOOLEAN,
    contact VARCHAR(255)
);
insert into grocery_info(item_id, Item, farm_name, brand, organized,contact)values (1, 'APPLE','farm_1','new','111-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, organized,contact)values (2, 'BANANA','farm_2','new','222-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, organized,contact)values (3, 'ORANGE','farm_3','new','333-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, organized,contact)values (4, 'TOMATO','farm_4','new','555-222-2222');
insert into grocery_info(item_id, Item, farm_name, brand, organized,contact)values (5, 'CARROT','farm_5','new','');