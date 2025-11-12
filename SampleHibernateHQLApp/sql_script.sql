create database learn;
use learn;
CREATE TABLE products (
                          product_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          stock_quantity INT NOT NULL,
                          manufacturer VARCHAR(100),
                          production_date DATE
);
INSERT INTO products (name, description, price, stock_quantity, manufacturer, production_date)
VALUES
    ('Product1', 'Description for Product1', 19.99, 100, 'ManufacturerA', '2022-01-01'),
    ('Product2', 'Description for Product2', 29.99, 150, 'ManufacturerB', '2022-02-01'),
    ('Product3', 'Description for Product3', 39.99, 200, 'ManufacturerC', '2022-03-01'),
    ('Product4', 'Description for Product4', 49.99, 120, 'ManufacturerA', '2022-04-01'),
    ('Product5', 'Description for Product5', 59.99, 180, 'ManufacturerB', '2022-05-01' ),
    ('Product6', 'Description for Product6', 69.99, 250, 'ManufacturerC', '2022-06-01' ),
    ('Product7', 'Description for Product7', 79.99, 300, 'ManufacturerA', '2022-07-01' ),
    ('Product8', 'Description for Product8', 89.99, 90, 'ManufacturerB', '2022-08-01' ),
    ('Product9', 'Description for Product9', 99.99, 140, 'ManufacturerC', '2022-09-01' ),
    ('Product10', 'Description for Product10', 109.99, 220, 'ManufacturerA', '2022-10-01' ),
    ('Product11', 'Description for Product11', 119.99, 270, 'ManufacturerB', '2022-11-01' ),
    ('Product12', 'Description for Product12', 129.99, 190, 'ManufacturerC', '2022-12-01' ),
    ('Product13', 'Description for Product13', 139.99, 130, 'ManufacturerA', '2023-01-01' ),
    ('Product14', 'Description for Product14', 149.99, 240, 'ManufacturerB', '2023-02-01' ),
    ('Product15', 'Description for Product15', 159.99, 160, 'ManufacturerC', '2023-03-01' ),
    ('Product16', 'Description for Product16', 169.99, 200, 'ManufacturerA', '2023-04-01' ),
    ('Product17', 'Description for Product17', 179.99, 300, 'ManufacturerB', '2023-05-01' ),
    ('Product18', 'Description for Product18', 189.99, 110, 'ManufacturerC', '2023-06-01' ),
    ('Product19', 'Description for Product19', 199.99, 250, 'ManufacturerA', '2023-07-01' ),
    ('Product20', 'Description for Product20', 209.99, 170, 'ManufacturerB', '2023-08-01' ),
    ('Product21', 'Description for Product21', 219.99, 120, 'ManufacturerC', '2023-09-01' ),
    ('Product22', 'Description for Product22', 229.99, 180, 'ManufacturerA', '2023-10-01' ),
    ('Product23', 'Description for Product23', 239.99, 300, 'ManufacturerB', '2023-11-01' ),
    ('Product24', 'Description for Product24', 249.99, 90, 'ManufacturerC', '2023-12-01' ),
    ('Product25', 'Description for Product25', 259.99, 140, 'ManufacturerA', '2024-01-01' ),
    ('Product26', 'Description for Product26', 269.99, 220, 'ManufacturerB', '2024-02-01' ),
    ('Product27', 'Description for Product27', 279.99, 270, 'ManufacturerC', '2024-03-01' ),
    ('Product28', 'Description for Product28', 289.99, 190, 'ManufacturerA', '2024-04-01' ),
    ('Product29', 'Description for Product29', 299.99, 130, 'ManufacturerB', '2024-05-01' ),
    ('Product30', 'Description for Product30', 309.99, 240, 'ManufacturerC', '2024-06-01' );


use learn;
create table user(
                     id    int auto_increment     primary key,
                     username varchar(256) not null,
                     password varchar(256) not null
);

