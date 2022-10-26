package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryHelper implements DatabaseFactoryHelper {

    private static Logger logger = Logger.getLogger(FactoryHelper.class.getName());

    private static PropertiesHelper propertiesHelper;
    private static Connection connection;

    @Override
    public Connection getConnection() {

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

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
