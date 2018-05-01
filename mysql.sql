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

create table recmgmt.Event (eventID int NOT NULL AUTO_INCREMENT,
							eventName varchar(30) DEFAULT 'Trek', 
							eventType VARCHAR(30) DEFAULT 'Trip',
							eventLimit int DEFAULT 25,
							currentSize int DEFAULT 0,
							startDate DATE NOT NULL,
							startTime TIME NOT NULL,
							endDate DATE NOT NULL,
							endTime TIME NOT NULL,
							PRIMARY KEY (eventID));
							

create table recmgmt.EventRegistration(regID varchar(20) NOT NULL,
									   eventID int NOT NULL,
									   userID int NOT NULL,
									   eventType varchar(30),
									   PRIMARY KEY(regID),
									   FOREIGN KEY (eventID) REFERENCES recmgmt.Event (eventID));