package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.CourseSchedule;
import com.iiitb.academic.DAO.CourseScheduleDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseScheduleDAOImpl implements CourseScheduleDAO {

    @Override
    public boolean addCourseSchedule(CourseSchedule courseSchedule) {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(courseSchedule);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
