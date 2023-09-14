DROP TABLE IF EXISTS summary;
DROP TABLE IF EXISTS timelogs;
DROP TABLE IF EXISTS attendances;

CREATE TABLE attendances
(
    id         SERIAL PRIMARY KEY   NOT NULL,
    email      TEXT UNIQUE          NOT NULL,
    first_name TEXT,
    last_name  TEXT
--     start_work  TEXT,
--     finish_work    TEXT
);
CREATE TABLE timelogs
(
    id          SERIAL PRIMARY KEY NOT NULL,
    user_id     INTEGER     NOT NULL,
    start_work  TEXT,
    finish_work    TEXT,
    CONSTRAINT fk_attendance FOREIGN KEY (user_id) REFERENCES attendances (id) ON DELETE CASCADE
);

CREATE TABLE summary
(
    id          SERIAL PRIMARY KEY NOT NULL,
    user_id     INTEGER  UNIQUE   NOT NULL,
    time_differ  INTEGER
);
-- CREATE TABLE time
-- (
--     id         SERIAL PRIMARY KEY   NOT NULL,
--     email      TEXT UNIQUE          NOT NULL,
--     first_name TEXT,
--     last_name  TEXT,
--     start_work  TEXT,
--     finish_work    TEXT
-- );

-- INSERT INTO attendances (email,first_name, last_name)
-- VALUES ('123','cai','yilin'),('1234','rongrong','wang');

--
-- CREATE TABLE authorities
-- (
--     id        SERIAL PRIMARY KEY NOT NULL,
--     email     TEXT               NOT NULL,
--     authority TEXT               NOT NULL,
--     CONSTRAINT fk_customer FOREIGN KEY (email) REFERENCES customers (email) ON DELETE CASCADE
-- );
--
--
-- CREATE TABLE carts
-- (
--     id          SERIAL PRIMARY KEY NOT NULL,
--     customer_id INTEGER UNIQUE     NOT NULL,
--     total_price NUMERIC            NOT NULL,
--     CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE CASCADE
-- );
--
--
-- CREATE TABLE restaurants
-- (
--     id        SERIAL PRIMARY KEY NOT NULL,
--     name      TEXT               NOT NULL,
--     address   TEXT,
--     image_url TEXT,
--     phone     TEXT
-- );
--
--
-- CREATE TABLE menu_items
-- (
--     id            SERIAL PRIMARY KEY NOT NULL,
--     restaurant_id INTEGER            NOT NULL,
--     name          TEXT               NOT NULL,
--     price         NUMERIC            NOT NULL,
--     description   TEXT,
--     image_url     TEXT,
--     CONSTRAINT fk_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
-- );
--
--
-- CREATE TABLE order_items
-- (
--     id           SERIAL PRIMARY KEY NOT NULL,
--     menu_item_id INTEGER            NOT NULL,
--     cart_id      INTEGER            NOT NULL,
--     price        NUMERIC            NOT NULL,
--     quantity     INTEGER            NOT NULL,
--     CONSTRAINT fk_cart FOREIGN KEY (cart_id) REFERENCES carts (id) ON DELETE CASCADE,
--     CONSTRAINT fk_menu_item FOREIGN KEY (menu_item_id) REFERENCES menu_items (id) ON DELETE CASCADE
-- );




