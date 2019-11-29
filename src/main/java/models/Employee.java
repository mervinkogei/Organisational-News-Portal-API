package models;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String role;
    private String position;
    private int department_id;

    public Employee(String name, String role, String position, int department_id) {
        this.name = name;
        this.role = role;
        this.position = position;
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                department_id == employee.department_id &&
                name.equals(employee.name) &&
                role.equals(employee.role) &&
                position.equals(employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, position, department_id);
    }
}
