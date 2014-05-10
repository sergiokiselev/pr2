package DAO.Implementation;

import DataEntities.User;
import Utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergio on 27.04.14.
 */
public class UserDAOImpl implements DAO.UserDAO {

    @Override
    public void AddUser(User user) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if((session != null)&&(session.isOpen())) session.close();
        }
    }

    @Override
    public void DeleteUser(User user) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if((session != null)&&(session.isOpen())) session.close();
        }
    }

    @Override
    public User getUser(int id) throws SQLException {
        User result = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            result = (User)session.get(User.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if((session != null)&&(session.isOpen())) session.close();
        }

        return result;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if((session != null)&&(session.isOpen())) session.close();
        }

        return users;
    }
}
