package helpers;

import dao.CustomerDaoImpl;
import helpers.DatabaseFactory;
import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryHelper implements DatabaseFactory {

    private static Logger logger = Logger.getLogger(FactoryHelper.class.getName());

    private static PropertiesHelper propertiesHelper;

    @Override
    public Connection getConnection() {
        Connection connection = null;

        try {
            propertiesHelper = PropertiesHelper.getHelper();

            connection = DriverManager.getConnection(
                    propertiesHelper.getUrl(),
                    propertiesHelper.getUsername(),
                    propertiesHelper.getPassword());

            if (connection != null) {
                logger.log(Level.INFO, "Successfully connected to database using Factory pattern.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
