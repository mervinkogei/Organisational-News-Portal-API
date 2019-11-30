package dao;

import models.Employee;

import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);

    //List Employees
    List<Employee>getAll();

    //Find Employees By Id
    Employee findById(int id);

    //List Employees in the Department
    void getAllEmployeesByDepartment(int department_id);

    //Delete By Id
    void deleteById(int id);

    //Clear All
    void clearAll();
}
