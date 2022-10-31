package dao;

import constants.SqlQueries;
import helpers.DaoHelper;
import helpers.staticSingletonConnection.StaticSingletonConnectionHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CustomerDao implements DAO<Customer>, SqlQueries {

    public static final Logger logger = Logger.getLogger(CustomerDao.class.getName());
    private static DaoHelper daoHelper = new DaoHelper();
    public static final String EMPTY_RESULT_MESSAGE = "Query did not return any data. Please check if database table is empty.";

    /**
     * Inserts/Saves a new customer in the table.
     *
     * @param customer customer to be inserted/saved
     */
    @Override
    public void save(Customer customer) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(String.format(INSERT_CUSTOMER, customer.getName(), customer.getEmail(), customer.getPhone(), customer.getAge(), customer.isGdprConsentStatus(), customer.isCustomerProfileStatus(), customer.getProfileCreatedDate(), customer.getProfileDeactivatedDate(), customer.getDeactivationReason(), customer.getNotes()));

            logger.log(Level.INFO, "Customer is successfully saved in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates data of a customer.
     *
     * @param customer   customer object with properties to be used for the update
     * @param customerId id of the customer to be updated
     */
    @Override
    public void update(Customer customer, int customerId) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(String.format(UPDATE_CUSTOMER, customer.getName(), customer.getEmail(), customer.getPhone(), customer.getAge(), customer.isGdprConsentStatus(), customer.isCustomerProfileStatus(), customer.getProfileCreatedDate(), customer.getProfileDeactivatedDate(), customer.getDeactivationReason(), customer.getNotes(), customerId));

            logger.log(Level.INFO, String.format("Customer with id = %d was successfully updated.", customerId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a customer from the table.
     *
     * @param customerId id of the customer to be deleted
     */
    @Override
    public void delete(int customerId) {
        daoHelper.delete(customerId, CUSTOMERS_TABLE);
    }

    /**
     * Deletes all data from customer table.
     */
    @Override
    public void deleteAll() {
        daoHelper.deleteAll(CUSTOMERS_TABLE);
    }

    /**
     * Retrieves a random id from customer table.
     *
     * @return random id of customer
     */
    @Override
    public int getRandomId() {
        return daoHelper.getRandomId(CUSTOMERS_TABLE);
    }

    /**
     * Retrieves a list of random ids from customer table.
     *
     * @param numberOfIds number of ids to be retrieved
     * @return a list of random ids
     */
    @Override
    public List<Integer> getRandomIds(int numberOfIds) {
        return daoHelper.getRandomIds(numberOfIds, CUSTOMERS_TABLE);
    }

    /**
     * Finds the total count of records in customer table.
     *
     * @return count of all records in customer table
     */
    @Override
    public int getRecordsCount() {
        return daoHelper.getRecordsCount(CUSTOMERS_TABLE);
    }
}
