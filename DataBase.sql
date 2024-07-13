CREATE DATABASE food_delivery_app;

CREATE TABLE `user` (
`user_id` INT PRIMARY KEY AUTO_INCREMENT,
`user_name` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL UNIQUE,
`address` TEXT,
`role` ENUM('Customer' , 'Restaurant Agent' , 'Delivery Agent' , 'System Agent'),
`created_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
`last_login_date` DATETIME
);


CREATE TABLE `restaurant` (
`restaurant_id` INT PRIMARY KEY AUTO_INCREMENT,
`restaurant_name` VARCHAR(255),
`cousine_type` VARCHAR(255),
`delivery_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
`address` TEXT,
`admin_user_id` INT,
`rating` DECIMAL (5,2),
`is_active` BOOLEAN DEFAULT TRUE,
`img_path` VARCHAR(255),
FOREIGN KEY (`admin_user_id`) REFERENCES `user`(`user_id`)
);


CREATE TABLE `menu` (
`menu_id` INT PRIMARY KEY AUTO_INCREMENT,
`restaurant_id` INT,
`item_name` VARCHAR(255),
`description` TEXT,
`price` DECIMAL (10,2),
`is_available` BOOLEAN DEFAULT TRUE,
`img_path` VARCHAR(255),
FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant`(`restaurant_id`)
);


CREATE TABLE `order` (
`order_id` INT PRIMARY KEY AUTO_INCREMENT,
`user_id` INT,
`restaurant_id` INT,
`order_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
`total_amount` DECIMAL (10,2),
`status` ENUM("Delivered","Pending", "Cancel") ,
`payment_method` ENUM("COD" , "UPI" , "Debit Card" , "Credit Card")  UNIQUE,
FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`),
FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant`(`restaurant_id`)
);


CREATE TABLE `order_history` (
`order_history_id` INT PRIMARY KEY AUTO_INCREMENT,
`order_id` INT,
`user_id` INT ,
`order_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
`total_amount` DECIMAL(10,2),
`status` ENUM('Order Hisory' , 'Delivery Time' , 'Bill Amount'),
FOREIGN KEY (`order_id`) REFERENCES `order`(`order_id`),
FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
);


CREATE TABLE `order_item` (
`order_item_id` INT PRIMARY KEY AUTO_INCREMENT,
`order_id` INT ,
`menu_id` INT ,
`quantity` INT,
`item_total` DOUBLE,
FOREIGN KEY (`order_id`) REFERENCES `order`(`order_id`),
FOREIGN KEY (`menu_id`) REFERENCES `menu`(`menu_id`)
);


CREATE TABLE `cart_item` (
`cart_item_id` INT PRIMARY KEY AUTO_INCREMENT,
`restaurant_id` INT,
`item_name` VARCHAR(255),
`quantity` INT ,
`price` DOUBLE ,
FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant`(`restaurant_id`)
);
