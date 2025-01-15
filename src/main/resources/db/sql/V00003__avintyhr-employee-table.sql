--liquibase formatted sql

--changeset laufer:3 dbms:postgresql
CREATE TABLE "employee" (
  "employee_id" uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
  "name" varchar NOT NULL,
  "email" varchar NOT NULL,
  "phone" varchar,
  "position_id" uuid,
  "start_date_of_work" timestamp NOT NULL DEFAULT (now()),
  "end_date_of_work" timestamp
);