package dao;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sql2oDepartmentDaoTest {
    private Connection con;
    private Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        con = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    // Helper Method to SetUpDepartment
    public Department setupDepartment(){
        Department department = new Department("Finance","Planning and Procurement",50);
        departmentDao.add(department);
        return department;
    }
    @Test
    public void add(){
        Department department = setupDepartment();
        assertTrue(departmentDao.getAll().contains(department));
    }
    @Test
    public void getAll(){
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(2,departmentDao.getAll().size());
    }
    @Test
    public void findById(){
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(department1,departmentDao.findById(department1.getId()));
    }
    @Test
    public void deleteById(){
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(2,departmentDao.getAll().size());
        departmentDao.deleteById(department.getId());
        assertEquals(1,departmentDao.getAll().size());
    }
    @Test
    public void clearAll(){
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        departmentDao.clearAll();
        assertEquals(0,departmentDao.getAll().size());
    }
}
