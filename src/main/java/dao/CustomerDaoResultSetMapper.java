package dao;

import constants.SqlQueries;
import helpers.ResultSetMapperHelper;
import helpers.staticSingletonConnection.StaticSingletonConnectionHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Class CustomerDaoResultSetMapper extends functionality of CustomerDao.
 * Implements methods using ResultSetMapper.
 */
public class CustomerDaoResultSetMapper extends CustomerDao {

    /**
     * Extracts a single customer from the database by ID.
     * Uses ResultSetMapper for mapping db data to pojo.
     *
     * @param id the id of the customer
     * @return Customer object with corresponding id
     */
    @Override
    public Customer getById(int id) {

        Customer customer = null;

        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     String.format(SqlQueries.GET_CUSTOMER_BY_ID, id))) {

            ResultSetMapperHelper<Customer> resultSetMapper = new ResultSetMapperHelper<>();

            // simple JDBC code to run SQL query and populate resultSet
            customer = resultSetMapper.mapResultSetToObject(resultSet, Customer.class);
            // print out the list retrieved from database
            if (customer != null) {
                System.out.println(customer);
            } else {
                logger.log(Level.INFO, EMPTY_RESULT_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    /**
     * Extracts a list of objects from the database by a List of IDs.
     * Uses ResultSetMapper for mapping db data to pojo.
     *
     * @param ids a list of ids of customers
     * @return a list of Customer objects with corresponding ids
     */
    @Override
    public List<Customer> getByIds(List<Integer> ids) {

        List<Customer> customers = null;

        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SqlQueries.GET_CUSTOMERS_BY_IDS, ids
                     .stream()
                     .map(Object::toString)
                     .collect(Collectors.joining(", "))))) {

            ResultSetMapperHelper<Customer> resultSetMapper = new ResultSetMapperHelper<>();

            // simple JDBC code to run SQL query and populate resultSet
            customers = resultSetMapper.mapResultSetToObjects(resultSet, Customer.class);
            // print out the list retrieved from database
            if (customers != null) {
                for (Customer customer : customers) {
                    System.out.println(customer);
                }
            } else {
                logger.log(Level.INFO, EMPTY_RESULT_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
