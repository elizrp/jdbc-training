package dao;

import constants.SqlQueries;
import helpers.DaoHelper;
import helpers.staticSingletonConnection.StaticSingletonConnectionHelper;
import model.Address;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AddressDao implements DAO<Address> {

    public static final Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static DaoHelper daoHelper = new DaoHelper();

    /**
     * Inserts/Saves a new address in the table.
     *
     * @param address address to be inserted/saved
     */
    @Override
    public void save(Address address) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(String.format(SqlQueries.INSERT_ADDRESS, address.getAddress(), address.getCity(),
                    address.getProvince(), address.getState(), address.getPostalCode(), address.getCountry()));

            logger.log(Level.INFO, "Address is successfully saved in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates data of an address.
     *
     * @param address   address object with properties to be used for the update
     * @param addressId id of the address to be updated
     */
    @Override
    public void update(Address address, int addressId) {
        try (Connection connection = StaticSingletonConnectionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(String.format(SqlQueries.UPDATE_ADDRESS, address.getAddress(), address.getCity(),
                    address.getProvince(), address.getState(), address.getPostalCode(), address.getCountry(), addressId));

            logger.log(Level.INFO, String.format("Address with id = %d was successfully updated.", addressId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an address from the table.
     *
     * @param addressId id of the address to be deleted
     */
    @Override
    public void delete(int addressId) {
        daoHelper.delete(addressId, SqlQueries.CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Deletes all data from customers_addresses table.
     */
    @Override
    public void deleteAll() {
        daoHelper.deleteAll(SqlQueries.CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Retrieves a random id from customers_addresses table.
     *
     * @return random id of address
     */
    @Override
    public int getRandomId() {
        return daoHelper.getRandomId(SqlQueries.CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Retrieves a list of random ids from customers_addresses table.
     *
     * @param numberOfIds number of ids to be retrieved
     * @return a list of random ids
     */
    @Override
    public List<Integer> getRandomIds(int numberOfIds) {
        return daoHelper.getRandomIds(numberOfIds, SqlQueries.CUSTOMERS_ADDRESSES_TABLE);
    }

    /**
     * Finds the total count of records in customers_addresses table.
     *
     * @return count of all records in customers_addresses table
     */
    @Override
    public int getRecordsCount() {
        return daoHelper.getRecordsCount(SqlQueries.CUSTOMERS_ADDRESSES_TABLE);
    }
}
