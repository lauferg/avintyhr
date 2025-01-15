--liquibase formatted sql

--changeset laufer:1 dbms:postgresql
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
