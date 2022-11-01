package dao.daoMappers;

import constants.SqlQueries;
import dao.baseDaos.OrderDao;
import dao.baseDaos.ProductDao;
import helpers.daoHelpers.DBUtilsMapperHelper;
import model.Order;

import java.util.List;

public class OrderDaoDBUtils extends OrderDao implements SqlQueries {

    private static DBUtilsMapperHelper<Order> dbUtilsHelper = new DBUtilsMapperHelper<>(Order.class);
    private static ProductDao productDao = new ProductDaoDBUtils();

    /**
     * Extracts a single order from the database by ID.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param id the id of the order
     * @return Order object
     */
    @Override
    public Order getById(int id) {
        return dbUtilsHelper.getById(id, GET_ORDER_BY_ID);
    }

    /**
     * Extracts a list of objects from the database by a List of IDs.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param ids a list of order ids
     * @return a list of Order objects
     */
    @Override
    public List<Order> getByIds(List<Integer> ids) {
        return dbUtilsHelper.getByIds(ids, GET_ORDERS_BY_IDS);
    }

    /**
     * Extracts a list of orders that correspond to a customerId and populates product data for each order
     *
     * @param customerId the id of the customer that corresponds to these orders
     * @return a list of Order objects
     */
    @Override
    public List<Order> getByCustomerId(int customerId) {
        List<Order> orders = dbUtilsHelper.getListById(customerId, GET_ORDER_BY_CUSTOMER_ID);
        for (Order order : orders) {
            order.setProducts(productDao.getByOrderId(order.getId()));
        }
        return orders;
    }
}
