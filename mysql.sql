create database recmgmt

use recmgmt

drop table reservation
create table reservation (
    res_id int not null auto_increment,
    court_id int not null,
    user_id int not null,
    start_time time,
    end_time time,
    start_date date,
    end_date date,
    primary key (res_id)
);

create table court (
     court_id int not null auto_increment,
     court_name varchar(255),
     court_type varchar(255),
     primary key (court_id)
);

