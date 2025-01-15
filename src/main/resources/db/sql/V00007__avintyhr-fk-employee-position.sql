--liquibase formatted sql

--changeset laufer:7 dbms:postgresql
ALTER TABLE "employee" ADD FOREIGN KEY ("position_id") REFERENCES "position" ("position_id");