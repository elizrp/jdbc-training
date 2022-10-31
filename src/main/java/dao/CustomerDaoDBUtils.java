package dao;

import constants.SqlQueries;
import helpers.DBUtilsMapperHelper;
import helpers.staticSingletonConnection.StaticSingletonConnectionHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;

/**
 * Class CustomerDaoDBUtils extends functionality of CustomerDao.
 * Provides database methods that use Apache DBUtils.
 */
public class CustomerDaoDBUtils extends CustomerDao {

    private static DBUtilsMapperHelper<Customer> dbUtilsHelper = new DBUtilsMapperHelper<>();

    /**
     * Extracts a single customer from the database by ID.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param id the id of the customer
     * @return Customer object
     */
    @Override
    public Customer getById(int id) {
        return dbUtilsHelper.getById(id, SqlQueries.CUSTOMERS_TABLE, Customer.class);
    }

    /**
     * Extracts a list of objects from the database by a List of IDs.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param ids a list of ids of customers
     * @return a list of Customer objects
     */
    @Override
    public List<Customer> getByIds(List<Integer> ids) {
        return dbUtilsHelper.getByIds(ids, SqlQueries.CUSTOMERS_TABLE, Customer.class);
    }

    public void getCustomerAddressOrderProduct() throws SQLException {
        dbUtilsHelper.getCustomerAddressOrderProduct();
    }
}
