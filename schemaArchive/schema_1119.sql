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


CREATE TABLE `Location` (
    `location_id` INT(10) NOT NULL AUTO_INCREMENT,
    `route_id` INT(10) UNSIGNED NOT NULL,
    `starting_latitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 위도',
    `starting_longitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 경도',
    `middle_latitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 위도',
	`middle_longitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 경도',
    `imgURL` TEXT NOT NULL,
    `ending_longitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 경도',
	`ending_latitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 위도',
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


INSERT INTO `Route` (`route_id`, `district`, `theme`, `duration`,`calorie`, `routeURL`) VALUES
(1, 'jongro', 'calmly', 25, 100, 'https://map.kakao.com/?map_type=TYPE_MAP&target=walk&rt=495123%2C1129600%2C494122%2C1129875%2C493636%2C1130124&rt1=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%ED%83%9C%ED%8F%89%EB%A1%9C1%EA%B0%80+54-3&rt2=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%EC%A0%95%EB%8F%99+5-2&rt3=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%EC%A0%95%EB%8F%99+15-9&rtIds=%2C%2C&rtTypes=POINT%2CPOINT%2CPOINT'),
(2, 'jongro', 'calmly', 25, 100, 'https://map.kakao.com/?map_type=TYPE_MAP&target=walk&rt=495123%2C1129600%2C494122%2C1129875%2C493636%2C1130124&rt1=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%ED%83%9C%ED%8F%89%EB%A1%9C1%EA%B0%80+54-3&rt2=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%EC%A0%95%EB%8F%99+5-2&rt3=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%EC%A0%95%EB%8F%99+15-9&rtIds=%2C%2C&rtTypes=POINT%2CPOINT%2CPOINT'),
(3, 'gangnam', 'vibrant', 30, 150, 'https://map.kakao.com/?map_type=TYPE_MAP&target=walk&rt=123456%2C789123%2C456789%2C123456&rt1=%EA%B0%95%EB%82%A8+%ED%8C%8C%EB%9E%80%EB%A1%9C&rt2=%EA%B0%95%EB%82%A8+%EC%97%AC%EC%9D%98+%EA%B1%B4%EB%AC%BC&rtIds=%2C%2C&rtTypes=POINT%2CPOINT'),
(4, 'mapo', 'romantic', 20, 80, 'https://map.kakao.com/?map_type=TYPE_MAP&target=walk&rt=234567%2C123789%2C567890%2C234567&rt1=%EB%A7%88%ED%8F%AC+%ED%9C%B4%EA%B0%80+%ED%8F%AC%EC%9D%B8%ED%8A%B8&rt2=%EB%A7%88%ED%8F%AC+%EA%B2%BD%EC%B0%B0%EC%84%A0&rtIds=%2C%2C&rtTypes=POINT%2CPOINT');


INSERT INTO `Bookmark` (`user_id`, `route_id`) 
VALUES ('hwlee333',2);

INSERT INTO `Review` (`review_id`, `user_id`, `route_id`, `reg_date`, `rating`) VALUES
(1, 'hwlee333', 1, '2024-11-01', 4);


select * from location;

ALTER TABLE review CHANGE COLUMN reg_date regDate Date;

