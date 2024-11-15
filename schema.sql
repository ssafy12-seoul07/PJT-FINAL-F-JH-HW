drop database if exists ssafy_SONNE;
create database ssafy_SONNE;
use ssafy_SONNE;

CREATE TABLE `User` (
    `user_id` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE `Route` (
    `route_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `district_name` VARCHAR(100) NOT NULL,
    `theme_name` VARCHAR(50) NOT NULL,
    `duration_time` SMALLINT UNSIGNED NOT NULL COMMENT '소요 시간(분 단위)',
    PRIMARY KEY (`route_id`)
);

CREATE TABLE `Bookmark_Completed_Route` (
    `user_id` VARCHAR(255) NOT NULL,
    `route_id` INT(10) UNSIGNED NOT NULL,
    `is_starting_point_verified` BOOLEAN DEFAULT FALSE COMMENT '출발지 확인 여부',
    `is_middle_point_verified` BOOLEAN DEFAULT FALSE COMMENT '중간지점 확인 여부',
    `is_ending_point_verified` BOOLEAN DEFAULT FALSE COMMENT '도착지 확인 여부',
    `bookmark` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '찜/완료 여부',
    PRIMARY KEY (`user_id`, `route_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`),
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

CREATE TABLE `Location` (
    `location_id` INT(10) NOT NULL AUTO_INCREMENT,
    `route_id` INT(10) UNSIGNED NOT NULL,
    `starting_longitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 경도',
    `starting_latitude` DECIMAL(9, 6) NOT NULL COMMENT '출발지 위도',
    `starting_img_url` VARCHAR(255) NOT NULL COMMENT '출발지 이미지 URL',
    `middle_longitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 경도',
    `middle_latitude` DECIMAL(9, 6) NOT NULL COMMENT '중간 지점 위도',
    `middle_img_url` VARCHAR(255) NOT NULL COMMENT '중간 지점 이미지 URL',
    `ending_latitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 위도',
    `ending_longitude` DECIMAL(9, 6) NOT NULL COMMENT '도착지 경도',
    `ending_img_url` VARCHAR(255) NOT NULL COMMENT '도착지 이미지 URL',
    PRIMARY KEY (`location_id`),
    FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`)
);


-- 더미데이터 삽입
INSERT INTO `User` (`user_id`, `password`, `name`, `phone`) VALUES
('user1', 'password123', 'Alice', '01012345678'),
('user2', 'password456', 'Bob', '01087654321'),
('user3', 'password789', 'Charlie', '01056781234');

INSERT INTO `Route` (`route_id`, `district_name`, `theme_name`, `duration_time`) VALUES
(1, 'Seoul', 'Nature', 120),
(2, 'Busan', 'Cityscape', 90),
(3, 'Jeju', 'Adventure', 180);

INSERT INTO `Bookmark_Completed_Route` (`user_id`, `route_id`, `is_starting_point_verified`, `is_middle_point_verified`, `is_ending_point_verified`, `bookmark`, `created_at`) VALUES
('user1', 1, TRUE, FALSE, FALSE, FALSE, NOW()),
('user2', 2, TRUE, TRUE, TRUE, TRUE, NOW()),
('user3', 3, FALSE, TRUE, FALSE, FALSE, NOW());

INSERT INTO `Review` (`review_id`, `user_id`, `route_id`, `reg_date`, `rating`) VALUES
(1, 'user1', 1, '2024-11-01', 4),
(2, 'user2', 2, '2024-11-05', 5),
(3, 'user3', 3, '2024-11-10', 3);

INSERT INTO `Location` (`location_id`, `route_id`, `starting_longitude`, `starting_latitude`, `starting_img_url`, `middle_longitude`, `middle_latitude`, `middle_img_url`, `ending_latitude`, `ending_longitude`, `ending_img_url`) VALUES
(1, 1, 126.9784, 37.5665, 'https://example.com/start1.jpg', 127.0010, 37.5800, 'https://example.com/middle1.jpg', 127.0150, 37.5900, 'https://example.com/end1.jpg'),
(2, 2, 129.0756, 35.1796, 'https://example.com/start2.jpg', 129.0900, 35.1900, 'https://example.com/middle2.jpg', 129.1000, 35.2000, 'https://example.com/end2.jpg'),
(3, 3, 126.5312, 33.4996, 'https://example.com/start3.jpg', 126.5400, 33.5100, 'https://example.com/middle3.jpg', 126.5500, 33.5200, 'https://example.com/end3.jpg');


-- select * from Review;