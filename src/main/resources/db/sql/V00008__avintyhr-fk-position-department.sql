--liquibase formatted sql

--changeset laufer:8 dbms:postgresql
ALTER TABLE "position" ADD FOREIGN KEY ("department_id") REFERENCES "department" ("department_id");