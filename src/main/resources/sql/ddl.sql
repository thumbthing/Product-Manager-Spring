drop table if exists member CASCADE;
create table member
(
 id bigint generated by default as identity,
 primary key (id),
 name varchar(255),
 price INT,
 stock INT
);