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
    `contentName` VARCHAR(255) NOT NULL,
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
    `contentURL` TEXT NOT NULL,
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



SELECT * FROM user;
select * from location;

-- 더미데이터 삽입
INSERT INTO `User` (`user_id`, `password`, `name`, `phone`) VALUES
('hwlee333', 'password123', 'Alice', '01012345678');

INSERT INTO `Route` (`route_id`, `district`, `theme`, `duration`, `calorie`, `contentName`)
VALUES
(1, '중구', 'alone', 15, 55, '도깨비'),
(2, '중구', 'calmly', 25, 58, '미생'),
(3, '중구', 'lively', 15, 64, '눈물의여왕'),
(4, '중구', 'alone', 25, 53, '열혈사제'),
(5, '중구', 'demure', 25, 48, '오징어게임'),
(6, '용산구', 'lively', 45, 84, '이태원클라스'),
(7, '중구', 'alone', 45, 85, '사랑후에 오는 것들'),
(8, '중구', 'calmly', 45, 87, '무한도전 궁밀리어네어편'),
(9, '중구', 'calmly', 15, 53, '힘쎈여자강남순'),
(10, '중구', 'lively', 25, 48, '베테랑'),
(11, '중구', 'demure', 15, 55, '청춘기록'),
(12, '중구', 'demure', 45, 88, '무한도전 텔레파시편'),
(13, '중구', 'lively', 45, 67, '닥터슬럼프');



INSERT INTO `location` (`route_id`, `A_name`, `A_latitude`, `A_longitude`, `C_name`, `center_latitude`, `center_longitude`, `B_name`, `B_latitude`, `B_longitude`, `contentURL`)
VALUES
(1, '을지로입구역', 37.565943, 126.981944, '덕수궁돌담길', 37.56708, 126.973358, '정동공원', 37.567953, 126.971529, ' '),
(2, '회현역 1번출구', 37.559285, 126.97972, '서울스퀘어', 37.555697, 126.973682, '숭례문광장', 37.559813, 126.975103, ' '),
(3, '시청역 4번출구', 37.566744, 126.977441, '청계천 모전교', 37.569149, 126.979275, '청계천 한빛광장', 37.568042, 126.985364, ' '),
(4, '충정로역 5번출구', 37.559034, 126.963855, '약현성당', 37.559169, 126.967493, '서소문역사공원', 37.560902, 126.969341, ' '),
(5, '명동역 3번출구', 37.560662, 126.985366, '남산산책길', 37.55591, 126.985351, '남산공원 백범광장', 37.555004, 126.979262, ' '),
(6, '한강진역1번출구', 37.540163, 127.001621, '녹사평역 보도육교', 37.534752, 126.987302, '용산공원', 37.527844, 126.97039, ' '),
(7, '을지로4가역 2번출구', 37.567012, 126.997771, '환구단', 37.564935, 126.979909, '진달래소공원', 37.567888, 126.974793, ' '),
(8, '시청역 12번출구', 37.564234, 126.976493, '정관헌', 37.56645, 126.975648, '낙선재', 37.578784, 126.993042, ' '),
(9, '약수역8번출구', 37.553639, 127.009783, '장충체육관', 37.558378, 127.006787, '석호정 국궁장', 37.554616, 126.999835, ' '),
(10, '명동역 4번출구', 37.560642, 126.984727, '스테이트타워', 37.560259, 126.983044, '남산케이블카', 37.556657, 126.983923, ' '),
(11, '신당역 9번출구', 37.565468, 127.015888, '동대문디자인플라자', 37.566006, 127.009577, '훈련원공원', 37.567365, 127.003784, ' '),
(12, '남산벚꽃길', 37.550794, 126.998002, '남산 팔각정', 37.551713, 126.987609, '남산 봉수대', 37.552196, 126.987487, ' '),
(13, '버티고개역', 37.548424, 127.007218, '카페 의외의조합', 37.55394, 127.004592, '남산골공원', 37.558351, 126.993799, ' ');



INSERT INTO `Review` (`review_id`, `user_id`, `
route_id`, `reg_date`, `rating`) VALUES
(1, 'hwlee333', 1, '2024-11-01', 4);


select * from user;
select * from route;
select * from bookmark;

INSERT INTO `Bookmark` (`bookmark_id`,`user_id`, `route_id`)
VALUES (1,"hwlee333",7);






