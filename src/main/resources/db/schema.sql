CREATE TABLE teacher(
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `college` int NOT NULL,
  `major` int NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `modify_time` timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY key(`id`),
  UNIQUE KEY `teacheruser` (`username`)
);
CREATE TABLE student(
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` int not null,
  `age` int not null,
  `college` int NOT NULL,
  `major` int NOT NULL,
  `teacherId` int NOT NULL,
  `grade` int NOT NULL default 0,
  `status` char(1) NOT NULL DEFAULT '1',
  `modify_time` timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY key(`id`),
  UNIQUE KEY `studentuser` (`username`)
);

CREATE TABLE college(
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `modify_time` timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY key(`id`)
);
CREATE TABLE major(
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `modify_time` timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY key(`id`)
);
CREATE TABLE admin(
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `modify_time` timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY key(`id`)
);
create table message(
  `id` int(11) NOT NULL auto_increment,
  `studentId` int NOT NULL,
  `message` varchar(200) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `modify_time` timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY key(`id`)
);
