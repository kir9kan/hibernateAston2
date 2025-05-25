package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.SessionFactoryUtil;

import java.util.List;

public class UserDao {
    public User findById(int id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public User findBySecondName(String secondName) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(User.class, secondName);
    }

    public void save(User user) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.persist(user);
        t1.commit();
        session.close();
    }

    public void update(User user) {

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.merge(user);
        t1.commit();
        session.close();
    }

    public void delete(User user) {

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        session.remove(user);
        t1.commit();
        session.close();
    }

    public List<User> findAllUsers() {
        List<User> userList = (List<User>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return userList;
    }
}
