﻿use master
go

drop database AccShop;
go

create database AccShop;
go

drop table categories

use AccShop;
go

-- Tạo bảng role
CREATE TABLE roles (
    id INT PRIMARY KEY,
    role_name VARCHAR(50)
);

-- Tạo bảng accounts
CREATE TABLE accounts (
	username VARCHAR(50) PRIMARY KEY NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    acc_status INT,
    wl VARCHAR(225),
);

-- Tạo bảng Authority
CREATE TABLE authorities (
	id INT PRIMARY KEY NOT NULL,
	acc_user VARCHAR(50),
	role_id INT,
	FOREIGN KEY (acc_user) REFERENCES accounts(username),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Tạo bảng categories
CREATE TABLE categories (
    id INT PRIMARY KEY,
    name VARCHAR(50),
	cate_image VARCHAR(225),
	cate_cover VARCHAR(225),
	cate_des VARCHAR(500)
);

-- Tạo bảng product
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    status INT,
	image_cover VARCHAR(255),
	image_detail VARCHAR(255),
    price DECIMAL(10, 2),
    rental_duration INT,
	rank VARCHAR(50),
	level INT,
	item NVARCHAR(50),
    type VARCHAR(50),
    acc_user VARCHAR(100),
    acc_pass VARCHAR(100),
    date_create DATE,
    cate_id INT,
    FOREIGN KEY (cate_id) REFERENCES categories(id)
);

-- Tạo bảng order
CREATE TABLE orders (
    id INT PRIMARY KEY,
	order_status INT,
	createDate DATE,
    acc_user VARCHAR(50),
    FOREIGN KEY (acc_user) REFERENCES accounts(username)
);

-- Tạo bảng order_details
CREATE TABLE order_details (
    id INT PRIMARY KEY,
	price float,
	product_id INT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Chèn dữ liệu vào bảng account
INSERT INTO accounts (username, email, password, acc_status, wl)
VALUES ('daole123', 'daole123@example.com', '12345', 1, 0),
       ('ledao132', 'ledao132@example.com', '12345', 1, 0),
       ('zolao123', 'zolao123@example.com', '12345', 1, 0),
	   ('minhloc123', 'minhloc123@example.com', '12345', 0, 0),
	   ('xinhao123', 'xinhao123@example.com', '12345', 1, 0),
	   ('xichao123', 'xichao123@example.com', '12345', 1, 0),
	   ('linchao123', 'linchao123@example.com', '12345', 1, 0),
	   ('lichao123', 'lichao123@example.com', '12345', 1, 0),
	   ('xuho123', 'xuho123@example.com', '12345', 1, 0),
	   ('inchao123', 'inchao123@example.com', '12345', 1, 0);

-- Chèn dữ liệu vào bảng roles
INSERT INTO roles (id, role_name)
VALUES (1, 'Admin'),
       (2, 'User'),
	   (3, 'Manager');

-- Chèn dữ liệu vào bảng authorities
INSERT INTO authorities (id, acc_user, role_id)
VALUES (1, 'daole123', 1),
(2, 'ledao132', 1),
(3, 'zolao123', 2),
(4, 'minhloc123', 2),
(5, 'xinhao123', 2),
(6, 'xichao123', 3),
(7, 'linchao123', 2),
(8, 'lichao123', 3),
(9, 'xuho123', 2),
(10, 'inchao123', 2);

-- Chèn dữ liệu vào bảng categories
INSERT INTO categories (id, name, cate_image, cate_cover, cate_des)
VALUES (1, 'Valorant', 'https://inkythuatso.com/uploads/images/2022/03/thumb-1920-1072679-16-15-52-24.jpg','https://i.ytimg.com/vi/IC24y-21_Us/maxresdefault.jpg',
		'Valorant is a tactical first-person shooter game developed and published by Riot Games, officially released on June 2, 2020. Set in a near-future Earth, Valorant features a high-stakes conflict between two factions: the attackers, who strive to plant a bomb called the Spike, and the defenders, who aim to prevent the attackers from achieving their objective.'),
	   (2, 'League of Legends', 'https://gcs.tripi.vn/public-tripi/tripi-feed/img/472683Owi/hinh-nen-dinh-cao-lien-minh-huyen-thoai-danh-cho-pc-va-dien-thoai_21','https://beelevelup.com/assets/img/category/banner/2.jpg',
	   'League of Legends (LoL) was launched on October 27, 2009 by Riot Games. LoL is set in the fictional world of Runeterra, where powerful champions battle it out in 5v5 matches. The game is renowned for its stunning graphics, deep strategic gameplay, and a wide array of diverse champions with unique abilities.'),
	   (3, 'Dota 2', 'https://didongviet.vn/dchannel/wp-content/uploads/2023/07/thong-tin-game-dota-2-didongviet.jpg','https://mega.com.vn/media/news/1105_ban-do-dota-2.jpg',
	   'Dota 2 is a multiplayer online battle arena (MOBA) game developed and published by Valve Corporation, officially released on July 9, 2013. Set in the mythical world of Dota, the game pits two teams of five players against each other in a strategic battle to destroy the opponent`s Ancient, a heavily guarded structure at the heart of their base.'),
	   (4, 'PlayerUnknowns Battlegrounds', 'https://bloganchoi.com/wp-content/uploads/2020/11/game-pubg.jpg','https://4.bp.blogspot.com/-OiFv-sdApdc/W_IQg4myjOI/AAAAAAAARUo/Q4mu59DnDsoiSQ-XtKKl9X8OhcDnbfWswCLcBGAs/s0/hinh-nen-pubg-dep-3.jpg',
	   'PlayerUnknown`s Battlegrounds (PUBG) is a multiplayer battle royale game developed and published by PUBG Corporation, officially released on December 20, 2017. Set on various maps inspired by real-world locations, PUBG drops up to 100 players onto an island where they must scavenge for weapons, armor, and supplies while eliminating other players to be the last one standing.'),
	   (5, 'Counter-Strike: Global Offensive', 'https://genk.mediacdn.vn/139269124445442048/2023/3/23/cs2-1679530147879794733797-1679530422473-16795304225911207505362.png','https://genk.mediacdn.vn/139269124445442048/2023/3/6/dot-16780888090211273362797-1678089707454-16780897076611798484610.jpg',
	   'Counter-Strike 2 (CS2) is a highly anticipated sequel to the iconic first-person shooter game Counter-Strike, developed by Valve Corporation. Released on [2023], CS2 builds upon the foundation laid by its predecessor, offering intense tactical gameplay, realistic weapon mechanics, and competitive multiplayer action.');

-- Chèn dữ liệu vào bảng product
INSERT INTO product (product_id, name, description, status, image_cover, image_detail, price, rental_duration, rank, level, item, type, acc_user, acc_pass, date_create, cate_id)
VALUES 
(1, 'Valorant', 'Rare weapon and high rank', 1, 'https://mega.com.vn/media/news/2004_20.jpg', 'https://cdn-offer-photos.zeusx.com/e812d13a-3afd-44eb-bcf5-7bc9df023770.jpg',
49.99, NULL, 'Silver ', 15, 'Over 10 items','Sell', 'user1', 'pass1', '2023-01-01', 1),
(2, 'League of Legends', 'Full skin and high rank', 1, 'https://cdn.sforum.vn/sforum/wp-content/uploads/2022/09/2.jpg', 'https://gamek.mediacdn.vn/133514250583805952/2020/5/4/photo-1-15885873215802063275557.jpg'
, 99.99, NULL, 'Bronze ', 75, 'Over 50 items', 'Sell', 'user2', 'pass2', '2023-01-02', 2),
(3, 'Dota 2', 'Full skin and high rank', 1, 'https://phongvu.vn/cong-nghe/wp-content/uploads/2018/07/Dota-2-HD-wallpaper.jpg', 'https://media.karousell.com/media/photos/products/2022/5/17/dota_2_account_1652797692_9d5afd54.jpg'
, 29.99, NULL, 'Silver ', 10, 'Over 10 items', 'Sell', 'user3', 'pass3', '2023-01-03', 3),
(4, 'PUBG', 'Rare skin and high rank', 1, 'https://mega.com.vn/media/news/2305_Hinh-nen-maytinh-Pubg-4k7.jpg', 'https://pbs.twimg.com/media/Dib-0wlU8AE2I6v.jpg'
, 39.99, NULL, 'Bronze ', 10, 'Over 15 items', 'Sell', 'user4', 'pass4', '2023-01-04', 4),
(5, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, NULL,  'Bronze ', 10, 'Over 20 items', 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(6, 'Dota 2', 'Full skin and high rank', 1, 'https://phongvu.vn/cong-nghe/wp-content/uploads/2018/07/Dota-2-HD-wallpaper.jpg', 'https://media.karousell.com/media/photos/products/2022/5/17/dota_2_account_1652797692_9d5afd54.jpg'
, 19.99, NULL, 'Bronze ', 25, 'Over 10 items', 'Sell', 'user5', 'pass5', '2023-01-05', 3),
(7, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, NULL,  'Gold ', 25, 'Over 20 items', 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(8, 'Dota 2', 'Full skin and high rank', 1, 'https://phongvu.vn/cong-nghe/wp-content/uploads/2018/07/Dota-2-HD-wallpaper.jpg', 'https://media.karousell.com/media/photos/products/2022/5/17/dota_2_account_1652797692_9d5afd54.jpg'
, 19.99, NULL, 'Bronze ', 10, 'Over 10 items', 'Sell', 'user5', 'pass5', '2023-01-05', 3),
(9, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, 180,  'Silver ', 10, 'Over 15 items', 'Rent', 'user5', 'pass5', '2023-01-05', 5),
(10, 'Valorant', 'Rare weapon and high rank', 1, 'https://mega.com.vn/media/news/2004_20.jpg', 'https://cdn-offer-photos.zeusx.com/e812d13a-3afd-44eb-bcf5-7bc9df023770.jpg'
, 19.99, NULL , 'Platinum ', 25, 'Over 10 items', 'Sell', 'user5', 'pass5', '2023-01-05', 1),
(11, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, NULL,  'Bronze ', 10, 'Over 30 items', 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(12, 'League of Legends', 'Full skin and high rank', 1, 'https://cdn.sforum.vn/sforum/wp-content/uploads/2022/09/2.jpg', 'https://gamek.mediacdn.vn/133514250583805952/2020/5/4/photo-1-15885873215802063275557.jpg'
, 19.99, 180, 'Gold ', 175, 'Over 70 items', 'Rent', 'user5', 'pass5', '2023-01-05', 2),
(13, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, NULL,  'Silver ', 10, 'Over 30 items', 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(14, 'League of Legends', 'Full skin and high rank', 1, 'https://cdn.sforum.vn/sforum/wp-content/uploads/2022/09/2.jpg', 'https://gamek.mediacdn.vn/133514250583805952/2020/5/4/photo-1-15885873215802063275557.jpg'
, 19.99, NULL, 'Bronze ', 275, 'Over 40 items', 'Sell', 'user5', 'pass5', '2023-01-05', 2),
(15, 'League of Legends', 'Full skin and high rank', 1, 'https://cdn.sforum.vn/sforum/wp-content/uploads/2022/09/2.jpg', 'https://gamek.mediacdn.vn/133514250583805952/2020/5/4/photo-1-15885873215802063275557.jpg'
, 19.99, 180, 'Bronze ', 155, 'Over 68 items', 'Rent', 'user5', 'pass5', '2023-01-06', 2),
(16, 'League of Legends', 'Full skin and high rank', 1, 'https://cdn.sforum.vn/sforum/wp-content/uploads/2022/09/2.jpg', 'https://gamek.mediacdn.vn/133514250583805952/2020/5/4/photo-1-15885873215802063275557.jpg'
, 19.99, NULL, 'Bronze ', 235, 'Over 35 items', 'Sell', 'user5', 'pass5', '2023-01-05', 2),
(17, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, NULL,  'Bronze ', 10, 'Over 20 items', 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(18, 'Dota 2', 'Full skin and high rank', 1, 'https://phongvu.vn/cong-nghe/wp-content/uploads/2018/07/Dota-2-HD-wallpaper.jpg', 'https://media.karousell.com/media/photos/products/2022/5/17/dota_2_account_1652797692_9d5afd54.jpg'
, 19.99, NULL, 'Gold ', 25, 'Over 10 items', 'Sell', 'user5', 'pass5', '2023-01-05', 3),
(19, 'CS:GO', 'Rare weapon and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 19.99, NULL,  'Silver ', 25, 'Over 10 items', 'Sell', 'user5', 'pass5', '2023-01-06', 5),
(20, 'PUBG', 'Rare skin and high rank', 1, 'https://mega.com.vn/media/news/2305_Hinh-nen-maytinh-Pubg-4k7.jpg', 'https://pbs.twimg.com/media/Dib-0wlU8AE2I6v.jpg'
, 39.99, 180, 'Bronze ', 10, 'Over 10 items', 'Rent', 'user4', 'pass4', '2023-01-04', 4),
(21, 'CS:GO', 'Rare skin and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 39.99, NULL,  'Bronze ', 25, 'Over 10 items', 'Sell', 'user4', 'pass4', '2023-01-06', 5),
(22, 'Valorant', 'Rare weapon and high rank', 1, 'https://mega.com.vn/media/news/2004_20.jpg', 'https://cdn-offer-photos.zeusx.com/e812d13a-3afd-44eb-bcf5-7bc9df023770.jpg'
, 39.99, NULL, 'Diamond', 15, 'Over 12 items','Buy', 'user4', 'pass4', '2023-01-07', 1),
(23, 'CS:GO', 'Rare skin and high rank', 1, 'https://www.cryptopolitan.com/wp-content/uploads/2024/02/photo_5965044971360861562_y.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/730/ss_fe70d46859593aef623a0614f4686e2814405035.1920x1080.jpg?t=1698860631'
, 39.99, 180,  'Gold ', 25, 'Over 10 items', 'Rent', 'user4', 'pass4', '2023-01-04', 5),
(24, 'PUBG', 'Rare weapon and high rank', 1, 'https://mega.com.vn/media/news/2305_Hinh-nen-maytinh-Pubg-4k7.jpg', 'https://pbs.twimg.com/media/Dib-0wlU8AE2I6v.jpg'
, 39.99, 180, 'Silver ', 10, 'Over 10 items', 'Rent', 'user4', 'pass4', '2023-01-04', 4),
(25, 'PUBG', 'Rare weapon and high rank', 1, 'https://mega.com.vn/media/news/2305_Hinh-nen-maytinh-Pubg-4k7.jpg', 'https://pbs.twimg.com/media/Dib-0wlU8AE2I6v.jpg'
, 19.99, NULL, 'Gold ', 10, 'Over 10 items', 'Sell', 'user5', 'pass5', '2023-01-05', 4);


-- Chèn dữ liệu vào bảng orders
INSERT INTO orders (id, order_status, createDate, acc_user)
VALUES 
(1, 1, '2024-01-15', 'daole123'),
(2, 0, '2024-01-17', 'daole123'),
(3, 0, '2024-02-01', 'ledao132'),
(4, 1, '2024-02-06', 'ledao132'),
(5, 1, '2024-01-02', 'inchao123'),
(6, 1, '2024-01-23', 'zolao123'),
(7, 0, '2024-02-15', 'minhloc123'),
(8, 1, '2024-02-26', 'minhloc123'),
(9, 0, '2024-02-15', 'xinhao123'),
(10, 1, '2024-02-26', 'linchao123'),
(11, 0, '2024-02-15', 'lichao123'),
(12, 1, '2024-02-26', 'xuho123'),
(13, 1, '2024-01-29', 'xinhao123'),
(14, 1, '2024-02-20', 'xichao123');

-- Chèn dữ liệu vào bảng order_details
INSERT INTO order_details (id, price, product_id, order_id)
VALUES
(1, 60, 1, 1),
(2, 70, 2, 4),
(3, 50, 1, 5),
(4, 50, 6, 6),
(5, 60, 7, 8),
(6, 40, 1, 10),
(7, 40, 9, 12),
(8, 70, 10, 13),
(9, 90, 3, 14);

select * from accounts;
select * from roles;
select * from categories;
select * from product;
select * from orders;
select * from order_details;