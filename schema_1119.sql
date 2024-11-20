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
    `user_id` VARCHAR(255) NOT NULL,
    `route_id` INT(10) UNSIGNED NOT NULL,
    PRIMARY KEY (`user_id`, `route_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`),
    FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`)
);


-- CREATE TABLE `Location` (
--     `location_id` INT(10) NOT NULL AUTO_INCREMENT,
--     `route_id` INT(10) UNSIGNED NOT NULL,
--     `starting_latitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 위도',
--     `starting_longitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 경도',
--     `starting_img_url` VARCHAR(255) NOT NULL COMMENT '출발지 이미지 URL',
--     `middle_latitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 위도',
-- 	`middle_longitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 경도',
--     `middle_img_url` VARCHAR(255) NOT NULL COMMENT '중간 지점 이미지 URL',
--     `ending_longitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 경도',
-- 	`ending_latitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 위도',
--     `ending_img_url` VARCHAR(255) NOT NULL COMMENT '도착지 이미지 URL',
--     PRIMARY KEY (`location_id`),
--     FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`)
-- );

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
(1, 'jongro', 'calmly', 25, 100, 'https://map.kakao.com/?map_type=TYPE_MAP&target=walk&rt=495123%2C1129600%2C494122%2C1129875%2C493636%2C1130124&rt1=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%ED%83%9C%ED%8F%89%EB%A1%9C1%EA%B0%80+54-3&rt2=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%EC%A0%95%EB%8F%99+5-2&rt3=%EC%84%9C%EC%9A%B8+%EC%A4%91%EA%B5%AC+%EC%A0%95%EB%8F%99+15-9&rtIds=%2C%2C&rtTypes=POINT%2CPOINT%2CPOINT');


INSERT INTO `Bookmark` (`user_id`, `route_id`) 
VALUES ('hwlee333',1);

INSERT INTO `Review` (`review_id`, `user_id`, `route_id`, `reg_date`, `rating`) VALUES
(1, 'hwlee333', 1, '2024-11-01', 4);


