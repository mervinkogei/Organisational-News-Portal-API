package dao;

import models.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sql2oEmployeeDaoTest {
    private Connection con;
    private Sql2oEmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        employeeDao = new Sql2oEmployeeDao(sql2o);
        con = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
    }

    // Helper Method to Setup Employee
    public Employee setupEmployee(){
        Employee employee = new Employee("Kogei","Budget Controller","Planning and Procurement",1);
        employeeDao.add(employee);
        return employee;
    }
    @Test
    public void add(){
        Employee employee = setupEmployee();
        assertTrue(employeeDao.getAll().contains(employee));
    }
    @Test
    public void getAll(){
        Employee employee = setupEmployee();
        Employee employee1 = setupEmployee();
        assertEquals(2,employeeDao.getAll().size());
    }
    @Test
    public void findById(){
        Employee employee = setupEmployee();
        Employee employee1 = setupEmployee();
        assertEquals(employee,employeeDao.findById(employee.getId()));
    }
    @Test
    public void getAllEmployeesByDepartment() {
        Employee employee = setupEmployee();
        List<Employee> allEmployeesByDepartment = employeeDao.getAllEmployeesByDepartment(employee.getDepartment_id());
        assertEquals(employee.getDepartment_id(),allEmployeesByDepartment.get(0).getDepartment_id());
    }
    @Test
    public void deleteById(){
        Employee employee = setupEmployee();
        Employee employee1 = setupEmployee();
        assertEquals(2,employeeDao.getAll().size());
        employeeDao.deleteById(employee.getId());
        assertEquals(1,employeeDao.getAll().size());
    }
    @Test
    public void clearAll(){
        Employee employee = setupEmployee();
        Employee employee1 = setupEmployee();
        employeeDao.clearAll();
        assertEquals(0,employeeDao.getAll().size());
    }
}
