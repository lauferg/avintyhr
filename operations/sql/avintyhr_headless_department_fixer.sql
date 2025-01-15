WITH departments_to_update AS (
    SELECT d.department_id
    FROM department d
    JOIN employee e ON d.manager = e.employee_id
    WHERE e.end_date_of_work < NOW() OR d.manager IS NULL
),

candidates_for_departments AS (
    SELECT DISTINCT ON (d.department_id) e.employee_id, d.department_id
    FROM employee e
    JOIN position p ON e.position_id = p.position_id
    JOIN department d ON p.department_id = d.department_id
    JOIN departments_to_update dtu ON dtu.department_id = d.department_id 
    WHERE e.end_date_of_work > NOW() OR e.end_date_of_work IS NULL
    ORDER BY d.department_id, e.start_date_of_work ASC
)

UPDATE department SET manager = ewd.employee_id
FROM employees_with_departments ewd
WHERE department.department_id = ewd.department_id;