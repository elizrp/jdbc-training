import constants.SqlQueries;
import dao.CustomerDao;
import dao.CustomerDaoDBUtils;
import dao.CustomerDaoResultSet;
import dao.CustomerDaoResultSetMapper;
import helpers.CustomerHelper;
import helpers.FactoryHelper;
import helpers.SingletonHelper;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static FactoryHelper factoryHelper;
    private static SingletonHelper singletonHelper;
    private static CustomerDao customerDao;
    private static Customer customer;

    public static void main(String[] args) throws SQLException {

//        // CONNECTION
//DEMO    // use Factory pattern to create db connection
//        factoryHelper = new FactoryHelper();
//        testCreateDbConnectionFactory(factoryHelper);
//
//        // use Singleton pattern to create db connection
//        singletonHelper = new SingletonHelper();
//        testCreateDbConnectionSingleton(singletonHelper);
//
//        // create a single Customer object and print its properties
//        testCreateSingleCustomer();
//
//DEMO    // create multiple Customer objects and print their properties
//        testCreateMultipleCustomers(3);
//
//        // CRUD
//        // create Customer object to test CRUD operations
//        customer = CustomerHelper.createSingleCustomer();
//
//        // initialize customerDao to run CRUD operations
//        customerDao = new CustomerDaoResultSet();
//
//DEMO    // save customer
//        testSaveCustomer(customer, customerDao);
//
//        // update customer
//        testUpdateCustomer(customer, customerDao, 5);
//
//        // delete customer
//        testDeleteCustomer(customerDao, 16);
//
//        // truncate table
//        testDeleteAllFromTable(customerDao);
//
//        // get a random id of db record
//        testGetRandomId(customerDao);
//
//        // get a list of X random records ids
//        testGetListOfRandomIds(customerDao, 3);
//
//        // get the count of all records in the table
//        testGetCountOfRecords(customerDao);
//
//        // DATA-MAPPING
//        // extract a single object from the database by ID
//DEMO    // 1. using ResultSet
//        customerDao = new CustomerDaoResultSet();
//        testGetSingleObjectById(customerDao, 6);
//        // 2. using ResultSetMapper
//        customerDao = new CustomerDaoResultSetMapper();
//        testGetSingleObjectById(customerDao, 11);
//DEMO    // 3. using DBUtils
//        customerDao = new CustomerDaoDBUtils();
//        testGetSingleObjectById(customerDao, 8);
//
//        // extract a list of objects from the database by a List of IDs
//        // create a list of customers first
//        List<Integer> customerIds = new ArrayList<>();
//        customerIds.add(2);
//        customerIds.add(7);
//        customerIds.add(9);
//        // 1. using ResultSet
//        customerDao = new CustomerDaoResultSet();
//        testGetListOfObjectsById(customerDao, customerIds);
//DEMO    // 2. using ResultSetMapper
//        customerDao = new CustomerDaoResultSetMapper();
//        testGetListOfObjectsById(customerDao, customerIds);
//        // 3. using DBUtils
//        customerDao = new CustomerDaoDBUtils();
//        testGetListOfObjectsById(customerDao, customerIds);
    }

    // TEST-CONNECTION
    private static void testCreateDbConnectionFactory(FactoryHelper factoryHelper) {

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

    private static void testCreateDbConnectionSingleton(SingletonHelper singletonHelper) {

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

    private static void testCreateSingleCustomer() {
        Customer customer = CustomerHelper.createSingleCustomer();
        System.out.println(customer.toString());
    }

    private static void testCreateMultipleCustomers(int numberOfCustomers) {
        List<Customer> customerList = CustomerHelper.createMultipleCustomers(numberOfCustomers);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }


    // TEST-CRUD-OPERATIONS
    private static void testSaveCustomer(Customer customer, CustomerDao customerDao) {
        // insert new customer in db
        customerDao.save(customer);

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testUpdateCustomer(Customer customer, CustomerDao customerDao, int customerId) {
        // update customer
        customerDao.update(customer, customerId);

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testDeleteCustomer(CustomerDao customerDao, int customerId) {
        // delete customer
        customerDao.delete(customerId);

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testDeleteAllFromTable(CustomerDao customerDao) {
        // truncate table
        customerDao.deleteAll();

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testGetRandomId(CustomerDao customerDao) {
        // get a random id of db record
        customerDao.getRandomId();

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testGetListOfRandomIds(CustomerDao customerDao, int numberOfIds) {
        // get a list of X random records ids
        List<Integer> ids = customerDao.getRandomIds(numberOfIds);
        for (int id : ids) {
            System.out.println("Retrieved random ID: " + id);
        }

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testGetCountOfRecords(CustomerDao customerDao) {
        // get the count of all records in the table
        customerDao.getRecordsCount();

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }


    // TEST-DATA-MAPPING
    private static void testGetSingleObjectById(CustomerDao customerDao, int id) {
        // extract a single object from the database by ID
        customerDao.getById(id);

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }

    private static void testGetListOfObjectsById(CustomerDao customerDao, List<Integer> ids) {
        // extract a list of objects from the database by a List of IDs
        customerDao.getByIds(ids);

        // close db connection after we're done with it
        factoryHelper.closeConnection();
    }
}
