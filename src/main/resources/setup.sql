CREATE TABLE IF NOT EXISTS product (
    ID int primary key generated,
    Image varchar(256),
    Name varchar(256),
    Description character varying,
    Type varchar(256),
    Theme varchar(256),
    Price int
);
