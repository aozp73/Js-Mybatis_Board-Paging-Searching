create table user_tb(
    id int auto_increment primary key,

    email varchar not null,
    username varchar(6) unique not null,
    password varchar not null,
    role varchar not null,
    created_at timestamp not null
);

create table board_tb(
    id int auto_increment primary key,
    user_id int not null,
    
    title varchar(40) not null,
    content longtext not null,
    views int not null,
    created_at timestamp not null    
);

create table comment_tb(
    id int auto_increment primary key,
    user_id int not null,
    board_id int not null,

    content longtext not null,
    created_at timestamp not null
);