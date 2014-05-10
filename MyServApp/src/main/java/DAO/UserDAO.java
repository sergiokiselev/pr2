package DAO;

import DataEntities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergio on 27.04.14.
 */
public interface UserDAO {
    public void AddUser(User user) throws SQLException;
    public void DeleteUser(User user) throws SQLException;
    public User getUser(int id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
}
