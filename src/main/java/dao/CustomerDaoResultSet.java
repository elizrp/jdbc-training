package dao;

import constants.SqlQueries;
import helpers.FactoryHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Class CustomerDaoResultSet extends functionality of CustomerDao.
 * Implements methods using ResultSet.
 */
public class CustomerDaoResultSet extends CustomerDao {

    private static final Logger logger = Logger.getLogger(CustomerDaoResultSet.class.getName());
    private static Connection connection;
    private static FactoryHelper factoryHelper;

    public CustomerDaoResultSet() {
        factoryHelper = new FactoryHelper();
        connection = factoryHelper.getConnection();
    }

    /**
     * Extracts a single customer from the database by ID.
     * Uses ResultSet for mapping db data to pojo.
     *
     * @param id the id of the customer
     * @return Customer object
     */
    @Override
    public Customer getById(int id) {

        Customer customer = null;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     String.format(SqlQueries.GET_CUSTOMER_BY_ID, id))) {

            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt(SqlQueries.CUSTOMERS_ID_COLUMN));
                customer.setName(resultSet.getString(SqlQueries.CUSTOMERS_NAME_COLUMN));
                customer.setEmail(resultSet.getString(SqlQueries.CUSTOMERS_EMAIL_COLUMN));
                customer.setPhone(resultSet.getString(SqlQueries.CUSTOMERS_PHONE_COLUMN));
                customer.setAge(resultSet.getInt(SqlQueries.CUSTOMERS_AGE_COLUMN));
                customer.setGdprConsentStatus(resultSet.getBoolean(SqlQueries.CUSTOMERS_GDPR_CONSENT_STATUS_COLUMN));
                customer.setCustomerProfileStatus(resultSet.getBoolean(SqlQueries.CUSTOMERS_CUSTOMER_PROFILE_STATUS_COLUMN));
                customer.setProfileCreatedDate(resultSet.getDate(SqlQueries.CUSTOMERS_PROFILE_CREATED_DATE_COLUMN));
                customer.setProfileDeactivatedDate(resultSet.getDate(SqlQueries.CUSTOMERS_PROFILE_DEACTIVATED_DATE_COLUMN));
                customer.setDeactivationReason(resultSet.getString(SqlQueries.CUSTOMERS_DEACTIVATION_REASON_COLUMN));
                customer.setNotes(resultSet.getString(SqlQueries.CUSTOMERS_NOTES_COLUMN));
            } else {
                logger.log(Level.WARNING, "The database did not return any data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    /**
     * Extracts a list of objects from the database by a List of IDs.
     * Uses ResultSet for mapping db data to pojo.
     *
     * @param ids a list of ids of customers
     * @return a list of Customer objects
     */
    @Override
    public List<Customer> getByIds(List<Integer> ids) {

        List<Customer> customers = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SqlQueries.GET_CUSTOMERS_BY_IDS, ids
                     .stream()
                     .map(Object::toString)
                     .collect(Collectors.joining(", "))))) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(SqlQueries.CUSTOMERS_ID_COLUMN));
                customer.setName(resultSet.getString(SqlQueries.CUSTOMERS_NAME_COLUMN));
                customer.setEmail(resultSet.getString(SqlQueries.CUSTOMERS_EMAIL_COLUMN));
                customer.setPhone(resultSet.getString(SqlQueries.CUSTOMERS_PHONE_COLUMN));
                customer.setAge(resultSet.getInt(SqlQueries.CUSTOMERS_AGE_COLUMN));
                customer.setGdprConsentStatus(resultSet.getBoolean(SqlQueries.CUSTOMERS_GDPR_CONSENT_STATUS_COLUMN));
                customer.setCustomerProfileStatus(resultSet.getBoolean(SqlQueries.CUSTOMERS_CUSTOMER_PROFILE_STATUS_COLUMN));
                customer.setProfileCreatedDate(resultSet.getDate(SqlQueries.CUSTOMERS_PROFILE_CREATED_DATE_COLUMN));
                customer.setProfileDeactivatedDate(resultSet.getDate(SqlQueries.CUSTOMERS_PROFILE_DEACTIVATED_DATE_COLUMN));
                customer.setDeactivationReason(resultSet.getString(SqlQueries.CUSTOMERS_DEACTIVATION_REASON_COLUMN));
                customer.setNotes(resultSet.getString(SqlQueries.CUSTOMERS_NOTES_COLUMN));

                customers.add(customer);
            }

            if (customers.isEmpty()) {
                logger.log(Level.WARNING, "The database did not return any data.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
