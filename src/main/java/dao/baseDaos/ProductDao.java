package dao.baseDaos;

import constants.SqlQueries;
import dao.DAO;
import helpers.daoHelpers.DaoHelper;
import model.Product;

import java.util.List;
import java.util.logging.Logger;

public abstract class ProductDao implements DAO<Product>, SqlQueries {

    public static final Logger logger = Logger.getLogger(ProductDao.class.getName());
    private static DaoHelper daoHelper = new DaoHelper();

    /**
     * Inserts/Saves a new product in the table.
     *
     * @param product product to be inserted/saved
     */
    @Override
    public void save(Product product) {
        daoHelper.save(String.format(INSERT_PRODUCT, product.getSupplierId(), product.getName(), product.getAvailableQuantity(), product.getType(), product.getPriceWithoutVat(), product.getPriceWithVat(), product.isProductInStock(), product.getWarehouse()));
    }

    /**
     * Updates data of a product.
     *
     * @param product   product object with properties to be used for the update
     * @param productId id of the product to be updated
     */
    @Override
    public void update(Product product, int productId) {
        daoHelper.update(String.format(UPDATE_PRODUCT, product.getName(), product.getAvailableQuantity(),
                product.getType(), product.getPriceWithoutVat(), product.getPriceWithVat(), product.isProductInStock(), product.getWarehouse(), productId));
    }

    /**
     * Deletes a product from the table.
     *
     * @param productId id of the product to be deleted
     */
    @Override
    public void delete(int productId) {
        daoHelper.delete(productId, PRODUCTS_INVENTORY_TABLE);
    }

    /**
     * Deletes all data from products_inventory table.
     */
    @Override
    public void deleteAll() {
        daoHelper.deleteAll(PRODUCTS_INVENTORY_TABLE);
    }

    /**
     * Retrieves a random id from products_inventory table.
     *
     * @return random id of a product
     */
    @Override
    public int getRandomId() {
        return daoHelper.getRandomId(PRODUCTS_INVENTORY_TABLE);
    }

    /**
     * Retrieves a list of random ids from products_inventory table.
     *
     * @param numberOfIds number of ids to be retrieved
     * @return a list of random ids
     */
    @Override
    public List<Integer> getRandomIds(int numberOfIds) {
        return daoHelper.getRandomIds(numberOfIds, PRODUCTS_INVENTORY_TABLE);
    }

    /**
     * Finds the total count of records in products_inventory table.
     *
     * @return count of all records in products_inventory table
     */
    @Override
    public int getRecordsCount() {
        return daoHelper.getRecordsCount(PRODUCTS_INVENTORY_TABLE);
    }

    /**
     * Retrieves a list of Product objects by a given orderId
     *
     * @param orderId the id of the order which corresponds to these products
     * @return a list of Product objects
     */
    public abstract List<Product> getByOrderId(int orderId);
}
