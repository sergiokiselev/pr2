package DAO.Implementation;

import DataEntities.Membership;
import DAO.MembershipDAO;
import Utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergio on 05.05.14.
 */
public class MembershipDaoImpl implements MembershipDAO {
    @Override
    public void AddMembership(Membership membership) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(membership);
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
    public void DeleteMembership(Membership membership) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(membership);
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
    public Membership getMembership(int id) throws SQLException {
        Membership result = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Membership)session.get(Membership.class, id);
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
    public List<Membership> getAllMemberships() throws SQLException {
        List<Membership> memberships = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();   //     getCurrentSession(); // .openSession();
            memberships = session.createCriteria(Membership.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if((session != null)&&(session.isOpen())) session.close();
        }

        return memberships;
    }

    @Override
    public Membership getMembershipByLogin(String login) throws SQLException {
        List<Membership> memberships;// = getAllMemberships();

        Membership result = null;

        Session session = null;
        try{
            memberships = getAllMemberships();
            if(memberships.size() != 0){
                for(Membership membership : memberships){
                    if(membership.getLogin().compareTo(login) == 0){
                        result = membership;
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if((session != null)&&(session.isOpen())) session.close();
        }

        return result;
    }
}
