package Factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OwnSessionFactory {
    private static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial OwnSessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
