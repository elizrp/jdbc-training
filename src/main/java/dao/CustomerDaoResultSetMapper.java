package dao;

import constants.SqlQueries;
import helpers.FactoryHelper;
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

    private static final Logger logger = Logger.getLogger(CustomerDaoResultSetMapper.class.getName());

    @Override
    public Customer getById(int id) {

        Customer customer = null;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     String.format(SqlQueries.GET_CUSTOMER_BY_ID, id))) {

            ResultSetMapper<Customer> resultSetMapper = new ResultSetMapper<>();

            // simple JDBC code to run SQL query and populate resultSet - END
            customer = resultSetMapper.mapResultSetToSingleObject(resultSet, Customer.class);
            // print out the list retrieved from database
            if (customer != null) {
                System.out.println(customer);
            } else {
                logger.log(Level.INFO, "ResultSet is empty. Please check if database table is empty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public List<Customer> getByIds(List<Integer> ids) {

        List<Customer> customersList = null;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SqlQueries.GET_CUSTOMERS_BY_IDS, ids
                     .stream()
                     .map(Object::toString)
                     .collect(Collectors.joining(", "))))) {

            ResultSetMapper<Customer> resultSetMapper = new ResultSetMapper<>();

            // simple JDBC code to run SQL query and populate resultSet
            customersList = resultSetMapper.mapResultSetToMultipleObjects(resultSet, Customer.class);
            // print out the list retrieved from database
            if (customersList != null) {
                for (Customer customer : customersList) {
                    System.out.println(customer);
                }
            } else {
                logger.log(Level.INFO, "ResultSet is empty. Please check if database table is empty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customersList;
    }
}
