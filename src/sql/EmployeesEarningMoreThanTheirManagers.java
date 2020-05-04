package sql;

public class EmployeesEarningMoreThanTheirManagers {


    /**
     * The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.
     *
     * +----+-------+--------+-----------+
     * | Id | Name  | Salary | ManagerId |
     * +----+-------+--------+-----------+
     * | 1  | Joe   | 70000  | 3         |
     * | 2  | Henry | 80000  | 4         |
     * | 3  | Sam   | 60000  | NULL      |
     * | 4  | Max   | 90000  | NULL      |
     * +----+-------+--------+-----------+
     * Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.
     *
     * +----------+
     * | Employee |
     * +----------+
     * | Joe      |
     * +----------+
     *
     *
     *
     * SELECT      e.Name AS Employee
     * FROM        Employee AS e
     * INNER JOIN  Employee AS m
     * ON          e.ManagerId = m.Id
     * WHERE       e.Salary > m.Salary
     *
     *
     *
     *
     * select Name as Employee from Employee as t1 where t1.ManagerId is not NULL and exists (select Salary from Employee as t2 where t1.ManagerId = t2.id and t1.Salary > t2.Salary)
     *
     *
     *
     * select e.name as Employee from employee e inner join employee e2 on e.managerId = e2.id where e.salary > e2.salary
     *
     * 
     */
}
