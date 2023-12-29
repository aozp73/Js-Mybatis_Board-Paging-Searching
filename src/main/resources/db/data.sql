INSERT INTO board_tb(id, user_id, title, content, views, created_at)
values(1, 1,'1번째 제목', '1번째 내용', 0, now());

INSERT INTO user_tb(id, email, username, password, role, created_at)
values(1, 'aozp73@naver.com', 'aozp73', '$2a$12$HB0FWwVKeyiF/7w3/6tgyORjEiZzodMe8etYRVBQ8eOC7iIHpzMvK', 'Common', now());