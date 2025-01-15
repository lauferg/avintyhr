--liquibase formatted sql

--changeset laufer:10 dbms:postgresql
ALTER TABLE "employee_appointment" ADD FOREIGN KEY ("appointment_id") REFERENCES "appointment" ("appointment_id");