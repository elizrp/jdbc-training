package helpers.DatabaseFactoryHelper;

import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;

public class FactoryHelper {

    private static PropertiesHelper propertiesHelper;

    public static Connection createConnection() {
        Connection connection = null;

        try {
            propertiesHelper = PropertiesHelper.getHelper();

            connection = DriverManager.getConnection(
                    propertiesHelper.getUrl(),
                    propertiesHelper.getUsername(),
                    propertiesHelper.getPassword());

            if (connection != null) {
                System.out.println("Successfully connected to database using Factory pattern.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
