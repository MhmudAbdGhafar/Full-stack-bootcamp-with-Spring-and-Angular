create database productDB;
use productDB;

create table product_details(
                                id int auto_increment primary key ,
                                expiration_date date not null,
                                manufacturer varchar(255) not null ,
                                price double not null ,
                                available boolean not null default false
);

create table product(
                        id int auto_increment primary key ,
                        name varchar(255) not null,
                        product_details_id int not null,
                        foreign key (product_details_id) references product_details(id)
);

INSERT INTO product_details (manufacturer, expiration_date, price, available) VALUES ('milk', '2024-02-08',  30, 1);
INSERT INTO product_details (manufacturer, expiration_date, price, available) VALUES ('fish', '2024-02-15',  100, 1);
INSERT INTO product_details (manufacturer, expiration_date, price, available) VALUES ('cheese', '2024-06-11',  50, 1);
INSERT INTO product_details (manufacturer, expiration_date, price, available) VALUES ('chocolate ', '2024-02-29',  60, 0);

INSERT INTO product (name, product_details_id) VALUES ('milk', 1);
INSERT INTO product (name, product_details_id) VALUES ('fish', 2);
INSERT INTO product (name, product_details_id) VALUES ('cheese', 3);
INSERT INTO product (name, product_details_id) VALUES ('chocolate', 4);