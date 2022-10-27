package helpers.singletonConnection;

import helpers.DatabaseFactoryHelper;
import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonConnectionHelper implements DatabaseFactoryHelper {

    private Logger logger = Logger.getLogger(SingletonConnectionHelper.class.getName());
    private PropertiesHelper propertiesHelper;
    private static Connection connection;

    @Override
    public Connection getConnection() {
        try {
            // ensure new connection is created only if there is no existing one
            if (connection == null || connection.isClosed()) {
                propertiesHelper = PropertiesHelper.getHelper();

                connection = DriverManager.getConnection(
                        propertiesHelper.getUrl(),
                        propertiesHelper.getUsername(),
                        propertiesHelper.getPassword());

                if (connection != null) {
                    logger.log(Level.INFO, "Successfully connected to database using Singleton pattern.");
                }
            } else {
                System.out.println("Connection already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
