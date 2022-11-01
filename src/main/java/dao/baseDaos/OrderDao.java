package dao.baseDaos;

import constants.SqlQueries;
import dao.DAO;
import helpers.daoHelpers.DaoHelper;
import model.Order;

import java.util.List;
import java.util.logging.Logger;

public abstract class OrderDao implements DAO<Order>, SqlQueries {

    public static final Logger logger = Logger.getLogger(OrderDao.class.getName());
    private static DaoHelper daoHelper = new DaoHelper();

    /**
     * Inserts/Saves a new order in the table.
     *
     * @param order order to be inserted/saved
     */
    @Override
    public void save(Order order) {
        daoHelper.save(String.format(INSERT_ORDER, order.getCustomerId(), order.getCustomer(), order.isOrderCompleted(), order.isOrderPaid(), order.getDateOfOrder(), order.getDateOfOrderCompleted()));
    }

    /**
     * Updates data of an order.
     *
     * @param order   order object with properties to be used for the update
     * @param orderId id of the order to be updated
     */
    @Override
    public void update(Order order, int orderId) {
        daoHelper.update(String.format(UPDATE_ORDER, order.getCustomer(), order.isOrderCompleted(), order.isOrderPaid(), order.getDateOfOrder(), order.getDateOfOrderCompleted(), orderId));
    }

    /**
     * Deletes an order from the table.
     *
     * @param orderId id of the order to be deleted
     */
    @Override
    public void delete(int orderId) {
        daoHelper.delete(orderId, ORDERS_TABLE);
    }

    /**
     * Deletes all data from orders table.
     */
    @Override
    public void deleteAll() {
        daoHelper.deleteAll(ORDERS_TABLE);
    }

    /**
     * Retrieves a random id from orders table.
     *
     * @return random id of order
     */
    @Override
    public int getRandomId() {
        return daoHelper.getRandomId(ORDERS_TABLE);
    }

    /**
     * Retrieves a list of random ids from orders table.
     *
     * @param numberOfIds number of ids to be retrieved
     * @return a list of random ids
     */
    @Override
    public List<Integer> getRandomIds(int numberOfIds) {
        return daoHelper.getRandomIds(numberOfIds, ORDERS_TABLE);
    }

    /**
     * Finds the total count of records in orders table.
     *
     * @return count of all records in orders table
     */
    @Override
    public int getRecordsCount() {
        return daoHelper.getRecordsCount(ORDERS_TABLE);
    }

    /**
     * Retrieves a list of Order objects by given customerId
     *
     * @param customerId the id of the customer which corresponds to these orders
     * @return a list of Order objects
     */
    public abstract List<Order> getByCustomerId(int customerId);
}
