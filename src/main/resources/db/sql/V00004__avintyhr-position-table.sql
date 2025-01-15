--liquibase formatted sql

--changeset laufer:4 dbms:postgresql
CREATE TABLE "position" (
  "position_id" uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
  "department_id" uuid NOT NULL,
  "name" varchar NOT NULL
);