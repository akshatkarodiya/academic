package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.StudentCourse;
import com.iiitb.academic.DAO.StudentCourseDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentCourseImpl implements StudentCourseDAO {
    @Override
    public boolean addStudentCourse(StudentCourse studentCourse) {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(studentCourse);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
