package DAO;

import DataEntities.Membership;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergio on 05.05.14.
 */
public interface MembershipDAO {
    public void AddMembership(Membership membership) throws SQLException;
    public void DeleteMembership(Membership membership) throws SQLException;
    public Membership getMembership(int id) throws SQLException;
    public List<Membership> getAllMemberships() throws SQLException;
    public Membership getMembershipByLogin(String login) throws SQLException;

}
