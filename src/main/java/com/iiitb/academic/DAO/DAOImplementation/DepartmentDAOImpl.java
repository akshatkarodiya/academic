package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.Department;
import com.iiitb.academic.DAO.DepartmentDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public boolean addDepartment(Department department) {

        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

}
