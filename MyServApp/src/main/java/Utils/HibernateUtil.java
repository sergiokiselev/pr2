package Utils;

/**
 * Created by Sergio on 27.04.14.
 */

import java.io.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    private HibernateUtil(){};

    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null){
            File file;
            file = new File("C:\\Users\\Sergio\\IdeaProjects\\MyServApp\\src\\hibernate.cfg.xml");
            boolean exx = file.exists();
            sessionFactory =  new Configuration().configure(file).buildSessionFactory();
        }

        return sessionFactory;
    }


}
