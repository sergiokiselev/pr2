package DAO.Implementation;

import DAO.ConfigItemDao;
import DataEntities.ConfigItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergio on 10.05.14.
 */
public class ConfigItemDaoImpl implements ConfigItemDao {
    @Override
    public void addConfigItem(ConfigItem configItem) throws SQLException {

    }

    @Override
    public void deleteConfigItem(ConfigItem configItem) throws SQLException {

    }

    @Override
    public ConfigItem getConfigItem(int id) throws SQLException {
        return null;
    }

    @Override
    public List<ConfigItem> getAllConfigItems() throws SQLException {
        return null;
    }

    @Override
    public List<ConfigItem> getConfigItemsByUser(int userId) throws SQLException {
        return null;
    }

    @Override
    public ConfigItem getConfigItemByName(String configItemName) throws SQLException {
        return null;
    }

    @Override
    public List<ConfigItem> getConfigItemsByTag(String tag) throws SQLException {
        return null;
    }
}
