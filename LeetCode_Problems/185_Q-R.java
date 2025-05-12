SELECT d.Name AS Department, 
       e.Name AS Employee, 
       e.Salary 
FROM (
    SELECT e.*,
           DENSE_RANK() OVER (PARTITION BY DepartmentId ORDER BY Salary DESC) AS salary_rank
    FROM Employee e
) e
JOIN Department d ON e.DepartmentId = d.Id
WHERE e.salary_rank <= 3;
