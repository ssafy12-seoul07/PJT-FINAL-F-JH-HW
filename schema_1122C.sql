drop database if exists ssafy_urs;
create database ssafy_urs;
use ssafy_urs;

CREATE TABLE `User` (
    `user_id` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE `Route` (
    `route_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `district` VARCHAR(100) NOT NULL,
    `theme` VARCHAR(50) NOT NULL,
    `duration` SMALLINT UNSIGNED NOT NULL COMMENT '소요 시간(분 단위)',
    `calorie` INT(10) NOT NULL,
    `routeURL` TEXT NOT NULL,
    PRIMARY KEY (`route_id`)
);

CREATE TABLE `Bookmark` (	
	`bookmark_id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(255) NOT NULL,
    `route_id` INT(10) UNSIGNED NOT NULL,
    PRIMARY KEY (`bookmark_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`),
    FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`)
);



INSERT INTO `Route` (`route_id`, `district`, `theme`, `duration`, `calorie`, `routeURL`) 
VALUES
    (1, 'jung', 'alone', 15, 55, 'https://example.com/route1'),
    (2, 'jung', 'calmly', 25, 58, 'https://example.com/route2'),
    (3, 'jung', 'lively', 15, 64, 'https://example.com/route3'),
    (4, 'jung', 'alone', 25, 53, 'https://example.com/route4'),
    (5, 'jung', 'demure', 25, 48, 'https://example.com/route5');
    
INSERT into `route`(`route_id`, `district`, `theme`, `duration`, `calorie`, `routeURL`) 
VALUES(7, '중구', 'alone', 10, 70, 'https://example.com/route6');
    
    INSERT INTO `location` (
    `route_id`, `A_latitude`, `A_longitude`, 
    `center_latitude`, `center_longitude`, 
    `B_latitude`, `B_longitude`, `imgURL`,`A_Name`,`B_Name`,`C_Name`
) 
VALUES
       (7, 37.540163, 127.001621, 37.534961, 126.98707, 37.527844, 126.97039, 'https://example.com/img6','한강진역','녹사평다리','김구공원');
DROP TABLE `route`;
SELECT * FROM route;
select * from location;



CREATE TABLE `location`(
	`route_id` INT(10) UNSIGNED NOT NULL,
    `location_id` INT(10) NOT NULL AUTO_INCREMENT,
    `A_name` VARCHAR(255) NOT NULL,
    `A_latitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 위도',
    `A_longitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 경도',
    `C_name` VARCHAR(255) NOT NULL,    
    `center_latitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 위도',
	`center_longitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 경도',
	`B_name` VARCHAR(255) NOT NULL,
    `B_longitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 경도',
	`B_latitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 위도',
    `imgURL` TEXT NOT NULL,
    PRIMARY KEY (`location_id`),
    FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`)
);

CREATE TABLE `Review` (
    `review_id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(255) NOT NULL,
    `route_id` INT(10) UNSIGNED NOT NULL,
    `reg_date` DATE NOT NULL,
    `rating` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '평점 (0~5)',
    PRIMARY KEY (`review_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`),
    FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`)
);


-- 더미데이터 삽입
INSERT INTO `User` (`user_id`, `password`, `name`, `phone`) VALUES
('hwlee333', 'password123', 'Alice', '01012345678');




INSERT INTO `Route` (`route_id`, `district`, `theme`, `duration`, `calorie`, routeURL)
VALUES( 7, '중구', 'alone', 15,55,'https://example.com/img1');


INSERT INTO `Review` (`review_id`, `user_id`, `route_id`, `reg_date`, `rating`) VALUES
(1, 'hwlee333', 1, '2024-11-01', 4);

DELETE from route
Where route_id=7;

select * from route;
select * from location;

ALTER TABLE review CHANGE COLUMN reg_date regDate Date;

