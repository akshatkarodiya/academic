package com.iiitb.academic.DAO;
import com.iiitb.academic.Bean.Employee;

public interface EmployeeDAO {
    Employee login(Employee employee);
    boolean addEmployee(Employee employee);
}
