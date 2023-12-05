package domain;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

public class HibernateUtil {
    private static final SessionFactory sf;

    static{
        Configuration cfg = new Configuration();
        cfg.configure();
        sf = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sf;
    }

}
