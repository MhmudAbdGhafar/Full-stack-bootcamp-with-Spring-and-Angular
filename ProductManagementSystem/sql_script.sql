create database productDB;
use productDB;

create table product(
                        id int auto_increment primary key,
                        name varchar(255) not null
);

create table product_details(
                                id int auto_increment primary key,
                                expiration_date date not null,
                                manufacturer varchar(255) not null ,
                                price double not null ,
                                available boolean not null default false,
                                product_id int not null,
                                foreign key (product_id) references product(id)
);