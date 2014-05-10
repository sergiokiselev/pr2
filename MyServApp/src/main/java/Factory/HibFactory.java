package Factory;

import DAO.Implementation.ConfigItemDaoImpl;
import DAO.Implementation.MembershipDaoImpl;
import DAO.Implementation.UserDAOImpl;

/**
 * Created by Sergio on 27.04.14.
 */
public class HibFactory {
    public static HibFactory instance = new HibFactory();
    private UserDAOImpl userDAO;
    private MembershipDaoImpl membershipDao;
    private ConfigItemDaoImpl configItemDao;

    private HibFactory(){}

    public static HibFactory getInstance(){
        return HibFactory.instance;
    }

    public UserDAOImpl getUserDAO(){
        if(userDAO == null) userDAO = new UserDAOImpl();
        return userDAO;
    }

    public  MembershipDaoImpl getMembershipDao(){
        if(membershipDao == null)
            membershipDao = new MembershipDaoImpl();
        return membershipDao;
    }

    public ConfigItemDaoImpl getConfigItemDao() {
        if(configItemDao == null)
            configItemDao = new ConfigItemDaoImpl();
        return configItemDao;
    }
}
