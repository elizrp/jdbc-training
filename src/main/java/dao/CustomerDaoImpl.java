package dao;

import constants.SqlQueries;
import helpers.CustomerDao;
import helpers.FactoryHelper;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDaoImpl implements CustomerDao<Customer> {

    private static Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());
    private static Connection connection;
    private static FactoryHelper factoryHelper;

    public CustomerDaoImpl() {
        factoryHelper = new FactoryHelper();
        connection = factoryHelper.getConnection();
    }

    /**
     * Inserts a new customer in the table.
     *
     * @param customer
     */
    @Override
    public void save(Customer customer) {
        try (Statement statement = connection.createStatement();) {

            statement.executeUpdate(String.format(SqlQueries.INSERT_CUSTOMER, "default", "\'" + customer.getName() + "\'", "\'" + customer.getEmail() + "\'", "\'" + customer.getPhone() + "\'", customer.getAge(), customer.isGdprConsentStatus(), customer.isCustomerProfileStatus(), "\'" + customer.getProfileCreatedDate() + "\'", "\'" + customer.getProfileDeactivatedDate() + "\'", "\'" + customer.getDeactivationReason() + "\'", "\'" + customer.getNotes() + "\'"));

            logger.log(Level.INFO, "Customer is successfully saved in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates data of a customer.
     *
     * @param customer
     */
    @Override
    public void update(Customer customer, int customerId) {
        try (Statement statement = connection.createStatement();) {

            statement.executeUpdate(String.format(SqlQueries.UPDATE_CUSTOMER, "\'" + customer.getName() + "\'", "\'" + customer.getEmail() + "\'", "\'" + customer.getPhone() + "\'", customer.getAge(), customer.isGdprConsentStatus(), customer.isCustomerProfileStatus(), "\'" + customer.getProfileCreatedDate() + "\'", "\'" + customer.getProfileDeactivatedDate() + "\'", "\'" + customer.getDeactivationReason() + "\'", "\'" + customer.getNotes() + "\'", "\'" + customerId + "\'"));

            logger.log(Level.INFO, String.format("Customer with id = %d was successfully updated.", customerId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a customer from the table.
     *
     * @param customer
     */
    @Override
    public void delete(Customer customer, int customerId) {

        try (Statement statement = connection.createStatement();) {

            statement.executeUpdate(String.format(SqlQueries.DELETE_BY_ID, "\'" + customerId + "\'"));

            logger.log(Level.INFO, String.format("Customer with id = %d was successfully deleted from the database.", customerId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes all data from customer table.
     */
    @Override
    public void deleteAll() {
        try (Statement statement = connection.createStatement();) {

            statement.executeUpdate(SqlQueries.DELETE_ALL);

            logger.log(Level.INFO, "All records successfully deleted from table customers.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a random id from customer table.
     *
     * @return id
     */
    @Override
    public int getRandomId() {

        int randomId = 0;

        try (Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SqlQueries.GET_RANDOM_ID);) {
                if (resultSet.next()) {
                    randomId = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Random ID: %d", randomId));

        return randomId;
    }

    /**
     * Retrieves a list of random ids from customer table.
     *
     * @param numberOfIds number of ids to be retrieved
     * @return a list of retrieved ids
     */
    @Override
    public List<Integer> getRandomIds(int numberOfIds) {

        List<Integer> ids = new ArrayList<>();

        try (Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(String.format(SqlQueries.GET_RANDOM_IDS, numberOfIds));) {
                while (resultSet.next()) {
                    ids.add(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ids;
    }

    /**
     * Finds the total count of records in customer table.
     *
     * @return count of all records in customer table
     */
    @Override
    public int getRecordsCount() {

        int count = 0;

        try (Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SqlQueries.COUNT_RECORDS);) {
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Total count of records in customer table: %d", count));

        return count;
    }

    /**
     * TODO:
     * Extracts a single customer from the database by ID
     *
     * @param id the id of the customer
     * @return Customer object
     */
    @Override
    public Customer getById(int id) {
        logger.log(Level.INFO, "This method will be implemented in the next story.");
        return null;
    }

    /**
     * TODO:
     * Extracts a list of objects from the database by a List of IDs
     *
     * @param ids a list of ids of customers
     * @return a list of Customer objects
     */
    @Override
    public List<Customer> getByIds(List<Integer> ids) {
        logger.log(Level.INFO, "This method will be implemented in the next story.");
        return null;
    }
}
