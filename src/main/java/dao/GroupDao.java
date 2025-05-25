package dao;

import models.Group;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.SessionFactoryUtil;

public class GroupDao {
    public Group findById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
    }
    public Group findByNumber(int number) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Group.class, number);
    }


    public void save(Group group) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.persist(group);
        t1.commit();
        session.close();
    }
    public void update(Group group) {

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.merge(group);
        t1.commit();
        session.close();
    }

    public void delete(Group group) {

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.remove(group);
        t1.commit();
        session.close();
    }
}
