import constants.SqlQueries;
import dao.*;
import helpers.objectBuilding.AddressHelper;
import helpers.objectBuilding.CustomerHelper;
import helpers.factoryConnection.FactoryConnectionHelper;
import helpers.singletonConnection.SingletonConnectionHelper;
import model.Address;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static FactoryConnectionHelper factoryHelper;
    private static SingletonConnectionHelper singletonHelper;
    private static CustomerDao customerDao;
    private static CustomerDaoDBUtils customerDaoDBUtils;
    private static AddressDao addressDao;
    private static Customer customer;
    private static Address address;

    public static void main(String[] args) throws SQLException {

//        customerDao = new CustomerDaoDBUtils();
//        customerDao.getCustomerAddressOrderProduct(); // unrecognized
//        customerDao = new CustomerDaoDBUtils();
//        customerDao.getById(8);
        addressDao = new AddressDaoDBUtils();
//        addressDao.getById(4);
//        List<Integer> addressIds = new ArrayList<>();
//        addressIds.add(2);
//        addressIds.add(7);
//        addressIds.add(9);
//        addressDao.getByIds(addressIds);

//        addressDao.update(AddressHelper.createAddress(), 1);
        addressDao.save(AddressHelper.createAddress());

//        // CONNECTION
//        // use Factory pattern to create db connection
//        factoryHelper = new FactoryConnectionHelper();
//        testCreateDbConnectionFactory(factoryHelper);
//
//        // use Singleton pattern to create db connection
//        singletonHelper = new SingletonConnectionHelper();
//        testCreateDbConnectionSingleton(singletonHelper);
//
//        // create a single Customer object and print its properties
//        testCreateSingleCustomer();
//
//        // create multiple Customer objects and print their properties
//        testCreateMultipleCustomers(3);
//
//        // CRUD
//        // create Customer object to test CRUD operations
//        customer = CustomerHelper.createCustomer();
//
//        // initialize customerDao to run CRUD operations
//        customerDao = new CustomerDaoResultSet();
//
//        // save customer
//        customerDao.save(customer);
//
//        // update customer
//        customerDao.update(customer, 5);
//
//        // delete customer
//        customerDao.delete(26);
//        // truncate table
//        customerDao.deleteAll();
//        // get a random id of db record
//        customerDao.getRandomId();
//        // get a list of X random records ids
//        List<Integer> resultIds = customerDao.getRandomIds(3);
//        for (int id : resultIds) {
//            System.out.println("Retrieved random ID: " + id);
//        }
//        // get the count of all records in the table
//        customerDao.getRecordsCount();
//
//        // DATA-MAPPING
//        // extract a single object from the database by ID
//        // 1. using ResultSet
//        customerDao = new CustomerDaoResultSet();
//        customerDao.getById(6);
//        // 2. using ResultSetMapper
//        customerDao = new CustomerDaoResultSetMapper();
//        customerDao.getById(11);
//        // 3. using DBUtils
//        customerDao = new CustomerDaoDBUtils();
//        customerDao.getById(8);
//
//        // extract a list of objects from the database by a List of IDs
//        // create a list of customers first
//        List<Integer> customerIds = new ArrayList<>();
//        customerIds.add(2);
//        customerIds.add(7);
//        customerIds.add(9);
//        1. using ResultSet
//        customerDao = new CustomerDaoResultSet();
//        customerDao.getByIds(customerIds);
//        2. using ResultSetMapper
//        customerDao = new CustomerDaoResultSetMapper();
//        customerDao.getByIds(customerIds);
//        3. using DBUtils
//        customerDao = new CustomerDaoDBUtils();
//        customerDao.getByIds(customerIds);

//        address = AddressHelper.createAddress();
//        System.out.println(address.toString());
    }

    // Test DB connection
    private static void testCreateDbConnectionFactory(FactoryConnectionHelper factoryHelper) {

        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = factoryHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlQueries.GET_ALL_CUSTOMERS)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(SqlQueries.CUSTOMERS_NAME_COLUMN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testCreateDbConnectionSingleton(SingletonConnectionHelper singletonHelper) {

        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = singletonHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlQueries.GET_ALL_CUSTOMERS)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(SqlQueries.CUSTOMERS_NAME_COLUMN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Build customer objects
    private static void testCreateSingleCustomer() {
        Customer customer = CustomerHelper.createCustomer();
        System.out.println(customer.toString());
    }

    private static void testCreateMultipleCustomers(int numberOfCustomers) {
        List<Customer> customerList = CustomerHelper.createCustomers(numberOfCustomers);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
