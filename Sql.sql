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

use bugtrackerdb;
show tables;

select project_name from bugs where assigned_to = "Project Manager";

select project_id from teams where user_id = "?";

select project_id from teams where user_id in (select user_id from users where role = 'Project Manager'));
insert into importedusers values('u08','HIJ','tester','HHH@domain.com');
insert into importedusers values('u09','IJK','project manager','III@domain.com');
insert into importedusers values('u10','JKL','project manager','JJJ@domain.com');
insert into importedusers values('u11','KLM','project manager','KKK@domain.com');
insert into importedusers values('u12','LMN','project manager','LLL@domain.com');
insert into users values('u01','AAA@domain.com','developer','ABC','123abc',current_timestamp,0);
insert into users values('u02','BBB@domain.com','developer','BCD','123bcd',current_timestamp,0);
insert into users values('u03','CCC@domain.com','developer','CDE','123cde',current_timestamp,0);
insert into users values('u04','DDD@domain.com','developer','DEF','123def',current_timestamp,0);

drop table users;

create table users(
user_id varchar(200),
email_id varchar(200),
role varchar(200),
user_name varchar(200),
password varchar(200),
last_login varchar(100),
project_count varchar(200));
insert into project values('p01','market cap','visual analysis of market capitalisation',now(),'in progress');
insert into project values('p02','sales','visual analysis of market capitalisation',now(),'in progress');
insert into project values('p03','commercial banking','digital view',now(),'in progress');

insert into teams values('u12','p01');
insert into teams values('u02','p01');
insert into teams values('u03','p01');
select project_name from project where project_id in (select project_id from teams where user_id in (select user_id from users where role = 'project manager'));
insert into users values('u10','JJJ@domain.com','project manager','JKL','123jkl',current_timestamp,0);
insert into users values('u11','KKK@domain.com','project manager','KLM','123klm',current_timestamp,0);
insert into users values('u12','LLL@domain.com','project manager','LMN','123lmn',current_timestamp,0);

select project_name from project where project_id in (select project_id from teams where user_id = "u12");
use bugtrackerdb;
select * from users;
select * from project;
select * from teams;
use bugtrackerdb;
select project_name from project where project_id in (select project_id from teams where user_id in (select user_id from users where email_id = 'AAA@domain.com'));
select start_date from project where project_id in (select project_id from teams where user_id in (select user_id from users where email_id = 'AAA@domain.com'));
select user_name from users where user_id in (select user_id from teams where project_id in (select project_id from teams where user_id in (select user_id from users where email_id = 'AAA@domain.com')));
select user_name from users where user_id in (select user_id from teams where project_id in (select project_id from teams where user_id in (select user_id from users where email_id = 'AAA@domain.com'))) and role = 'project manager';
select bug_title, bug_status from bugs where project_id in (select project_id from teams where user_id in (select user_id from users where email_id = 'AAA@domain.com'));
select * from bugs;
CREATE TABLE bugs(bug_id varchar(100) PRIMARY KEY,bug_title varchar(100),bug_desc varchar(500),project_id varchar(100),created_by varchar(100),open_date date,assigned_to varchar(100),marked_for_closing boolean,closed_by  varchar(100) default null ,bug_status varchar(100),severity_level varchar(100));
insert into bugs values('b01','crash','crashing on insert button','p01','u05',now(),'u01',0,null,'open','minimal');
insert into bugs values('b02','validation','form validation bug','p01','u05',now(),'u01',1,'u10','closed','minimal');
insert into bugs values('b03','adaptability','cross adaptabilty bug','p02','u05',now(),'u02',1,'u10','closed','minimal');

