CREATE TABLE IF NOT EXISTS PRODUCTS (
    p_id bigint AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS REVIEWS (
    r_id bigint AUTO_INCREMENT PRIMARY KEY,
    product_id bigint,
    foreign key (product_id) references PRODUCTS (p_id)
);

CREATE TABLE IF NOT EXISTS COMMENTS (
    c_id bigint AUTO_INCREMENT PRIMARY KEY,
    info VARCHAR(300),
    review_id bigint,
    foreign key (review_id) references REVIEWS (r_id)
);