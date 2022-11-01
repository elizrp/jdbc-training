package dao.daoMappers;

import dao.baseDaos.AddressDao;
import dao.baseDaos.CustomerDao;
import dao.baseDaos.OrderDao;
import dao.baseDaos.ProductDao;
import helpers.daoHelpers.DBUtilsMapperHelper;
import model.Customer;

import java.util.List;


/**
 * Class CustomerDaoDBUtils extends functionality of CustomerDao.
 * Provides database methods that use Apache DBUtils.
 */
public class CustomerDaoDBUtils extends CustomerDao {

    private static AddressDao addressDao = new AddressDaoDBUtils();
    private static OrderDao orderDao = new OrderDaoDBUtils();
    private static ProductDao productDao = new ProductDaoDBUtils();

    private static DBUtilsMapperHelper<Customer> dbUtilsHelper = new DBUtilsMapperHelper<>(Customer.class);

    /**
     * Extracts a single customer from the database by ID.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param id the id of the customer
     * @return Customer object
     */
    @Override
    public Customer getById(int id) {

        Customer customer = dbUtilsHelper.getById(id, GET_CUSTOMER_BY_ID);
        customer.setAddress(addressDao.getByCustomerId(customer.getId()));
        customer.setOrders(orderDao.getByCustomerId(customer.getId()));
        return customer;
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
        return dbUtilsHelper.getByIds(ids, CUSTOMERS_TABLE);
    }
}
