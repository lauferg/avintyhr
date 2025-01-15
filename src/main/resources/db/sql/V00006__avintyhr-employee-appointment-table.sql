--liquibase formatted sql

--changeset laufer:6 dbms:postgresql
CREATE TABLE "employee_appointment" (
  "appointment_id" uuid NOT NULL,
  "employee_id" uuid NOT NULL,
  PRIMARY KEY ("appointment_id", "employee_id")
);