CREATE USER 'myuser'@'localhost' IDENTIFIED BY 'mypass';
CREATE USER 'myuser'@'%' IDENTIFIED BY 'mypass';
GRANT ALL PRIVILEGES ON projetoIntegrador.* TO 'myuser'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;