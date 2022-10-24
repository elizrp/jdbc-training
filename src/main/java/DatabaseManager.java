import constants.SqlQueries;
import dao.CustomerDaoImpl;
import helpers.CustomerHelper;
import helpers.FactoryHelper;
import helpers.SingletonHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseManager {

    private static FactoryHelper factoryHelper;
    private static SingletonHelper singletonHelper;
    private static CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public static void main(String[] args) throws SQLException {

//        // use Factory pattern to create db connection
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
//        // create multiple Customer objects and print their properties
//        testCreateMultipleCustomers(3);
//
//        // create Customer object to test CRUD operations
//        Customer customer = CustomerHelper.createSingleCustomer();
//
//        // insert new customer
//        customerDao.save(customer);
//
//        // update customer
//        customerDao.update(customer, 5);
//
//        // delete customer
//        customerDao.delete(customer, 15);
//
//        // truncate table
//        customerDao.deleteAll();
//
//        // get a random record id
//        customerDao.getRandomId();
//
//        // get a list of X random records ids
//        List<Integer> ids = customerDao.getRandomIds(3);
//        for (int id : ids) {
//            System.out.println("Retrieved random ID: " + id);
//        }
//
//        // get the count of all records in the table
//        customerDao.getRecordsCount();
    }

    private static void testCreateDbConnectionFactory(FactoryHelper factoryHelper) {

        // passed in try-with-resources statement, object 'connection' will be automatically closed at the end
        try (Connection connection = factoryHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlQueries.GET_ALL_CUSTOMERS);) {
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
             ResultSet resultSet = statement.executeQuery(SqlQueries.GET_ALL_CUSTOMERS);) {
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
        for (int index = 0; index < customerList.size(); index++) {
            System.out.println(customerList.get(index).toString());
        }
    }
}
