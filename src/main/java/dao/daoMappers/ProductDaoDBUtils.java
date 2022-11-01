package dao.daoMappers;

import constants.SqlQueries;
import dao.baseDaos.ProductDao;
import helpers.daoHelpers.DBUtilsMapperHelper;
import model.Product;

import java.util.List;

public class ProductDaoDBUtils extends ProductDao implements SqlQueries {

    private static DBUtilsMapperHelper<Product> dbUtilsHelper = new DBUtilsMapperHelper<>(Product.class);

    /**
     * Extracts a single product from the database by ID.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param id the id of the product
     * @return Product object
     */
    @Override
    public Product getById(int id) {
        return dbUtilsHelper.getById(id, GET_PRODUCT_BY_ID);
    }

    /**
     * Extracts a list of objects from the database by a List of IDs.
     * Uses Apache DBUtils ResultSetHandler for mapping db data to pojo.
     *
     * @param ids a list of product ids
     * @return a list of Product objects
     */
    @Override
    public List<Product> getByIds(List<Integer> ids) {
        return dbUtilsHelper.getByIds(ids, GET_PRODUCTS_BY_IDS);
    }

    /**
     * Extracts a list of products that correspond to an orderId
     *
     * @param orderId the id of the order that corresponds to these products
     * @return a list of Product objects
     */
    @Override
    public List<Product> getByOrderId(int orderId) {
        return dbUtilsHelper.getListById(orderId, GET_PRODUCTS_BY_ORDER_ID);
    }
}
