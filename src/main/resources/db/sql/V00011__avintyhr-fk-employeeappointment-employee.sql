--liquibase formatted sql

--changeset laufer:11 dbms:postgresql
ALTER TABLE "employee_appointment" ADD FOREIGN KEY ("employee_id") REFERENCES "employee" ("employee_id");