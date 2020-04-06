CREATE TABLE products (
                          id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(300)
);

CREATE TABLE comments (
                          id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          comment VARCHAR(300)
);

CREATE TABLE reviews (
                         id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY
);