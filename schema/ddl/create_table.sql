
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    created_by varchar(255) NOT NULL,
    updated_by varchar(255),
    version int default 0
)