DROP TABLE IF EXISTS summary;
DROP TABLE IF EXISTS timelogs;
DROP TABLE IF EXISTS attendances;
DROP TABLE IF EXISTS tests;
CREATE TABLE attendances
(
    id         SERIAL PRIMARY KEY   NOT NULL,
    email      TEXT UNIQUE          NOT NULL,
    first_name TEXT,
    last_name  TEXT
);
CREATE TABLE timelogs
(
    id          SERIAL PRIMARY KEY NOT NULL,
    user_id     INTEGER     NOT NULL,
    start_work  TIMESTAMP,
    finish_work    TIMESTAMP,
    total_time INTEGER,
    CONSTRAINT fk_attendance FOREIGN KEY (user_id) REFERENCES attendances (id) ON DELETE CASCADE
);

-- CREATE TABLE summary
-- (
--     id          SERIAL PRIMARY KEY NOT NULL,
--     user_id     INTEGER  UNIQUE   NOT NULL,
--     time_differ  INTEGER
-- );

-- CREATE TABLE tests
-- (
--     id          SERIAL PRIMARY KEY NOT NULL,
--     test_start  TIMESTAMP,
--     test_finish  TIMESTAMP
-- );




