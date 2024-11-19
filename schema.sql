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
('user1', 'password123', 'Alice', '01012345678'),
('user2', 'password456', 'Bob', '01087654321'),
('user3', 'password789', 'Charlie', '01056781234');

INSERT INTO `Route` (`route_id`, `district_name`, `theme_name`, `duration_time`,`calorie`) VALUES
-- (숫자, '구이름', 'demure, calmly, enthusiastically, alone 중 택1', '15, 25, 45'
(1, 'Seoul', 'Nature', 120,100),
(2, 'Busan', 'Cityscape', 90, 200),
(3, 'Jeju', 'Adventure', 180,300);

INSERT INTO `Bookmark_Completed_Route` (`user_id`, `route_id`, `is_starting_point_verified`, `is_middle_point_verified`, `is_ending_point_verified`, `bookmark`, `created_at`) VALUES
('user1', 1, TRUE, FALSE, FALSE, FALSE, NOW()),
('user2', 2, TRUE, TRUE, TRUE, TRUE, NOW()),
('user3', 3, FALSE, TRUE, FALSE, FALSE, NOW());

INSERT INTO `Review` (`review_id`, `user_id`, `route_id`, `reg_date`, `rating`) VALUES
(1, 'user1', 1, '2024-11-01', 4),
(2, 'user2', 2, '2024-11-05', 5),
(3, 'user3', 3, '2024-11-10', 3);

INSERT INTO `Location` (`location_id`, `route_id`,  `starting_latitude`, `starting_longitude`, `starting_img_url`,  `middle_latitude`, `middle_longitude`, `middle_img_url`,  `ending_longitude`, `ending_latitude`, `ending_img_url`) VALUES
-- ('auto increment', 'route table과  syncing', '' )
-- (1, 1, 37.563371, 126.987245, '구이름_테마_소요시간_A.png  --- jongro_calmly_15_A.png', 37.563371, 126.987245, '구이름_테마_소요시간_A.png  --- jongro_calmly_15_B.png', 37.563371, 126.987245, '구이름_테마_소요시간_A.png  --- jongro_calmly_15_C.png',),

-- Route -- (숫자, '구이름', 'demure, calmly, enthusiastically, alone 중 택1', '15, 25, 45'

-- select * from Review;