package helpers.staticSingletonConnection;

import helpers.DatabaseFactoryHelper;
import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Singleton Pattern
// Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.
// The singleton class must provide a global access point to get the instance of the class.
// Singleton pattern is used for logging, drivers objects, caching and thread pool.
// Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
public class StaticSingletonConnectionHelper implements DatabaseFactoryHelper {

    private Logger logger = Logger.getLogger(StaticSingletonConnectionHelper.class.getName());
    private PropertiesHelper propertiesHelper;
    private Connection connection;
    private static StaticSingletonConnectionHelper instance;

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

    // lazy loading
    public static StaticSingletonConnectionHelper getInstance() {
        if (instance == null) {
            instance = new StaticSingletonConnectionHelper();
        }
        return instance;
    }

}
