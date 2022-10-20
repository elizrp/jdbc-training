package helpers;

import helpers.DatabaseFactoryHelper.FactoryHelper;
import helpers.DatabaseSingletonHelper.SingletonHelper;
import helpers.constants.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    public static void main(String[] args) throws SQLException {

        // use Factory pattern to create db connection
        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = FactoryHelper.createConnection()){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(Constants.GET_ALL_CUSTOMERS);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(Constants.CUSTOMERS_NAME_COLUMN));
            }
        }

        // use Singleton pattern to create db connection
        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = SingletonHelper.getConnection()){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(Constants.GET_ALL_CUSTOMERS);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(Constants.CUSTOMERS_NAME_COLUMN));
            }
        }
    }
}
