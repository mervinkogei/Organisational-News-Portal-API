package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Before
    public void setUp() throws Exception {

    }
    @After
    public void tearDown() throws Exception {

    }
    // Employee Helper Method
    @Test
    public Employee setEmployee(){
        return new Employee("Kogei","Finance allocation and Budget Approval","Budget Controller",1);
    }
    @Test
    public void getName(){
        Employee employee = setEmployee();
        assertEquals("Kogei",employee.getName());
    }
    @Test
    public void getRole(){
        Employee employee = setEmployee();
            assertEquals("Finance allocation and Budget Approval",employee.getRole());
    }
    @Test
    public void getPosition(){
        Employee employee = setEmployee();
        assertEquals("Budget Controller",employee.getPosition());
    }
    @Test
    public void getDepartment_id(){
        Employee employee = setEmployee();
        assertEquals(1,employee.getDepartment_id());
    }



}
