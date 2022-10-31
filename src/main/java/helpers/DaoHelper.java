package helpers;

import constants.SqlQueries;
import helpers.staticSingletonConnection.StaticSingletonConnectionHelper;
import model.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoHelper {

    public static final Logger logger = Logger.getLogger(DaoHelper.class.getName());
    public static final String EMPTY_RESULT_MESSAGE = "Query did not return any data. Please check if database table is empty.";

    public void save(String query) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);

            logger.log(Level.INFO, "Record is successfully saved in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id, String table) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(String.format(SqlQueries.DELETE_BY_ID, table, id));

            logger.log(Level.INFO, String.format("Record from table %s with id = %d was successfully deleted from the database.", table, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll(String table) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(String.format(SqlQueries.DELETE_ALL, table));

            logger.log(Level.INFO, String.format("All records successfully deleted from table %s.", table));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRandomId(String table) {

        int randomId = 0;

        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SqlQueries.GET_RANDOM_ID, table))) {

            if (resultSet.next()) {
                randomId = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Random ID: %d", randomId));

        return randomId;
    }

    public List<Integer> getRandomIds(int numberOfIds, String table) {

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < numberOfIds; i++) {
            ids.add(getRandomId(table));
        }

        return ids;
    }

    public int getRecordsCount(String table) {

        int count = 0;

        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SqlQueries.COUNT_RECORDS, table))) {

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Total count of records in %s table: %d", table, count));

        return count;
    }
}
