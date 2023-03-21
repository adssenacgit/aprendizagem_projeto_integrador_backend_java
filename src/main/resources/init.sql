CREATE USER 'myuser'@'localhost' IDENTIFIED BY 'mypass';
CREATE USER 'myuser'@'%' IDENTIFIED BY 'mypass';
GRANT ALL PRIVILEGES ON myuser.* TO 'myuser'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;