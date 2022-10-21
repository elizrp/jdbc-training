package helpers;

import helpers.DatabaseFactoryHelper.FactoryHelper;
import helpers.DatabaseSingletonHelper.SingletonHelper;
import helpers.constants.SqlQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static FactoryHelper factoryHelper;
    private static SingletonHelper singletonHelper;

    public static void main(String[] args) throws SQLException {

        factoryHelper = new FactoryHelper();

        // use Factory pattern to create db connection
        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = factoryHelper.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SqlQueries.GET_ALL_CUSTOMERS);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(SqlQueries.CUSTOMERS_NAME_COLUMN));
            }
        }

        singletonHelper = new SingletonHelper();

        // use Singleton pattern to create db connection
        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = singletonHelper.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SqlQueries.GET_ALL_CUSTOMERS);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(SqlQueries.CUSTOMERS_NAME_COLUMN));
            }
        }
    }
}
