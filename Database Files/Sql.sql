create database bugtrackerdb;
use bugtrackerdb;
create table ImportedUsers(
user_id varchar(200) Not null ,
user_name varchar(200),
email_id varchar(150),
role varchar(50),
primary key (user_id));

create table project(
project_id varchar(200) not null,
project_name varchar(200),
project_desc varchar(200),
start_date varchar(200),
project_status varchar(200),
primary key (project_id));

create table users(
password varchar(200),
last_login timestamp,
project_counter int);
drop table users;

create table users(
user_id varchar(200),
email_id varchar(200),
role varchar(200),
user_name varchar(200),
password varchar(200),
last_login varchar(100),
project_count varchar(200),
foreign key (user_id) references importedusers(user_id));

create table teams(
user_id varchar(200),
project_id varchar(200));

create table Bugs(
bug_id int not null,
bug_desc varchar(200),
project_name varchar(150),
created_by varchar(150),
open_date varchar(200),
assigned_to varchar(200),
marked_for_closing varchar(200),
closed_by varchar(200),
closed_on varchar(205),
start_date varchar(205),
bug_severity varchar(200));
show tables;
select project_id from teams where user_id = "?";
select project_name from bugs where assigned_to = "Project Manager";

select * from project;

select * from bugs;

select user_name from importedusers where role = "Developer";
select user_id from teams where project_id = " ? ";