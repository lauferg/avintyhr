--liquibase formatted sql

--changeset laufer:5 dbms:postgresql
CREATE TABLE "department" (
  "department_id" uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
  "name" varchar NOT NULL,
  "manager" uuid NOT NULL
);