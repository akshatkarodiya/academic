package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.Employee;
import com.iiitb.academic.DAO.EmployeeDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee login(Employee employee){
        try (Session session = HibernateSessionUtil.getSession()){
            String employeeEmail = employee.getEmail();
            String employeePassword = employee.getPassword();
            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                            "FROM Employee WHERE email = :employeeEmail AND password = :employeePassword"
                            )
                            .setParameter("employeeEmail", employeeEmail)
                            .setParameter("employeePassword", employeePassword)
                            .list()

            );
            if(result.size()==0)
                return null;
            else {
                Employee emp =  (Employee) result.get(0);
                if(emp.getDepartment().getDepartmentID() == 1){
                    return emp;
                }
                else {
                    return null;
                }
            }
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
    @Override
    public boolean addEmployee(Employee employee){

        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
