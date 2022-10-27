package helpers.factoryConnection;

import helpers.DatabaseFactoryHelper;
import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryConnectionHelper implements DatabaseFactoryHelper {

    private static Logger logger = Logger.getLogger(FactoryConnectionHelper.class.getName());
    private static PropertiesHelper propertiesHelper = PropertiesHelper.getHelper();

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
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
