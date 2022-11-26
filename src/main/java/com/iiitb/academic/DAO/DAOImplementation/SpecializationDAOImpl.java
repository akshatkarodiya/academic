package com.iiitb.academic.DAO.DAOImplementation;

import com.iiitb.academic.Bean.Specialization;
import com.iiitb.academic.DAO.SpecializationDAO;
import com.iiitb.academic.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SpecializationDAOImpl implements SpecializationDAO {
    @Override
    public boolean addSpecialization(Specialization specialization) {
        try(Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(specialization);
            transaction.commit();
            return true;
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }
}
