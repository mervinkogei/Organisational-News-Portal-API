package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void DepartmentInstantiatesCorrectly() throws Exception {
        Department department = setupDepartment();
        assertTrue(department instanceof Department);
    }

    @Test
    public void getName() {
        Department department = setupDepartment();
        assertEquals("Finance", department.getName());
    }

    @Test
    public void getDescription() {
        Department department = setupDepartment();
        assertEquals("Sales and Procurement", department.getDescription());
    }

    @Test
    public void getTotal_employees() {
        Department department = setupDepartment();
        assertEquals("50", department.getTotal_employees());
    }

    // SetUp Helper Method
    public Department setupDepartment() {
        return new Department("Finance", "Sales and Procurement", 50);
    }
    @Test
    public void setId() {
        Department department = setupDepartment();
        department.setId(4);
        assertNotEquals(4, department.getId());
    }
    @Test
    public void setName(){
        Department department = setupDepartment();
        department.setName("Finance");
        assertEquals("Sales and Procurement",department.getName());
    }

}
