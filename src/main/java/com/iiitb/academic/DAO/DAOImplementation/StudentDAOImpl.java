package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.Student;
import com.iiitb.academic.DAO.StudentDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

}
