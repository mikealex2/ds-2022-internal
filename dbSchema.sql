CREATE TABLE `user`(
    `username` varchar(50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
);

SELECT * FROM user;

CREATE TABLE `authorities`(
    `username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `ix_auth_username` (`username`,`authority`),
    CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE
);

SELECT * FROM authorities;

INSERT INTO `user` (`username`, `password`, `enabled`) VALUES
    ('admin', '$2a$12$rN105y6RzMaOfd5tr7dBbuNEwmFGLHITNT4xH2XaMlQaPcDksf80i', 1);

INSERT INTO `authorities` (`username`, `authority`) VALUES
    ('admin', 'ROLE_ADMIN');

CREATE TABLE `APPLICATION`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `user` varchar(50),
 `firstName` VARCHAR(30),
 `lastName` VARCHAR(30),
 `email` VARCHAR(40),
 `amka` INT(20),
 `stratNumber` INT(40),
 `reasonOfDelay`  VARCHAR(300),
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM APPLICATION;

CREATE TABLE `VALIDATED_APPLICATION`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `office_username` varchar(50) NOT NULL,
 `citizen_username` varchar(50) NOT NULL,
 `citizen_firstName` VARCHAR(30) NOT NULL,
 `citizen_lastName` VARCHAR(30) NOT NULL,
 `citizen_email` VARCHAR(40) NOT NULL,
 `citizen_amka` INT(20) NOT NULL,
 `citizen_STRAT_NUMBER` INT(40) NOT NULL,
 `REASON_TIME_DELAY`  VARCHAR(300) NOT NULL,
  PRIMARY KEY(`id`),
  foreign key (`office_username`) references `user`(`username`)
  ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM VALIDATED_APPLICATION;

CREATE TABLE `FINAL_APPLICATION`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `army_office_username` varchar(50) NOT NULL,
 `citizen_username` varchar(50) NOT NULL,
 `citizen_firstName` VARCHAR(30) NOT NULL,
 `citizen_lastName` VARCHAR(30) NOT NULL,
 `citizen_email` VARCHAR(40) NOT NULL,
 `citizen_amka` INT(20) NOT NULL,
 `citizen_STRAT_NUMBER` INT(40) NOT NULL,
 `citizen_present_age`  VARCHAR(10) NOT NULL,
  PRIMARY KEY(`id`),
  foreign key (`army_office_username`) references `user`(`username`)
  ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM FINAL_APPLICATION;