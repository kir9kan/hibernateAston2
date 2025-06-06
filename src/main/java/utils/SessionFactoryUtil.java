package utils;

import models.AllUser;
import models.Group;
import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public SessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(AllUser.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());


            } catch (Exception e) {
                System.out.println("Возникло исключение в фабрике сессий" + e);

            }
        }
        return sessionFactory;

    }
}
