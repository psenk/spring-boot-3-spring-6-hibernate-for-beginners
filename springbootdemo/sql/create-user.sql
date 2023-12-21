-- DROP USER FIRST IF EXISTS
DROP USER IF EXISTS 'springstudent'@'localhost';

-- CREATE USER W/ PROP PRIVILEGES
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';