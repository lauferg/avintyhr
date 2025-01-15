--liquibase formatted sql

--changeset laufer:12 dbms:postgresql endDelimiter://
CREATE OR REPLACE FUNCTION public.afins_ensure_appointment_has_manager()
 RETURNS trigger
AS $$
    DECLARE
        participant_ids UUID[];
        participating_managers UUID[];
        manager_id UUID;
        num_initial_managers INT;
    BEGIN
        --Check if there is at least 1 manager as participant in the appointment.
        SELECT COUNT(*)
        INTO num_initial_managers
        FROM employee
        JOIN position ON employee.position_id = position.position_id AND employee_id = ANY(participant_ids)
        JOIN department ON position.department_id = department.department_id;
        
        --If there's at least 1 manager: nothing to do. Otherwise add the managers of everyone participating in the meeting.
        IF num_initial_managers > 0 THEN
            RETURN NULL;
        END IF;

        --Get all participants for the new appointment.
        SELECT ARRAY_AGG(employee_id)
        INTO participant_ids
        FROM employee_appointment
        WHERE appointment_id = NEW.appointment_id;
        
        --Get all managers of the current participants.
        SELECT ARRAY_AGG(department.manager)
        INTO participating_managers
        FROM employee
        JOIN position ON employee.position_id = position.position_id AND employee.employee_id = ANY(participant_ids)
        JOIN department ON position.department_id = department.department_id;

        --Add every manager that hasn't been added to the meeting.
        FOREACH manager_id IN ARRAY participating_managers LOOP
            IF manager_id IS NOT NULL AND NOT (manager_id = ANY(participant_ids)) THEN
             INSERT INTO employee_appointment (appointment_id, employee_id) VALUES (NEW.appointment_id, manager_id);
            END IF;
        END LOOP;
        
        RETURN NULL; --After insert trigger, nothing to do.
    END;
$$
LANGUAGE plpgsql;