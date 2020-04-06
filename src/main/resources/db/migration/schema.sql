CREATE TABLE products (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(300)
);

CREATE TABLE reviews (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id bigint,
    foreign key (product_id) references products (id)
);

CREATE TABLE comments (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    info VARCHAR(300),
    review_id bigint,
    foreign key (review_id) references comments (id)
);