--liquibase formatted sql

--changeset laufer:2 dbms:postgresql
CREATE TABLE "appointment" (
  "appointment_id" uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
  "start_date_time" timestamp NOT NULL DEFAULT (now()),
  "end_date_time" timestamp NOT NULL,
  "location" varchar,
  "title" varchar NOT NULL,
  "description" text
);