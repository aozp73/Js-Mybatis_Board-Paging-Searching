INSERT INTO board_tb(id, user_id, title, content, views, created_at)
values(1, 1,'1번째 제목', '1번째 내용', 13, '2023-09-13 12:34:56');
INSERT INTO board_tb(id, user_id, title, content, views, created_at)
values(2, 2,'2번째 제목', '2번째 내용', 2, '2023-11-30 08:21:56');
INSERT INTO board_tb(id, user_id, title, content, views, created_at)
values(3, 2,'3번째 제목', '3번째 내용', 7, '2023-12-13 10:34:56');
INSERT INTO board_tb(id, user_id, title, content, views, created_at)
values(4, 1,'4번째 제목', '4번째 내용', 6, '2023-12-21 14:34:56');

INSERT INTO user_tb(id, email, username, password, role, created_at)
values(1, 'aozp73@naver.com', 'aozp73', '$2a$12$HB0FWwVKeyiF/7w3/6tgyORjEiZzodMe8etYRVBQ8eOC7iIHpzMvK', 'Common', now());
INSERT INTO user_tb(id, email, username, password, role, created_at)
values(2, 'po1630@naver.com', 'totoro', '$2a$12$HB0FWwVKeyiF/7w3/6tgyORjEiZzodMe8etYRVBQ8eOC7iIHpzMvK', 'Common', now());