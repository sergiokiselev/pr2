package DAO;

import DataEntities.ConfigItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergio on 10.05.14.
 */
public interface ConfigItemDao {
    public void addConfigItem(ConfigItem configItem) throws SQLException;
    public void deleteConfigItem(ConfigItem configItem) throws SQLException;
    public ConfigItem getConfigItem(int id) throws SQLException;
    public List<ConfigItem> getAllConfigItems() throws SQLException;
    public List<ConfigItem> getConfigItemsByUser(int userId) throws SQLException;
    public ConfigItem getConfigItemByName(String configItemName) throws SQLException;
    public List<ConfigItem> getConfigItemsByTag(String tag) throws SQLException;

}
