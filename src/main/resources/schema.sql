CREATE TABLE APP_USER (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(50) NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL
);