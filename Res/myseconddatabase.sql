
create database if not exists myseconddatabase;
use myseconddatabase;

create table if not exists city(
cityID INT AUTO_INCREMENT PRIMARY KEY,
cityName VARCHAR(50) NOT NULL);

create table if not exists customers(
customerID INT AUTO_INCREMENT PRIMARY KEY,
customerFirstName VARCHAR(50),
customerLastName VARCHAR(50),
customerAddress VARCHAR(50),
customerEMail VARCHAR(50),
customerPassword VARCHAR (50),
customerPhoneNumber VARCHAR(50),
cityID int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
/* lägg in index namn*/
foreign key (cityID) references city(cityID));

create table if not exists manufacturer(
manufacturerID INT AUTO_INCREMENT PRIMARY KEY,
manufacturerName VARCHAR(50) NOT NULL,
manufacturerAddress VARCHAR(50) NOT NULL,
manufacturerPhoneNumber VARCHAR(50) NOT NULL,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp);

create table if not exists color(
colorID INT not null AUTO_INCREMENT PRIMARY KEY,
colorName varchar(50),
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp);

create table if not exists size(
sizeID INT not null AUTO_INCREMENT PRIMARY KEY,
euSize int,
ukSize int,
usSize int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp);

create table if not exists subCategory(
subCategoryID INT not null AUTO_INCREMENT PRIMARY KEY,
subCategoryName varchar(50),
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp);

create table if not exists genderCategory(
genderCategoryID INT not null AUTO_INCREMENT PRIMARY KEY,
genderCategoryName varchar(50),
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp);

create table if not exists category(
categoryID INT not null AUTO_INCREMENT PRIMARY KEY,
subCategoryID int,
genderCategoryID int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
foreign key (subCategoryID) references subCategory(subCategoryID),
foreign key (genderCategoryID) references genderCategory(genderCategoryID));

create table if not exists product(
productID INT AUTO_INCREMENT PRIMARY KEY,
modelName varchar(50),
manufacturerID int,
categoryID int,
sizeID int,
colorID int,
price double,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
foreign key (manufacturerID) references manufacturer(manufacturerID),
foreign key (categoryID) references category(categoryID),
foreign key (colorID) references color(colorID),
foreign key (sizeID) references size(sizeID));

create table if not exists inventory(
inventoryID INT AUTO_INCREMENT PRIMARY KEY,
productID int not null,
inStock int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
foreign key (productID) references product(productID));

create table if not exists coordinationTable(
coordinationTableID INT AUTO_INCREMENT PRIMARY KEY,
customerID int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
foreign key (customerID) references customers(customerID));

create table if not exists orderDetail(
orderDetailID INT AUTO_INCREMENT PRIMARY KEY,
coordinationTableID int,
inventoryID int,
quantity int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
foreign key (coordinationTableID) references coordinationTable(coordinationTableID),
foreign key (inventoryID) references inventory(inventoryID)
ON DELETE cascade);


create table if not exists orders(
orderID INT AUTO_INCREMENT PRIMARY KEY,
coordinationTableID int,
orderDate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_Timestamp,
foreign key (coordinationTableID) references coordinationTable(coordinationTableID)
ON DELETE SET NULL);


use myseconddatabase;

insert into city(cityName)values
('Umeå'), 
('Stockholm'),
('Göteborg'),
('Ankeborg');

insert into customers(customerFirstName, customerLastName, customerAddress,customerEMail,customerPassword, customerPhoneNumber, cityID, created, lastUpdated) values
('Marcus','Edlund', 'asdgatan 1', 'marcus.edlund@gmail.com','Skelefteå123','7777-7777',1, now(),now()),
('Marcus','Hurtig', 'asdvägen 1', 'marcus.hurtigh@gmail.com','sundsvall', '8888-8888',3, now(),now()),
('Göran','Persson', 'Bolaget','göran@gmail.com','maud', '9999-9999',2, now(),now()),
('Carl', 'Bildt', 'Sveavägen','CalleB@gmail.com','ud', ' 0000-0000',4, now(),now()),
('Stefan', 'Löfven', 'Sveavägen','stefan@gmail.com','svets', '0000-0000',4, now(),now()),
('Peter', 'Larsson', 'Livscoachvägen','peter@coach.se','bananchips', '3333-3333',1, now(),now());

insert into manufacturer(manufacturerName, manufacturerAddress, manufacturerPhoneNumber)values
('ECCO', 'Ecco.v 1', '111-111-1111'),
('Adidas', 'Adidasgatan 2', '222-222-2222'),
('Converse', 'Conversegränd 3', '333-333-3333'),
('Dr.Martens', 'Martens Alle 4', '444-444-4444'),
('Vans', 'Vans Aveny 5', '555-555-5555');

insert into color(colorName)values
('Black'),
('White'),
('Red'),
('Green'),
('Blue'),
('Brown');

insert into size(euSize, ukSize, usSize)values
(35,2,4),
(36,3,5),
(37,4,6),
(38,5,7),
(39,6,8),
(40,7,9),
(41,8,10),
(42,9,11);

insert into subCategory(subCategoryName)values
('Sandal'), 
('Sneaker'), 
('High Top'), 
('Slipper'), 
('Boot');

insert into genderCategory(genderCategoryName)values
('Unisex'), 
('Woman'), 
('Man');

insert into category(subCategoryID, genderCategoryID)values
(1,1), 
(2,1),
(3,1),
(4,1),
(5,1);

insert into product(modelName, manufacturerID, categoryID, sizeID, colorID, price)values
('Allstars',3,2,1,1,699), 
('Allstars',3,2,2,1,699), 
('Allstars',3,2,3,1,699), 
('Allstars',3,2,4,1,699), 
('Allstars',3,2,5,1,699), 
('Allstars',3,2,6,1,699), 
('Allstars',3,2,7,1,699), 
('Allstars',3,2,8,1,699), 

('Allstars',3,2,1,2,699), 
('Allstars',3,2,2,2,699), 
('Allstars',3,2,3,2,699), 
('Allstars',3,2,4,2,699), 
('Allstars',3,2,5,2,699), 
('Allstars',3,2,6,2,699), 
('Allstars',3,2,7,2,699), 
('Allstars',3,2,8,2,699), 

('Old School',5,2,1,1,500), 
('Old School',5,2,2,1,500), 
('Old School',5,2,3,1,500), 
('Old School',5,2,4,1,500), 
('Old School',5,2,5,1,500), 
('Old School',5,2,6,1,500), 
('Old School',5,2,7,1,500), 
('Old School',5,2,8,1,500), 

('Old School',5,2,1,2,500), 
('Old School',5,2,2,2,500), 
('Old School',5,2,3,2,500), 
('Old School',5,2,4,2,500), 
('Old School',5,2,5,2,500), 
('Old School',5,2,6,2,500), 
('Old School',5,2,7,2,500), 
('Old School',5,2,8,2,500), 

('Grand Court',2,2,1,2,999), 
('Grand Court',2,2,2,2,999), 
('Grand Court',2,2,3,2,999), 
('Grand Court',2,2,4,2,999), 
('Grand Court',2,2,5,2,999), 
('Grand Court',2,2,6,2,999), 
('Grand Court',2,2,7,2,999), 
('Grand Court',2,2,8,2,999), 

('Offroad',1,1,1,2,299), 
('Offroad',1,1,2,2,299), 
('Offroad',1,1,3,2,299), 
('Offroad',1,1,4,2,299), 
('Offroad',1,1,5,2,299), 
('Offroad',1,1,6,2,299), 
('Offroad',1,1,7,2,299), 
('Offroad',1,1,8,2,299), 

('Offroad',1,1,1,6,299), 
('Offroad',1,1,2,6,299), 
('Offroad',1,1,3,6,299), 
('Offroad',1,1,4,6,299), 
('Offroad',1,1,5,6,299), 
('Offroad',1,1,6,6,299), 
('Offroad',1,1,7,6,299), 
('Offroad',1,1,8,6,299), 

('Voss 2',4,1,1,6,1500), 
('Voss 2',4,1,2,6,1500), 
('Voss 2',4,1,3,6,1500), 
('Voss 2',4,1,4,6,1500), 
('Voss 2',4,1,5,6,1500), 
('Voss 2',4,1,6,6,1500), 
('Voss 2',4,1,7,6,1500), 
('Voss 2',4,1,8,6,1500), 

('Jadon 2',4,5,1,1,1500), 
('Jadon 2',4,5,2,1,1500), 
('Jadon 2',4,5,3,1,1500), 
('Jadon 2',4,5,4,1,1500), 
('Jadon 2',4,5,5,1,1500), 
('Jadon 2',4,5,6,1,1500), 
('Jadon 2',4,5,7,1,1500), 
('Jadon 2',4,5,8,1,1500), 

('Serena',4,5,1,1,799), 
('Serena',4,5,2,1,799), 
('Serena',4,5,3,1,799), 
('Serena',4,5,4,1,799), 
('Serena',4,5,5,1,799), 
('Serena',4,5,6,1,799), 
('Serena',4,5,7,1,799), 
('Serena',4,5,8,1,799), 

('Chery',4,5,1,6,999), 
('Chery',4,5,2,6,999), 
('Chery',4,5,3,6,999), 
('Chery',4,5,4,6,999), 
('Chery',4,5,5,6,999), 
('Chery',4,5,6,6,999), 
('Chery',4,5,7,6,999), 
('Chery',4,5,8,6,999),

('Chelsea',1,5,1,6,899), 
('Chelsea',1,5,2,6,899), 
('Chelsea',1,5,3,6,899), 
('Chelsea',1,5,4,6,899), 
('Chelsea',1,5,5,6,899), 
('Chelsea',1,5,6,6,899), 
('Chelsea',1,5,7,6,899), 
('Chelsea',1,5,8,6,899),

('Allstars CT',3,3,1,1,699), 
('Allstars CT',3,3,2,1,699), 
('Allstars CT',3,3,3,1,699), 
('Allstars CT',3,3,4,1,699), 
('Allstars CT',3,3,5,1,699), 
('Allstars CT',3,3,6,1,699), 
('Allstars CT',3,3,7,1,699), 
('Allstars CT',3,3,8,1,699),

('Allstars CT',3,3,1,2,699), 
('Allstars CT',3,3,2,2,699), 
('Allstars CT',3,3,3,2,699), 
('Allstars CT',3,3,4,2,699), 
('Allstars CT',3,3,5,2,699), 
('Allstars CT',3,3,6,2,699), 
('Allstars CT',3,3,7,2,699), 
('Allstars CT',3,3,8,2,699),

('Slip-Ons',1,4,1,1,499), 
('Slip-Ons',1,4,2,1,499), 
('Slip-Ons',1,4,3,1,499), 
('Slip-Ons',1,4,4,1,499), 
('Slip-Ons',1,4,5,1,499), 
('Slip-Ons',1,4,6,1,499), 
('Slip-Ons',1,4,7,1,499), 
('Slip-Ons',1,4,8,1,499),

('Slip-Ons',1,4,1,6,499), 
('Slip-Ons',1,4,2,6,499), 
('Slip-Ons',1,4,3,6,499), 
('Slip-Ons',1,4,4,6,499), 
('Slip-Ons',1,4,5,6,499), 
('Slip-Ons',1,4,6,6,499), 
('Slip-Ons',1,4,7,6,499), 
('Slip-Ons',1,4,8,6,499),

('La Costa',5,4,1,1,199), 
('La Costa',5,4,2,1,199), 
('La Costa',5,4,3,1,199), 
('La Costa',5,4,4,1,199), 
('La Costa',5,4,5,1,199), 
('La Costa',5,4,6,1,199), 
('La Costa',5,4,7,1,199), 
('La Costa',5,4,8,1,199),

('Adilette',2,4,1,1,299), 
('Adilette',2,4,2,1,299), 
('Adilette',2,4,3,1,299), 
('Adilette',2,4,4,1,299), 
('Adilette',2,4,5,1,299), 
('Adilette',2,4,6,1,299), 
('Adilette',2,4,7,1,299), 
('Adilette',2,4,8,1,299);

INSERT INTO inventory(productID, inStock)values
(1,10),(2,10),(3,10),(4,10),(5,10),(6,10),(7,10),(8,10),(9,10),(10,10),(11,10),(12,10),(13,10),(14,10), 
(15,10),(16,10),(17,10),(18,10),(19,10),(20,10),(21,10),(22,10),(23,10),(24,10),(25,10),(26,10),(27,10),
(28,10),(29,10),(30,10),(31,10),(32,10),(33,10),(34,10),(35,10),(36,10),(37,10),(38,10),(39,10),(40,10),
(41,10),(42,10),(43,10),(44,10),(45,10),(46,10),(47,10),(48,10),(49,10), (50,10), (51,10), (52,10), (53,10),
(54,10), (55,10), (56,10), (57,10), (58,10), (59,10), (60,10), (61,10), (62,10), (63,10), (64,10), (65,10), 
(66,10), (67,10), (68,10), (69,10), (70,10), (71,10), (72,10), (73,10), (74,10), (75,10), (76,10), (77,10), 
(78,10), (79,10), (80,10), (81,10), (82,10), (83,10), (84,10), (85,10), (86,10), (87,10), (88,10), (89,10),
(90,10), (91,10), (92,10), (93,10), (94,10), (95,10), (96,10), (97,10), (98,10), (99,10), (100,10), (101,10),
(102,10), (103,10), (104,10), (105,10), (106,10), (107,10), (108,10), (109,10), (110,10), (111,10), (112,10), 
(113,10), (114,10), (115,10), (116,10), (117,10), (118,10), (119,10), (120,10), (121,10), (122,10), (123,10), 
(124,10), (125,10), (126,10), (127,10), (128,10), (129,10), (130,10), (131,10), (132,10), (133,10), (134,10), 
(135,10), (136,10), (137,10), (138,10), (139,10), (140,10), (141,10), (142,10), (143,10), (144,10);

INSERT INTO coordinationTable(customerID)values
(1),
(2),
(3),
(4),
(5),
(6);


INSERT INTO orderDetail(coordinationTableID, inventoryID, quantity)values
(1,144,1),
(1,1,1),
(2,75,1),
(3,90,1),
(4,96,1),
(5,5,2),
(6,1,1);

INSERT INTO orders(coordinationTableID)values
(1),
(2),
(3),
(4),
(5),
(6);

 