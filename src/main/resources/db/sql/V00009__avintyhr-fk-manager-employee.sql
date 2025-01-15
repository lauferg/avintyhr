--liquibase formatted sql

--changeset laufer:9 dbms:postgresql
ALTER TABLE "department" ADD FOREIGN KEY ("manager") REFERENCES "employee" ("employee_id");