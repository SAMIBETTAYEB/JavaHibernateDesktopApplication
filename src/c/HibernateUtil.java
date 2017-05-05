package c;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Bettayeb on 5/4/2017.
 */

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Session factory creation using the hibernate.cfg.xml file
            sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // public static final ThreadLocal session = new ThreadLocal();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private HibernateUtil(){}

}
