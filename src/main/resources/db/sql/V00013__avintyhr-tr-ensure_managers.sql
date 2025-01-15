--liquibase formatted sql

--changeset laufer:13 dbms:postgresql
CREATE TRIGGER trigger_ensure_managers
AFTER INSERT ON employee_appointment
FOR EACH ROW
EXECUTE FUNCTION afins_ensure_appointment_has_manager();