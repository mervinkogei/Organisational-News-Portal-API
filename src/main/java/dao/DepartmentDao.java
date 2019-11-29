package dao;

import models.Department;
import models.Employee;
import models.News;

import java.util.List;

public interface DepartmentDao {
    void add (Department department);

    // List Department
    List<Department>getAll();

    //Find Department
    Department findById(int id);

    //List Employees
    List<Employee>getAllEmployeesForADepartment(int department_id);

    //List News
    List<News>getAllNewsForDepartment(int department_id);

    //Update Department
    void update(int id,String name,String description, int total_employees);

    // Delete
    void deleteById(int id);

    //Clear
    void clearAll();
}
