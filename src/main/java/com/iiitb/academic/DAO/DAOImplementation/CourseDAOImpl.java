package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.Course;
import com.iiitb.academic.DAO.CourseDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean addCourse(Course course) {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
