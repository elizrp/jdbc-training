package helpers.DatabaseSingletonHelper;

import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonHelper {

    private static PropertiesHelper propertiesHelper;

    private static Connection connection;

    static {
        try {
            // ensure new connection is created only if there is no existing one
            if (connection == null || connection.isClosed()) {
                propertiesHelper = PropertiesHelper.getHelper();

                connection = DriverManager.getConnection(
                        propertiesHelper.getUrl(),
                        propertiesHelper.getUsername(),
                        propertiesHelper.getPassword());

                if (connection != null) {
                    System.out.println("Successfully connected to database using Singleton pattern.");
                }
            } else {
                System.out.println("Connection already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
